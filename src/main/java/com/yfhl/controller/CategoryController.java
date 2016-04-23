package com.yfhl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yfhl.entity.Category;
import com.yfhl.mapper.CategoryMapper;
import com.yfhl.service.CategoryService;

/**
 * 商品类别Controller层
 * 
 * @author luans
 * @date 2015年11月23日
 *
 */
@Controller
@RequestMapping("categoryController")
public class CategoryController {
	@Resource
	public CategoryService categoryServiceImpl;// 注入商品类别Service层实例对象
	@Resource
	public CategoryMapper categoryMapper;// 注入商品类别dao层实例对象

	/**
	 * 获取所有商品类别信息
	 * 
	 * @param Category
	 * @return ModelAndView
	 * @date 2015年11月23日
	 * @auther luans
	 */
	@RequestMapping("queryCategory")
	public ModelAndView queryCategory(Category category) {
		ModelAndView mv = new ModelAndView();
		List<Category> list = categoryServiceImpl.queryCategory(category);
		mv.addObject("list", list);
		mv.setViewName("/manager/goodsManage/goodsCategory");
		return mv;
	}

	/**
	 * 去操做商品类别页面：添加、编辑
	 * 
	 * @param Category
	 * @return ModelAndView
	 * @date 2015年11月24日
	 * @auther luans
	 * 
	 */
	@RequestMapping("gotoCategoryManage")
	public ModelAndView gotoCategoryManage(Category category) {
		ModelAndView mv = new ModelAndView();

		if (category.getMarkManage() == 1) {// 去添加商品类别页面
			// 计算排列顺序
			int cgOrder = categoryServiceImpl.getOrder(category.getParentId());
			category.setCgOrder(cgOrder + 1);
		} else if (category.getMarkManage() == 2) {// 去编辑商品类别页面
			// 根据id查询编辑商品类别信息
			Category catey = categoryServiceImpl.queryCategoryById(category
					.getParentId());
			category.setCategoryId(category.getParentId());
			category.setTitle(catey.getTitle());
		}
		mv.addObject("category", category);
		mv.setViewName("/manager/goodsManage/categoryManage");
		return mv;
	}

	/**
	 * 操做商品类别页面：添加、编辑
	 * 
	 * @param Category
	 * @return ModelAndView
	 * @date 2015年11月24日
	 * @auther luans
	 */
	@RequestMapping("categoryManage")
	public ModelAndView categoryManage(Category category) {

		ModelAndView mv = new ModelAndView();
		if (category.getMarkManage() == 1) {// 添加保存
			System.out.println("添加" + category.toString());
			categoryServiceImpl.insert(category);
		} else if (category.getMarkManage() == 2) {// 编辑保存
			System.out.println("修改" + category.toString());
			categoryServiceImpl.updateByPrimaryKeySelective(category);
		}
		mv.addObject("category", category);
		return queryCategory(category);
	}

	/**
	 * 删除商品类目
	 * 
	 * @param Category
	 * @return ModelAndView
	 * @date 2015年11月25日
	 * @auther luans
	 */
	@RequestMapping("delCategory")
	public ModelAndView delCategory(Category category) {
		category.setParentId(category.getCategoryId());
		System.out.println("删除：" + category.toString());
		List<Category> list = categoryMapper.queryCategory(category);// 获取该类别下的所有子类别

		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				categoryServiceImpl.deleteByPrimaryKey(list.get(i)
						.getCategoryId());// 先删除子类别
			}
		}
		// 删除前先修改其后商品类别的排序号
		this.moveOrderDel(category);
		categoryServiceImpl.deleteByPrimaryKey(category.getCategoryId());// 最后删除该类

		return queryCategory(category);
	}

	/**
	 * 上下移动排序
	 * 
	 * @param Category
	 * @return ModelAndView
	 * @date 2015年11月25日
	 * @auther luans
	 */
	@RequestMapping("moveOrder")
	public ModelAndView moveOrder(Category category) {
		Category catey = categoryServiceImpl.queryCategoryById(category
				.getCategoryId());
		catey.setMarkMoveType(category.getMarkMoveType());
		// 先改变目标位置的排列顺序为当前位置
		categoryServiceImpl.moveOrdergoal(catey);
		// 改变自己的位置为目标位置
		categoryServiceImpl.moveOrderTo(catey);
		return queryCategory(category);
	}

	/**
	 * 跳转到选择商品类别页面
	 * 
	 * @param category
	 */
	@RequestMapping("queryCategory_sel")
	public ModelAndView queryCategory_sel(Category category) {
		System.out.println("进入选择页面");
		ModelAndView mv = new ModelAndView();
		List<Category> list = categoryServiceImpl.queryCategory(category);
		mv.addObject("list", list);
		mv.setViewName("/manager/goodsManage/sel_category");
		return mv;
	}

	/**
	 * 自定义内部方法：1.删除类别时，改变同一父类下其后商品类别排列顺序（都减1）
	 * 
	 * @param Category
	 * @date 2015年11月25日
	 * @auther luans
	 */

	public void moveOrderDel(Category category) {
		// 根据id查询编辑商品类别信息
		Category catey = categoryServiceImpl.queryCategoryById(category
				.getCategoryId());
		// 查询所有同一级别下排序在其后的商品类别ID
		List<Integer> list = categoryServiceImpl.getMoveOrderId(catey);
		if (list.size() > 0) {
			catey.setMarkMoveType(1);// 删除是上移
			for (int i = 0; i < list.size(); i++) {
				catey.setCategoryId(list.get(i));
				categoryServiceImpl.moveOrderTo(catey);
			}
		}
	}
}

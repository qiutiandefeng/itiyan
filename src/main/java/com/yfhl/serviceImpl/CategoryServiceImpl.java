package com.yfhl.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yfhl.entity.Category;
import com.yfhl.mapper.CategoryMapper;
import com.yfhl.service.CategoryService;

/**
 * 商品类别Service实现类层
 * 
 * @date 2015年11月23日
 * @author luans
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	@Resource
	public CategoryMapper categoryMapper;// 注入商品类别dao层实例对象

	/**
	 * 根据条件获取商品类别信息
	 * 
	 * @param Category
	 * @return List<Category>
	 * @date 2015年11月23日
	 * @auther luans
	 */
	public List<Category> queryCategory(Category category) {

		category.setParentId(0);// 获取所有父节点ID等于0的商品类别：即所有父类
		List<Category> list = categoryMapper.queryCategory(category);
		Category catey = new Category();
		for (int i = 0; i < list.size(); i++) {
			catey = list.get(i);
			catey.setParentId(catey.getCategoryId());
			list.get(i).setList(categoryMapper.queryCategory(catey));// 循环查询父类下的子类
		}
		return list;
	}

	/**
	 * 计算商品类别在改类别下的顺序
	 * 
	 * @param Integer
	 * @return int
	 * @date 2015年11月24日
	 * @auther luans
	 */
	public int getOrder(Integer pid) {
		return categoryMapper.getOrder(pid);
	}

	/**
	 * 根据ID查询类别名称
	 * 
	 * @param int
	 * @return Category
	 * @date 2015年11月24日
	 * @auther luans
	 */
	public Category queryCategoryById(int id) {
		return categoryMapper.queryCategoryById(id);
	}

	/**
	 * 添加商品类别
	 * 
	 * @param Category
	 * @return int
	 * @date 2015年11月24日
	 * @auther luans
	 */
	public int insert(Category record) {
		return categoryMapper.insert(record);

	}

	/**
	 * 修改商品类别信息
	 * 
	 * @param Category
	 * @return int
	 * @date 2015年11月24日
	 * @auther luans
	 */
	public int updateByPrimaryKeySelective(Category record) {

		return categoryMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 删除商品类目信息
	 * 
	 * @param Integer
	 * @return int
	 * @date 2015年11月25日
	 * @auther luans
	 */
	public int deleteByPrimaryKey(Integer categoryId) {

		return categoryMapper.deleteByPrimaryKey(categoryId);
	}

	/**
	 * 查询所有同一级别下排序在其后的商品类别ID
	 * 
	 * @param Category
	 * @return List<Integer>
	 * @date 2015年11月25日
	 * @auther luans
	 */
	public List<Integer> getMoveOrderId(Category category) {
		return categoryMapper.getMoveOrderId(category);
	}

	/**
	 * 改变位置顺序
	 * 
	 * @param Category
	 * @return int
	 * @date 2015年11月25日
	 * @auther luans
	 */
	public int moveOrderTo(Category category) {
		return categoryMapper.moveOrderTo(category);
	}
	/**
	 * 查询商品类别：PC端首页显示更多产品：最新添加的6个
	 * 
	 * @return List<Category>
	 * @date 2016年3月14日
	 * @auther luans
	 */
	public List<Category> queryCategoryForIndex(){
		return categoryMapper.queryCategoryForIndex();
	}
	/**
	 * 改变目标位置的排列顺序
	 * 
	 * @param Category
	 * @return int
	 * @date 2015年11月25日
	 * @auther luans
	 */
	public int moveOrdergoal(Category category) {
		return categoryMapper.moveOrdergoal(category);
	}

	/**
	 * 获取所有的商品类别
	 * 
	 * @param Category
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月5日
	 */
	@Override
	public List<Category> getModelCategoryAll(Category record) {
		return categoryMapper.getModelCategoryAll(record);
	}

}

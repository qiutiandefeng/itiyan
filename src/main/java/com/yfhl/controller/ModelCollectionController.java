package com.yfhl.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yfhl.entity.ModelCollection;
import com.yfhl.service.ModelCollectionService;
import com.yfhl.service.ModelService;
import com.yfhl.service.UserService;

/**
 * 商品收藏Controller层
 * 
 * @date 2015年12月18日
 * @author luans
 *
 */
@Controller
@RequestMapping("modelCollectionController")
public class ModelCollectionController {
	@Resource
	public ModelCollectionService modelCollentionServiceImpl;// 注入商品收藏Service层实例对象
	@Resource
	public ModelService modelServiceImpl;// 注入商品Service层实例对象
	@Resource
	public UserService userServiceImpl;// 注入用户Service层实例对象

	/**
	 * 添加商品收藏
	 * 
	 * @param ModelCollection
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	@RequestMapping("modelCollection")
	@ResponseBody
	public int modelCollection(ModelCollection modelCollection) {
		System.out.println("收藏商品信息1：" + modelCollection.toString());
		int result = 0;
		if (modelCollection.getMarkType() == 1) {
			// 添加收藏
			result = modelCollentionServiceImpl
					.insertSelective(modelCollection);
		} else if (modelCollection.getMarkType() == 2) {
			// 取消收藏
			result = modelCollentionServiceImpl
					.deleteByPrimaryKey(modelCollection.getMcId());
		}
		if (result == 1) {
			System.out.println("收藏商品信息2：" + modelCollection.toString());
			// 修改商品表收藏数
			result = modelServiceImpl.updateCollection(modelCollection);
			// 修改用户表设计师的喜爱数量
			//result = userServiceImpl.updateCollectionBym(modelCollection);
		}
		return result;
	}

	/**
	 * PC端前台：分页获取我的商品收藏信息
	 * 
	 * @param ModelCollection
	 * @return ModelAndView
	 * @date 2015年12月28日
	 * @auther luans
	 */
	@RequestMapping("queryList")
	public ModelAndView queryList(HttpServletRequest request ,HttpServletResponse response,ModelCollection modelCollection) {
		System.out.println("查询我的收藏条件：" + modelCollection.toString());
		// 判断用户是否登录
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("yfhl_userid");
		if (userid == "" || userid == null) {//
			try {
				response.sendRedirect(request.getContextPath()
						+ "/login/gotoIndexPC.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Integer uid = Integer.parseInt(userid);
		 
		modelCollection.setMcUserid(uid);
		ModelAndView mv = new ModelAndView();
		modelCollection.getPageInfo().setPageSize(12);
		List<ModelCollection> list = modelCollentionServiceImpl
				.queryListByPage(modelCollection);
		list = this.collectionListHandle(list);

		mv.addObject("list", list);
		mv.addObject("modelCollection", modelCollection);
		mv.setViewName("/pc/userManage/userCollection");
		return mv;
	}

	/**
	 * PC端前台：删除收藏
	 * 
	 * @param ModelCollection
	 * @return ModelAndView
	 * @date 2015年12月28日
	 * @auther luans
	 */
	@RequestMapping("delCollection")
	public ModelAndView delCollection(HttpServletRequest request ,
			HttpServletResponse response,ModelCollection modelCollection) {

		Integer mcId = 0;
		String[] midArray = modelCollection.getMarkMID().split(";");
		int length = midArray.length;
		for (int i = 0; i < length; i++) {
			mcId = new Integer(midArray[i]);
			modelCollentionServiceImpl.deleteByPrimaryKey(mcId);
		}

		return queryList(request,response,modelCollection);
	}

	/**
	 * 自定义内部方法：1.整理收藏商品列表展示信息
	 * 
	 * @param List
	 *            <ModelCollection>
	 * @return List<ModelCollection>
	 * @date 2015年12月28日
	 * @auther luans
	 */
	public List<ModelCollection> collectionListHandle(List<ModelCollection> list) {

		ModelCollection mCollection = new ModelCollection();
		for (int i = 0; i < list.size(); i++) {
			// 显示第一张商品图片
			mCollection = list.get(i);
			list.get(i).setModelImg(mCollection.getModelImg().split(";")[0]);
		}

		return list;
	}

}

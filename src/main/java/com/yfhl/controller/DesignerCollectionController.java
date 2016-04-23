package com.yfhl.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yfhl.entity.DesignerCollection;
import com.yfhl.service.DesignerCollectionService;
import com.yfhl.service.UserService;

/**
 * 用户收藏设计师Controller
 * 
 * @date 2015年12月18日
 * @author luans
 *
 */
@Controller
@RequestMapping("designerCollectionController")
public class DesignerCollectionController {

	@Resource
	public DesignerCollectionService designerCollectionServiceImpl;//注入设计师收藏Service层实例对象
	@Resource
	public UserService userServiceImpl;//注入用户Service层实例对象

	/**
	 * 添加商品收藏
	 * 
	 * @param DesignerCollection
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	@RequestMapping("designerCollection")
	@ResponseBody
	public int designerCollection(DesignerCollection designerCollection) {
		System.out.println("designerCollection.toString():"
				+ designerCollection.toString());
		int result = 0;
		if (designerCollection.getMarkType() == 1) {
			// 添加收藏
			result = designerCollectionServiceImpl
					.insertSelective(designerCollection);
		} else if (designerCollection.getMarkType() == 2) {
			// 取消收藏
			result = designerCollectionServiceImpl
					.deleteByPrimaryKey(designerCollection.getDcId());
		}
		if (result == 1) {
			// 修改用户表收藏数
			result = userServiceImpl.updateCollectionByd(designerCollection);
		}
		return result;
	}

}

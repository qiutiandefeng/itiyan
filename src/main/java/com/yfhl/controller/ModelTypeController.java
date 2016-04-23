package com.yfhl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yfhl.entity.ModelType;
import com.yfhl.service.ModelTypeService;

/**
 * 商品规格Controller
 * 
 * @date 2015年12月11日
 * @author luans
 *
 */
@Controller
@RequestMapping("modelTypeController")
public class ModelTypeController {
	@Resource
	public ModelTypeService modelTypeServiceImpl;//注入商品规格Service实例对象

	/**
	 * 添加商品类别
	 * 
	 * @param ModelType
	 * @date 2015年12月11日
	 * @auther luans
	 */
	@RequestMapping("addModelType")
	public void addModelType(ModelType modelType) {

		modelTypeServiceImpl.addModelType(modelType);
		// 回显商品规格数据
		List<ModelType> listold = modelTypeServiceImpl
				.queryModelType(modelType);// 根据外键:商品ID
	}

	/**
	 * 根据商品规格信息查询规格信息：价格、运费
	 * 
	 * @param ModelType
	 * @return Float
	 * @date 2015年12月16日
	 * @auther luans
	 */
	@RequestMapping("queryModelTypeByself")
	@ResponseBody
	public ModelType queryModelTypeByself(ModelType modelType) {
		System.out.println("jinru商品规格信息："+modelType.toString());
		
		ModelType modelt = modelTypeServiceImpl.queryModelTypeByself(modelType);
		//System.out.println("商品规格信息："+modelt.toString());

		return modelt;
	}
}

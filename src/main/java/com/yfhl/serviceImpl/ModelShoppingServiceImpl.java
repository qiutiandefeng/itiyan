package com.yfhl.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yfhl.entity.ModelShopping;
import com.yfhl.mapper.ModelShoppingMapper;
import com.yfhl.service.ModelShoppingService;

/**
 * 
 * 购物车Service实现类
 * 
 * @date 2015年12月21日
 * @author luans
 *
 */
@Service
public class ModelShoppingServiceImpl implements ModelShoppingService {
	@Resource
	public ModelShoppingMapper modelShoppingMapper;// 注入购物车dao层实例对象

	/**
	 * 添加购物车
	 * 
	 * @param ModelShopping
	 * @return int
	 * @date 2015年12月21日
	 * @auther luans
	 */
	public int insertSelective(ModelShopping record) {
		// 添加购物车时间
		record.setMsAddtime(new Date());
		return modelShoppingMapper.insertSelective(record);
	}

	/**
	 * 若是存在相同的购物车信息，只是数量增加
	 * 
	 * @param ModelShopping
	 * @return int
	 * @date 2015年12月21日
	 * @auther luans
	 */
	public int updateShopping(ModelShopping record) {
		record.setMsAddtime(new Date());
		return modelShoppingMapper.updateShopping(record);
	}

	/**
	 * 根据用户ID统计用户购物车中的商品数量
	 * 
	 * @param Integer
	 * @return int
	 * @date 2016年2月26日
	 * @auther luans
	 */
	public int countUserModel(ModelShopping record) {
		return modelShoppingMapper.countUserModel(record);
	}

	/**
	 * 根据购物车ID批量查询购物车信息
	 * 
	 * @param List
	 *            <ModelShopping>
	 * @return String[]
	 * @date 2016年3月1日
	 * @auther luans
	 */
	public List<ModelShopping> queryModelShoppingById(String[] array) {
		return modelShoppingMapper.queryModelShoppingById(array);
	}

	/**
	 * 根据购物车ID统计查询品牌
	 * 
	 * @param String
	 *            []
	 * @return List<String>
	 * @date 2016年3月2日
	 * @auther luans
	 */
	public List<String> queryBrandByShoppingById(String[] array) {
		return modelShoppingMapper.queryBrandByShoppingById(array);
	}

	/**
	 * 根据品牌名称和购物车ID查询购物车信息
	 * 
	 * @param String
	 * @param String
	 *            []
	 * @return List<ModelShopping>
	 * @date 2016年3月2日
	 * @auther luans
	 */
	public List<ModelShopping> queryModelShoppingByBrand(String brand,
			String[] array) {
		return modelShoppingMapper.queryModelShoppingByBrand(brand, array);
	}

	/**
	 * 修改购物车数量 -->
	 * 
	 * @param ModelShopping
	 * @return int
	 * @date 2016年3月2日
	 * @auther luans
	 */
	public int updatemsModcount(ModelShopping modelShopping) {
		return modelShoppingMapper.updatemsModcount(modelShopping);
	}
	/**
	 * 修改购物车数量为当前数量 (立即购买时添加购物车用到)
	 * 
	 * @param ModelShopping
	 * @return int
	 * @date 2016年3月4日
	 * @auther luans
	 */
	public int updateShoppingByviews(ModelShopping modelShopping){
		modelShopping.setMsAddtime(new Date());
		return modelShoppingMapper.updateShoppingByviews(modelShopping);
	}
	/**
	 * 根据购物车部分信息查询购物车全部信息 (立即购买时添加购物车用到)
	 * 
	 * @param ModelShopping
	 * @return ModelShopping
	 * @date 2016年3月4日
	 * @auther luans
	 */
	public ModelShopping queryModelShoppingByviews(ModelShopping modelShopping) {
		return modelShoppingMapper.queryModelShoppingByviews(modelShopping);
	}
	
	/**
	 * 根据用户ID查询用户购物车中的商品数量
	 * 
	 * @param Integer
	 * @return Integer
	 * @date 2016年3月14日
	 * @auther luans
	 */
	public Integer queryModelShoppingCount(Integer userid){
		return modelShoppingMapper.queryModelShoppingCount(userid);
	}

	@Override
	public List<ModelShopping> getModelCartListByUserId(Integer uid) {
		return modelShoppingMapper.getModelCartListByUserId(uid);
	}

	@Override
	public int updateByPrimaryKeySelective(ModelShopping record) {
		return modelShoppingMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer msId) {
		return modelShoppingMapper.deleteByPrimaryKey(msId);
	}

	@Override
	public ModelShopping selectByPrimaryKey(Integer msId) {
		return modelShoppingMapper.selectByPrimaryKey(msId);
	}

	/**
	 * 根据用户的编号查询用户购物车的商品数量
	 * @param uid
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月5日
	 */
	@Override
	public Integer getModelShoppingCount(Integer uid) {
		return modelShoppingMapper.getModelShoppingCount(uid);
	}

}

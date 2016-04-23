package com.yfhl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yfhl.entity.ModelShopping;

/**
 * 购物车dao层
 * 
 * @date 2015年12月21日
 * @author luans
 *
 */
public interface ModelShoppingMapper {
	int deleteByPrimaryKey(Integer msId);

	int insert(ModelShopping record);

	/**
	 * 添加购物车
	 * 
	 * @param ModelShopping
	 * @return int
	 * @date 2015年12月21日
	 * @auther luans
	 */
	public int insertSelective(ModelShopping record);

	ModelShopping selectByPrimaryKey(Integer msId);

	int updateByPrimaryKeySelective(ModelShopping record);

	int updateByPrimaryKey(ModelShopping record);

	/**
	 * 若是存在相同的购物车信息，只是数量增加
	 * 
	 * @param ModelShopping
	 * @return int
	 * @date 2015年12月21日
	 * @auther luans
	 */
	public int updateShopping(ModelShopping record);

	/**
	 * 根据用户ID统计用户购物车中的商品数量
	 * 
	 * @param ModelShopping
	 * @return int
	 * @date 2016年2月26日
	 * @auther luans
	 */
	public int countUserModel(ModelShopping record);

	/**
	 * 根据购物车ID批量查询购物车信息
	 * 
	 * @param List
	 *            <ModelShopping>
	 * @return String[]
	 * @date 2016年3月1日
	 * @auther luans
	 */
	public List<ModelShopping> queryModelShoppingById(String[] array);

	/**
	 * 根据用户编号获取购物车中的商品
	 * 
	 * @param uid
	 * @return List<ModelCart>
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年1月6日
	 */
	public List<ModelShopping> getModelCartListByUserId(Integer uid);

	/**
	 * 根据用户的编号查询用户购物车的商品数量
	 * 
	 * @param uid
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月5日
	 */
	Integer getModelShoppingCount(Integer uid);

	/**
	 * 根据购物车ID统计查询品牌
	 * 
	 * @param String
	 *            []
	 * @return List<String>
	 * @date 2016年3月2日
	 * @auther luans
	 */
	public List<String> queryBrandByShoppingById(String[] array);

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
	public List<ModelShopping> queryModelShoppingByBrand(
			@Param("brand") String brand, @Param("array") String[] array);

	/**
	 * 修改购物车数量
	 * 
	 * @param ModelShopping
	 * @return int
	 * @date 2016年3月2日
	 * @auther luans
	 */
	public int updatemsModcount(ModelShopping modelShopping);

	/**
	 * 修改购物车数量为当前数量 (立即购买时添加购物车用到)
	 * 
	 * @param ModelShopping
	 * @return int
	 * @date 2016年3月4日
	 * @auther luans
	 */
	public int updateShoppingByviews(ModelShopping modelShopping);

	/**
	 * 根据购物车部分信息查询购物车全部信息 (立即购买时添加购物车用到)
	 * 
	 * @param ModelShopping
	 * @return ModelShopping
	 * @date 2016年3月4日
	 * @auther luans
	 */
	public ModelShopping queryModelShoppingByviews(ModelShopping modelShopping);

	/**
	 * 根据用户ID查询用户购物车中的商品数量
	 * 
	 * @param Integer
	 * @return Integer
	 * @date 2016年3月14日
	 * @auther luans
	 */
	public Integer queryModelShoppingCount(@Param("userid")Integer userid);
}
package com.yfhl.service;

import java.util.List;

import com.yfhl.entity.ModelCollection;

/**
 * 商品收藏Service层
 * 
 * @date 2015年12月18日
 * @author luans
 *
 */
public interface ModelCollectionService {

	/**
	 * 添加商品收藏
	 * 
	 * @param ModelCollection
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int insertSelective(ModelCollection record);

	/**
	 * 取消商品收藏
	 * 
	 * @param Integer
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int deleteByPrimaryKey(Integer mcId);

	/**
	 * 查询商品收藏信息
	 * 
	 * @param ModelCollection
	 * @return ModelCollection
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public ModelCollection queryModelCollection(ModelCollection record);

	/**
	 * 统计判断用户对该商品是否收藏
	 * 
	 * @param ModelCollection
	 * @return Integer
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public Integer queryCount(ModelCollection record);

	/**
	 * 查询商品收藏ID
	 * 
	 * @param ModelCollection
	 * @return Integer
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public Integer queryId(ModelCollection record);

	/**
	 * 分页查询用户List
	 * 
	 * @param ModelCollection
	 * @return List<ModelCollection>
	 * @date 2015年12月28日
	 * @auther luans
	 */
	public List<ModelCollection> queryListByPage(ModelCollection record);

	/**
	 * 根据商品的编号 查询此商品被关注的数量
	 * @param mid
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月5日
	 */
	public Integer getModelConllection(Integer mid);
}

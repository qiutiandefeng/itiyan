package com.yfhl.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yfhl.entity.ModelCollection;
import com.yfhl.mapper.ModelCollectionMapper;
import com.yfhl.service.ModelCollectionService;

/**
 * 商品收藏Servie实现类层
 * 
 * @date 2015年12月18日
 * @author luans
 *
 */
@Service
public class ModelCollectionServiceImpl implements ModelCollectionService {

	@Resource
	public ModelCollectionMapper modelCollectionMapper;// 注入商品收藏dao层实例对象

	/**
	 * 添加商品收藏
	 * 
	 * @param ModelCollection
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int insertSelective(ModelCollection record) {

		return modelCollectionMapper.insertSelective(record);
	}

	/**
	 * 取消商品收藏
	 * 
	 * @param Integer
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int deleteByPrimaryKey(Integer mcId) {
		return modelCollectionMapper.deleteByPrimaryKey(mcId);
	}

	/**
	 * 查询商品收藏信息
	 * 
	 * @param ModelCollection
	 * @return ModelCollection
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public ModelCollection queryModelCollection(ModelCollection record) {
		return modelCollectionMapper.queryModelCollection(record);
	}

	/**
	 * 统计判断用户对该商品是否收藏
	 * 
	 * 
	 * @param ModelCollection
	 * @return Integer
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public Integer queryCount(ModelCollection record) {
		return modelCollectionMapper.queryCount(record);
	}

	/**
	 * 查询商品收藏ID
	 * 
	 * @param ModelCollection
	 * @return Integer
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public Integer queryId(ModelCollection record) {
		return modelCollectionMapper.queryId(record);
	}

	/**
	 * 分页查询用户List
	 * 
	 * @param ModelCollection
	 * @return List<ModelCollection>
	 * @date 2015年12月28日
	 * @auther luans
	 */
	public List<ModelCollection> queryListByPage(ModelCollection record) {
		return modelCollectionMapper.queryListByPage(record);
	}
	
	/**
	 * 根据商品的编号 查询此商品被关注的数量
	 * @param mid
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月5日
	 */
	public Integer getModelConllection(Integer mid)
	{
		Integer count = modelCollectionMapper.getModelConllection(mid);
		return count;
	}
}

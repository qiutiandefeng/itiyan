package com.yfhl.mapper;

import java.util.List;

import com.yfhl.entity.Recent;

/**
 * 最近浏览商品dao层
 * 
 * @date 2015年12月14日
 * @author luans
 *
 */
public interface RecentMapper {

	/**
	 * 根据条件查询商品浏览记录
	 * 
	 * @param Recent
	 * @return List<Recent>
	 * @date 2015年12月14日
	 * @auther luans
	 */
	public List<Recent> queryRecent(Recent recent);

	/**
	 * 添加商品浏览记录
	 * 
	 * @param Recent
	 * @return int
	 * @date 2015年12月14日
	 * @auther luans
	 */
	public int insertSelective(Recent record);
	
	/**
	 * 修改商品浏览记录
	 * 
	 * @param Recent
	 * @return int
	 * @date 2016年3月22日
	 * @auther luans
	 */
	public int updateRecent(Recent record);

	int deleteByPrimaryKey(Integer rid);

	int insert(Recent record);

	Recent selectByPrimaryKey(Integer rid);

	int updateByPrimaryKeySelective(Recent record);

	int updateByPrimaryKey(Recent record);

}
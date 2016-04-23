package com.yfhl.service;

import java.util.List;

import com.yfhl.entity.Recent;

/**
 * 商品浏览记录Service层
 * 
 * @date 2015年12月14日
 * @author luans
 *
 */
public interface RecentService {

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
  
}

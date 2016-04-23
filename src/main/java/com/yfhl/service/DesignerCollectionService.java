package com.yfhl.service;

import com.yfhl.entity.DesignerCollection;

/**
 * 用户收藏设计师Service层
 * 
 * @date 2015年12月18日
 * @author luans
 *
 */
public interface DesignerCollectionService {
	/**
	 * 用户添加收藏设计师
	 * 
	 * @param DesignerCollection
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int insertSelective(DesignerCollection record);

	/**
	 * 删除收藏
	 * 
	 * @param Integer
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int deleteByPrimaryKey(Integer dcId);

	/**
	 * 查询设计师被收藏ID
	 * 
	 * @param DesignerCollection
	 * @return Integer
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public Integer queryId(DesignerCollection record);

	/**
	 * 统计判断用户对该设计师是否收藏
	 * 
	 * @param DesignerCollection
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int queryCount(DesignerCollection record);
}

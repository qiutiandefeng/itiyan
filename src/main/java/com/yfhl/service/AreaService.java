package com.yfhl.service;

import java.util.List;

import com.yfhl.entity.Area;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2016年1月9日 下午6:52:27 类说明
 */
public interface AreaService {

	int deleteByPrimaryKey(Integer id);

	int insert(Area record);

	int insertSelective(Area record);

	Area selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Area record);

	int updateByPrimaryKey(Area record);

	/**
	 * 根据上级所属编号查询城市集合
	 * 
	 * @param parentId
	 * @return List<Area>
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年1月11日
	 */
	List<Area> getAreaListByParentId(Integer parentId);
 
}

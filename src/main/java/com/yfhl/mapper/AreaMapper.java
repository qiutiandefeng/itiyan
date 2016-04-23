package com.yfhl.mapper;

import java.util.List;

import com.yfhl.entity.Area;

public interface AreaMapper {
    int deleteByPrimaryKey(Long id);

	int insert(Area record);

	int insertSelective(Area record);

	Area selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Area record);

	int updateByPrimaryKey(Area record);

	int deleteByPrimaryKey(Integer id);

    Area selectByPrimaryKey(Integer id);

    /**
     * 根据父级城市编号查询城市集合
     * @param parentId
     * @return List<Area>
     * @author Chris li Email:lj520212@gmail.com
     * @date 2016
     */
	List<Area> getAreaListByParentId(Integer parentId);
 
}
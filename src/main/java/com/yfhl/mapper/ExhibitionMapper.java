package com.yfhl.mapper;

import org.apache.ibatis.annotations.Param;

import com.yfhl.entity.Exhibition;

public interface ExhibitionMapper {
    
	int deleteByPrimaryKey(Integer mid);

    int insert(Exhibition record);

    int insertSelective(Exhibition record);

    Exhibition selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Exhibition record);

    int updateByPrimaryKeyWithBLOBs(Exhibition record);

    int updateByPrimaryKey(Exhibition record);

	int getCountExhibitionByTime(@Param("startTime")String startTime, @Param("endTime")String endTime);
}
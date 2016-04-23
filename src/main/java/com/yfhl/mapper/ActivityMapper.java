package com.yfhl.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.yfhl.entity.Activity;
/**
 * 活动dao层
 * @author luans
 *
 */

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

	Activity getActivityByActivityIdAndTime(@Param("activityId")Integer activityId, @Param("date")Date date);
}
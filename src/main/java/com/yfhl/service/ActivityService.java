package com.yfhl.service;

import java.util.Date;

import com.yfhl.entity.Activity;


public interface ActivityService {
	
	int deleteByPrimaryKey(Integer id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

	boolean getActivityByTime(Date endDate);

	/**
	 * ���ݻ�ı�ź�ʱ�� ��ѯ�Ƿ���Ч
	 * @param activityId
	 * @param date
	 * @return Activity
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016��1��11��
	 */
	Activity getActivityByActivityIdAndTime(Integer activityId, Date date);

}

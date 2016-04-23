package com.yfhl.serviceImpl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yfhl.entity.Activity;
import com.yfhl.mapper.ActivityMapper;
import com.yfhl.service.ActivityService;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

	@Resource
	private ActivityMapper activityMapper;
	
	public int deleteByPrimaryKey(Integer id) {
		return activityMapper.deleteByPrimaryKey(id);
	}

	public int insert(Activity record) {
		return activityMapper.insert(record);
	}

	public int insertSelective(Activity record) {
		return activityMapper.insertSelective(record);
	}

	public Activity selectByPrimaryKey(Integer id) {
		return activityMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Activity record) {
		return activityMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Activity record) {
		return activityMapper.updateByPrimaryKey(record);
	}

	public boolean getActivityByTime(Date endDate) {
		return false;
	}

	public Activity getActivityByActivityIdAndTime(Integer activityId, Date date) {
		return activityMapper.getActivityByActivityIdAndTime(activityId,date);
	}

}

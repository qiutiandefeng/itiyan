package com.yfhl.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yfhl.entity.CheapCode;
import com.yfhl.mapper.CheapCodeMapper;
import com.yfhl.service.CheapCodeService;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2016年1月11日 上午2:51:03
 * 类说明
 */
@Service
@Transactional
public class CheapCodeServiceImpl implements CheapCodeService {

	@Resource
	private CheapCodeMapper cheapCodeMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return cheapCodeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(CheapCode record) {
		return cheapCodeMapper.insert(record);
	}

	@Override
	public int insertSelective(CheapCode record) {
		return cheapCodeMapper.insertSelective(record);
	}

	@Override
	public CheapCode selectByPrimaryKey(Integer id) {
		return cheapCodeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CheapCode record) {
		return cheapCodeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(CheapCode record) {
		return cheapCodeMapper.updateByPrimaryKey(record);
	}

	@Override
	public CheapCode getCheapCodeByActivityId(Integer activityId) {
		return cheapCodeMapper.getCheapCodeByActivityId(activityId);
	}

}

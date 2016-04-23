package com.yfhl.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yfhl.entity.UserCode;
import com.yfhl.mapper.UserCodeMapper;
import com.yfhl.service.UserCodeService;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2016年1月11日 上午2:43:00
 * 类说明
 */
@Service
@Transactional
public class UserCodeServiceImpl implements UserCodeService {

	@Resource
	private UserCodeMapper userCodeMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userCodeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserCode record) {
		return userCodeMapper.insert(record);
	}

	@Override
	public int insertSelective(UserCode record) {
		return userCodeMapper.insertSelective(record);
	}

	@Override
	public UserCode selectByPrimaryKey(Integer id) {
		return userCodeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(UserCode record) {
		return userCodeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserCode record) {
		return userCodeMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<UserCode> getUserCodeListByUid(Integer uid) {
		return userCodeMapper.getUserCodeListByUid(uid);
	}

}

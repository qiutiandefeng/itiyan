package com.yfhl.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yfhl.entity.Area;
import com.yfhl.mapper.AreaMapper;
import com.yfhl.service.AreaService;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2016年1月9日 下午6:53:01
 * 类说明
 */
@Transactional
@Service
public class AreaServiceImpl implements AreaService {

	@Resource
	private AreaMapper areaMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return areaMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Area record) {
		return areaMapper.insert(record);
	}

	@Override
	public int insertSelective(Area record) {
		return areaMapper.insertSelective(record);
	}

	@Override
	public Area selectByPrimaryKey(Integer id) {
		return areaMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Area record) {
		return areaMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Area record) {
		return areaMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Area> getAreaListByParentId(Integer parentId) {
		return areaMapper.getAreaListByParentId(parentId);
	}
 
}

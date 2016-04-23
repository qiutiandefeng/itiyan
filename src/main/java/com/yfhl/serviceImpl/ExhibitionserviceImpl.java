package com.yfhl.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yfhl.entity.Exhibition;
import com.yfhl.mapper.ExhibitionMapper;
import com.yfhl.service.Exhibitionservice;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年11月13日 下午9:02:55
 * 类说明
 */
@Service
public class ExhibitionserviceImpl implements Exhibitionservice {

	
	@Resource
	private ExhibitionMapper exhibitionMapper;
	
	public int deleteByPrimaryKey(Integer mid) {
		// TODO Auto-generated method stub
		return exhibitionMapper.deleteByPrimaryKey(mid);
	}

	public int insert(Exhibition record) {
		// TODO Auto-generated method stub
		return exhibitionMapper.insert(record);
	}

	public int insertSelective(Exhibition record) {
		// TODO Auto-generated method stub
		return exhibitionMapper.insertSelective(record);
	}

	public Exhibition selectByPrimaryKey(Integer mid) {
		// TODO Auto-generated method stub
		return exhibitionMapper.selectByPrimaryKey(mid);
	}

	public int updateByPrimaryKeySelective(Exhibition record) {
		// TODO Auto-generated method stub
		return exhibitionMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyWithBLOBs(Exhibition record) {
		// TODO Auto-generated method stub
		return exhibitionMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	public int updateByPrimaryKey(Exhibition record) {
		// TODO Auto-generated method stub
		return exhibitionMapper.updateByPrimaryKey(record);
	}

	public int getCountExhibitionByTime(String startTime, String endTime) {
		// TODO Auto-generated method stub
		return exhibitionMapper.getCountExhibitionByTime(startTime,endTime);
	}

}

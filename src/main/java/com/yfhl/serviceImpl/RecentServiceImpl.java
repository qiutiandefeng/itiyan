package com.yfhl.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yfhl.entity.Recent;
import com.yfhl.mapper.RecentMapper;
import com.yfhl.service.RecentService;

/**
 * 商品浏览记录Service实现类
 * 
 * @date 2015年12月14日
 * @author luans
 *
 */
@Service
public class RecentServiceImpl implements RecentService {
	@Resource
	public RecentMapper recentMapper;// 注入最近浏览dao层实例对象

	/**
	 * 根据条件查询商品浏览记录
	 * 
	 * @param Recent
	 * @return List<Recent>
	 * @date 2015年12月14日
	 * @auther luans
	 */
	public List<Recent> queryRecent(Recent recent) {
		return recentMapper.queryRecent(recent);
	}

	/**
	 * 添加商品浏览记录
	 * 
	 * @param Recent
	 * @return int
	 * @date 2015年12月14日
	 * @auther luans
	 */
	public int insertSelective(Recent record) {
		return recentMapper.insertSelective(record);
	}

	/**
	 * 修改商品浏览记录
	 * 
	 * @param Recent
	 * @return int
	 * @date 2016年3月22日
	 * @auther luans
	 */
	public int updateRecent(Recent record) {
		record.setrTime(new Date());
		return recentMapper.updateRecent(record);
	}

}

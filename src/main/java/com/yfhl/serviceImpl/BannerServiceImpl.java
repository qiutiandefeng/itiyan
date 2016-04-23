package com.yfhl.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yfhl.entity.Banner;
import com.yfhl.mapper.BannerMapper;
import com.yfhl.service.BannerService;

/**
 * banner管理Service实现类层
 * 
 * @author luans
 * @date 2016年3月16日
 *
 */
@Service
public class BannerServiceImpl implements BannerService {

	@Resource
	private BannerMapper bannerMapper;

	/**
	 * 添加banner
	 * 
	 * @param Banner
	 * @return int
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	public int insertSelective(Banner record) {
		record.setBanAddtime(new Date());// 添加时间
		record.setBanDelete(1);// 删除状态：1：正常；2：删除
		return bannerMapper.insertSelective(record);
	}

	/**
	 * 修改banner
	 * 
	 * @param Banner
	 * @return int
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	public int updateByPrimaryKeySelective(Banner record) {
		return bannerMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 删除banner（假删除）
	 * 
	 * @param Banner
	 * @return int
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	public int delBanner(Banner record) {
		return bannerMapper.delBanner(record);
	}

	/**
	 * 分页查询banner
	 * 
	 * @param Banner
	 * @return List<Banner>
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	public List<Banner> queryListByPage(Banner banner) {
		return bannerMapper.queryListByPage(banner);
	}

	/**
	 * 根据bannerid 查询banner详细信息
	 * 
	 * @param Banner
	 * @return Banner
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	public Banner selectByPrimaryKey(Integer bannerid) {
		return bannerMapper.selectByPrimaryKey(bannerid);
	}

	/**
	 * 设置banner显示操作
	 * 
	 * @param Banner
	 * @return int
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	public int setBannerShow(Banner banner) {
		return bannerMapper.setBannerShow(banner);
	}

	/**
	 * 查询banner显示信息：PC端
	 * 
	 * @return List<Banner>
	 * @author luans
	 * @date 2016年3月19日
	 *
	 */
	public List<Banner> queryBannerforPC() {
		return bannerMapper.queryBannerforPC();
	}
	/**
	 * 查询banner显示信息：微信端
	 * 
	 * @return List<Banner>
	 * @author luans
	 * @date 2016年3月21日
	 *
	 */
	public List<Banner> queryBannerforWX(){
		return bannerMapper.queryBannerforWX();
	}
}

package com.yfhl.service;

import java.util.List;

import com.yfhl.entity.Banner;

/**
 * banner管理Service层
 * 
 * @author luans
 * @date 2016年3月16日
 *
 */
public interface BannerService {

	/**
	 * 添加banner
	 * 
	 * @param Banner
	 * @return int
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	public int insertSelective(Banner record);

	/**
	 * 修改banner
	 * 
	 * @param Banner
	 * @return int
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	public int updateByPrimaryKeySelective(Banner record);

	/**
	 * 删除banner（假删除）
	 * 
	 * @param Banner
	 * @return int
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	public int delBanner(Banner record);

	/**
	 * 分页查询banner
	 * 
	 * @param Banner
	 * @return List<Banner>
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	public List<Banner> queryListByPage(Banner banner);

	/**
	 * 根据bannerid 查询banner详细信息
	 * 
	 * @param Banner
	 * @return Banner
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	public Banner selectByPrimaryKey(Integer bannerid);

	/**
	 * 设置banner显示操作
	 * 
	 * @param Banner
	 * @return int
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	public int setBannerShow(Banner banner);

	/**
	 * 查询banner显示信息：PC端
	 * 
	 * @return List<Banner>
	 * @author luans
	 * @date 2016年3月19日
	 *
	 */
	public List<Banner> queryBannerforPC();
	/**
	 * 查询banner显示信息：微信端
	 * 
	 * @return List<Banner>
	 * @author luans
	 * @date 2016年3月21日
	 *
	 */
	public List<Banner> queryBannerforWX();
}

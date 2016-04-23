package com.yfhl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yfhl.entity.Banner;
import com.yfhl.service.BannerService;

/**
 * banner管理Controller层
 * 
 * @author luans
 * @date 2016年3月16日
 *
 */
@Controller
@RequestMapping("bannerController")
public class BannerController {

	@Resource
	private BannerService bannerService;// 注入banner Service层实例对象

	/**
	 * 去banner操作页面
	 * 
	 * @param Banner
	 * @return ModelAndView
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	@RequestMapping("gotobannerManage")
	public ModelAndView gotobannerManage(Banner banner) {
		ModelAndView mv = new ModelAndView();
		if (banner.getMarkManage() == 1) {// 去添加页面
			System.out.println("进入添加商品页面");
			mv.addObject("banner", banner);

		} else if (banner.getMarkManage() == 2 || banner.getMarkManage() == 3) {// 去修改页面
			Banner bannernew = bannerService.selectByPrimaryKey(banner
					.getBannerid());
			bannernew.setMarkManage(banner.getMarkManage());
			bannernew.getPageInfo().setPageIndex(
					banner.getPageInfo().getPageIndex());
			bannernew.setCondition(banner.getCondition());
			bannernew.setBanStation_sel(banner.getBanStation_sel());
			mv.addObject("banner", bannernew);

		} 
		mv.setViewName("/manager/generalize/bannerManage");
		return mv;
	}

	/**
	 * banner操作：添加、修改、查看
	 * 
	 * @param Banner
	 * @return ModelAndView
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	@RequestMapping("bannerManage")
	public ModelAndView bannerManage(Banner banner) {
		ModelAndView mv = new ModelAndView();
		int result = 0;
		if (banner.getMarkManage() == 1) {// 添加
			result = bannerService.insertSelective(banner);
		} else if (banner.getMarkManage() == 2) {// 修改
			System.out.println("修改："+banner.toString());
			result = bannerService.updateByPrimaryKeySelective(banner);
		}
		mv.addObject("result", result);
		return queryListByPage(banner);
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
	@RequestMapping("delBanner")
	public ModelAndView delBanner(Banner record) {
		ModelAndView mv = new ModelAndView();
		int result = bannerService.delBanner(record);
		mv.addObject("result", result);

		return queryListByPage(record);
	}

	/**
	 * 设置banner显示操作
	 * 
	 * @param Banner
	 * @return ModelAndView
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	@RequestMapping("setBannerShow")
	public ModelAndView setBannerShow(Banner banner) {
		ModelAndView mv = new ModelAndView();
		int result = bannerService.setBannerShow(banner);
		mv.addObject("result", result);
		return queryListByPage(banner);
	}

	/**
	 * 分页查询banner
	 * 
	 * @param Banner
	 * @return ModelAndView
	 * @author luans
	 * @date 2016年3月16日
	 *
	 */
	@RequestMapping("queryListByPage")
	public ModelAndView queryListByPage(Banner banner) {
		System.out.println(banner.toString());
		ModelAndView mv = new ModelAndView();
		banner.getPageInfo().setPageSize(10);
		List<Banner> bannerList = bannerService.queryListByPage(banner);
		System.out.println("商品数量："+bannerList.size());
		mv.addObject("bannerList", bannerList);
		mv.setViewName("/manager/generalize/bannerList");
		return mv;
	}

}

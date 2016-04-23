package com.yfhl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 中转页面Controller
 * 
 * @author luans
 * @date 2016年3月22日
 */
@Controller
@RequestMapping("turncenterController")
public class TurncenterController {

	/**
	 * 去底部PC端页面底部页面
	 * 
	 * @param markerPage跳转的页面
	 * @param station显示的位置
	 * @return ModelAndView
	 * @author luans
	 * @date 2016年3月22日
	 */
	@RequestMapping("turnBottom")
	public ModelAndView turnBottom(HttpServletRequest request,
			Integer markerPage) {
		
		ModelAndView mv = new ModelAndView();
		if (markerPage == 1) {// 关于我们
			mv.setViewName("/pc/other/aboutUsPage");
		} else if (markerPage == 2) {// 加入我们
			mv.setViewName("/pc/other/joinUsPage");
		} else if (markerPage == 3) {// 品牌合作
			mv.setViewName("/pc/other/partnerPage");
		} else if (markerPage == 4) {// 帮助中心
			mv.setViewName("/pc/other/helpPage");
		}else if(markerPage==5){//入驻
			mv.setViewName("/pc/other/designerJoin");
		}

		return mv;
	}

}

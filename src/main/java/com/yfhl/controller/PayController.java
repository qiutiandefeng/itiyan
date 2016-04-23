package com.yfhl.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2016年3月21日 下午11:53:13
 * 类说明
 */
@Controller
public class PayController {

	@RequestMapping("pay")
	public String pay(){
		return "/pay/jsapi";
	}
	
	@RequestMapping("alipayApi")
	public ModelAndView alipayApi(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView();
		
		try {
			mv.addObject("WIDout_trade_no",(String)request.getParameter("WIDout_trade_no"));
			mv.addObject("WIDsubject",new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8"));
			mv.addObject("WIDtotal_fee",(String)request.getParameter("WIDtotal_fee"));
			mv.addObject("WIDbody",new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8"));
	//		mv.addObject("WIDshow_url",new String(request.getParameter("WIDshow_url").getBytes("ISO-8859-1"),"UTF-8"));
			mv.setViewName("pay/alipayapi");
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("notifyUrl")
	public ModelAndView notify_url(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("WIDout_trade_no",new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8"));
			mv.addObject("WIDsubject",new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8"));
			mv.addObject("WIDtotal_fee",new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8"));
			mv.setViewName("pay/notify_url");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("returnUrl")
	public ModelAndView return_url(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("WIDout_trade_no",new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8"));
			mv.addObject("WIDsubject",new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8"));
			mv.addObject("WIDtotal_fee",new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8"));
			mv.setViewName("pay/notify_url");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mv;
	}
}

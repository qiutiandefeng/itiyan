package com.yfhl.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yfhl.entity.Area;
import com.yfhl.entity.UserAddress;
import com.yfhl.interceptor.ExceptionHandler;
import com.yfhl.service.AreaService;
import com.yfhl.service.UserAddressService;

/**
 * 用户收货地址Controller层
 * 
 * @date 2015年12月27日
 * @author luans
 *
 */
@Controller
@RequestMapping("userAddressController")
public class UserAddressController {

	@Resource
	private UserAddressService userAddressServiceImpl;// 注入用户地址Service层实例对象

	@Resource
	private AreaService areaService;

	/**
	 * 查询用户收货地址信息
	 * 
	 * @param UserAddress
	 * @return ModelAndView
	 * @date 2015年12月27日
	 * @auther luans
	 */
	@RequestMapping("queryUserAddress")
	public ModelAndView queryUserAddress(HttpServletRequest request,
			HttpServletResponse response, UserAddress userAddress) {
		ModelAndView mv = new ModelAndView();
		System.out.println("查询用户收货地址条件信息：" + userAddress.toString());
		// 判断用户是否登录
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("yfhl_userid");
		if (userid == "" || userid == null) {//
			try {
				response.sendRedirect(request.getContextPath()
						+ "/login/gotoIndexPC.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Integer uid = Integer.parseInt(userid);
		userAddress.setUid(uid);
		List<UserAddress> list = userAddressServiceImpl
				.queryUserAddressByUid(userAddress.getUid());
		mv.addObject("list", list);
		mv.setViewName("/pc/userManage/userAddress");
		return mv;
	}

	/**
	 * 删除用户收货地址信息
	 * 
	 * @param UserAddress
	 * @return Integer
	 * @date 2015年12月27日
	 * @auther luans
	 */
	@RequestMapping("delUserAddress")
	@ResponseBody
	public Integer delUserAddress(UserAddress userAddress) {
		System.out.println("删除用户收货地址条件信息：" + userAddress.toString());
		int result = userAddressServiceImpl.deleteByPrimaryKey(userAddress
				.getId());
		return result;
	}

	/**
	 * 用户收货地址信息操作：添加、修改
	 * 
	 * @param UserAddress
	 * @return Integer
	 * @date 2015年12月27日
	 * @auther luans
	 */
	@RequestMapping("updateUserAddress")
	@ResponseBody
	public Integer updateUserAddress(UserAddress userAddress) {

		System.out.println("修改用户收货地址条件信息：" + userAddress.toString());

		int result = userAddressServiceImpl
				.updateByPrimaryKeySelective(userAddress);
		return result;
	}

	/**
	 * 设置为默认地址
	 * 
	 * @param UserAddress
	 * @return Integer
	 * @date 2015年12月27日
	 * @auther luans
	 */
	@RequestMapping("setDefault")
	@ResponseBody
	public Integer setDefault(UserAddress userAddress) {
		System.out.println("设置默认收货地址信息：" + userAddress.toString());
		int result = 0;
		// 1.取消之前的默认地址
		result = userAddressServiceImpl.clearDefault(userAddress.getUid());
		if (result > 0) {
			// 2.设置新的默认地址
			result = userAddressServiceImpl.setDefault(userAddress.getId());
		}
		return result;
	}

	/**
	 * 添加用户收货地址
	 * 
	 * @param UserAddress
	 * @return Integer
	 * @date 2015年12月27日
	 * @auther luans
	 */
	public ModelAndView addUserAddress(HttpServletRequest request,
			HttpServletResponse response, UserAddress userAddress) {

		return queryUserAddress(request, response, userAddress);
	}
	
	/**
	 * 获取用户收货地址
	 * @param request
	 * @param response
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月15日
	 */
	@RequestMapping("getParAddress")
	@ResponseBody
	public Map<Object, Object> getParAddress(HttpServletRequest request,
			HttpServletResponse response) {

		Map<Object, Object> map = new HashMap<Object, Object>();
		String parentStr = request.getParameter("parentId");
		if (parentStr == null || "".equals(parentStr)) {
			map.put("state", 0);
			map.put("body", new ArrayList<Area>());
			map.put("value", "参数有误");
			return map;
		}
		Integer parentId = Integer.valueOf(parentStr);
		List<Area> areaList = new ArrayList<Area>();
		areaList = areaService.getAreaListByParentId(parentId);
		if (areaList.size() == 0) {
			map.put("state", 0);
			map.put("body", new ArrayList<Area>());
			map.put("value", "获取失败");
		} else {
			map.put("state", 1);
			map.put("body", areaList);
			map.put("value", "获取成功");
		}
		return map;
	}

}

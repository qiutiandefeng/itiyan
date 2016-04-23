package com.yfhl.util;

import java.util.Date;

import javax.annotation.Resource;

import com.yfhl.service.ActivityService;
import com.yfhl.service.ModelService;
import com.yfhl.service.ModelShoppingService;
import com.yfhl.service.ModelTypeService;
import com.yfhl.service.UserService;

/**
 * 加入购物车、结算、提交订单、支付等校验
 * @author M-J
 *
 */
public class DataJiaoyan {

	@Resource
	private UserService userService;
	
	@Resource
	private ModelService modelService;
	
	@Resource
	private ModelShoppingService modelShoppingService;
	
	@Resource
	private ModelTypeService modelTypeService;
	
	@Resource
	private ActivityService activityService;
	
	/**
	 * 优惠券的时间校验 查看是否存在这个时间段优惠券可以用
	 * @param satrt
	 * @param end
	 * @param uid
	 * @param modelId
	 * @return
	 */
	public boolean modelCartAdd(Date endDate, Integer uid, Integer modelId)
	{
		boolean falg = false;
		
		if (uid ==null && endDate ==null || "".equals(endDate) && modelId ==null)
		{
			return false;
		}
		//判断加入购物车商品是否正确
		boolean cartFalg = activityService.getActivityByTime(endDate);
		
		if (cartFalg)
		{
			
		}
		
		
		return falg;
	}
	
	
	/**
	 * 根据时间和用户、商品 判断结算交易是否可行
	 * @param start
	 * @param end
	 * @param uid
	 * @param modelId
	 * @return
	 */
	public boolean modelSettlementAdd(Date start, Date end, Integer uid, Integer modelId)
	{
		boolean falg = false;
		
		if (uid ==null && end ==null || "".equals(end) && start ==null && modelId ==null)
		{
			return false;
		}
		
		
		
		return falg;
	}
}

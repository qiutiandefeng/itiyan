package com.yfhl.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yfhl.entity.Trade;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年11月13日 下午9:30:33 类说明
 */
public interface TradeService {

	int deleteByPrimaryKey(Integer id);

	int insert(Trade record);

	Trade selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Trade record);

	int updateByPrimaryKey(Trade record);

	/**
	 * 根据时间段查询订单的增长数
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年11月13日
	 */
	int getCountTradeByTime(String startTime, String endTime);

	/**
	 * 根据订单实体分页查询
	 * 
	 * @param trade
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年11月16日
	 */
	List<Trade> queryListByPage(Trade trade);

	/**
	 * 根据订单 查询总数
	 * 
	 * @param trade
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年11月16日
	 */
	Trade queryTradeCount(Trade trade);

	/**
	 * 查询所有的订单
	 * 
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年12月10日
	 */
	List<Trade> selectByPrimary();

	/**
	 * 统计订单数量
	 * 
	 * @param Trade
	 * @return Trade
	 * @date 2016年1月6日
	 * @auther luans
	 */
	public Trade queryTradeCountByUId(Trade trade);

	/**
	 * 删除订单
	 * 
	 * @param Trade
	 * @return int
	 * @date 2016年1月7日
	 * @auther luans
	 */
	public int delTradePC(Trade trade);

	/**
	 * 确认订单
	 * 
	 * @param Trade
	 * @return int
	 * @date 2016年1月8日
	 * @auther luans
	 */
	public int makeSureTreade(Trade trade);

	/**
	 * 取消订单
	 * 
	 * @param Trade
	 * @return int
	 * @auther luans
	 * @date 2016年1月8日
	 */
	public int cancelTrade(Trade trade);

	/**
	 * 根据订单ID查询订单信息
	 * 
	 * @param Trade
	 * @return Trade
	 * @date 2016年1月8日
	 * @auther luans
	 */
	public Trade queryTradeById(Integer id);
	
	/**
	 * 支付宝支付成功后：保存支付支付宝信息
	 * 
	 * @param Trade
	 * @return Trade
	 * @date 2016年3月24日
	 * @auther luans
	 */
	public int updateForalPay(Trade trade);

	/**
	 * 根据订单编号查询订单信息
	 * 
	 * @param Trade
	 * @return int
	 * @date 2016年3月24日
	 * @auther luans
	 */
	public Trade queryTradeByNo(String tradeNo);

	/**
	 * 根据用户的编号查询该用户的所有的订单
	 * 
	 * @param trade
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月8日
	 */
	List<Trade> getTradeListByUid(Trade trade);

	/**
	 * 根据订单的状态分组List
	 * 
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月8日
	 */
	List<Integer> getTradeCountListByState();

	/**
	 * 添加订单
	 * 
	 * @param Trade
	 * @return int
	 * @date 2016年3月3日
	 * @auther luans
	 */
	public int insertSelective(Trade record);

	/**
	 * 根据用户订单状态查询改状态下的所有订单
	 * 
	 * @param state
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月15日
	 */
	List<Trade> getTradeListByState(Integer uid, Integer state);

	/**
	 * 微信支付成功后修改订单详情
	 * @param trade
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月25日
	 */
	int updateWxPay(Trade trade);

}

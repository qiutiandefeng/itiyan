package com.yfhl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yfhl.entity.Trade;

public interface TradeMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Trade record);

	Trade selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Trade record);

	int updateByPrimaryKey(Trade record);

	int getCountTradeByTime(@Param("startTime") String startTime,
			@Param("endTime") String endTime);

	List<Trade> queryListByPage(Trade trade);

	Trade queryTradeCount(Trade trade);

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
	 * @date 2016年1月8日
	 * @auther luans
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
	 * 根据订单编号查询订单信息
	 * 
	 * @param Trade
	 * @return int
	 * @date 2016年3月24日
	 * @auther luans
	 */
	public Trade queryTradeByNo(@Param("tradeNo") String tradeNo);

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
	 * 根据用户的编号查询该用户的所有的订单
	 * 
	 * @param trade
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月8日
	 */
	List<Trade> getTradeListByUid(Trade trade);

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
	 * 微信支付成功后保存到订单详情表中
	 * @param trade
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月25日
	 */
	public int updateWxPay(Trade trade);
	/**
	 * 根据订单的状态分组List
	 * 
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月8日
	 */
	List<Integer> getTradeCountListByState();

	/**
	 * 根据用户订单状态查询改状态下的所有订单
	 * 
	 * @param state
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月15日
	 */
	List<Trade> getTradeListByState(@Param("uid") Integer uid,
			@Param("status") Integer status);

}
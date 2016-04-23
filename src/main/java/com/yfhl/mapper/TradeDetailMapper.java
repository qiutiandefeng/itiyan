package com.yfhl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yfhl.entity.TradeDetail;

public interface TradeDetailMapper {
	int deleteByPrimaryKey(Integer tradeDetailId);

	int insert(TradeDetail record);

	TradeDetail selectByPrimaryKey(Integer tradeDetailId);

	int updateByPrimaryKeySelective(TradeDetail record);

	int updateByPrimaryKey(TradeDetail record);

	/**
	 * 根据trade_Detail_Id查询订单信息
	 * 
	 * @param id
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年11月25日
	 */
	TradeDetail getTradeDetailByTradeId(Integer id);

	/**
	 * 获取所有的
	 * 
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年12月11日
	 */
	List<TradeDetail> getTradeDetailAll();

	List<TradeDetail> getTradeDetailListByTradeId(Integer id);

	/**
	 * 添加订单详情
	 * 
	 * @param TradeDetail
	 * @return int
	 * @date 2016年3月3日
	 * @auther luans
	 */
	public int insertSelective(TradeDetail record);

	/**
	 * 根据订单Id统计商品数量
	 * 
	 * @param int
	 * @return int
	 * @date 2016年3月24日
	 * @auther luans
	 */
	public int getCountModelBytid(@Param("tid") int tid);
}
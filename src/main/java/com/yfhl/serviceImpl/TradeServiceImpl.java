package com.yfhl.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yfhl.entity.Trade;
import com.yfhl.mapper.TradeMapper;
import com.yfhl.service.TradeService;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年11月13日 下午9:31:39 类说明
 */
@Service
public class TradeServiceImpl implements TradeService {

	@Resource
	private TradeMapper tradeMapper;

	public int deleteByPrimaryKey(Integer id) {
		return tradeMapper.deleteByPrimaryKey(id);
	}

	public int insert(Trade record) {
		return tradeMapper.insert(record);
	}

	public Trade selectByPrimaryKey(Integer id) {
		return tradeMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Trade record) {
		return tradeMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Trade record) {
		return tradeMapper.updateByPrimaryKey(record);
	}

	public int getCountTradeByTime(String startTime, String endTime) {
		return tradeMapper.getCountTradeByTime(startTime, endTime);

	}

	public List<Trade> queryListByPage(Trade trade) {
		return tradeMapper.queryListByPage(trade);
	}

	public Trade queryTradeCount(Trade trade) {
		return tradeMapper.queryTradeCount(trade);
	}

	public List<Trade> selectByPrimary() {
		return tradeMapper.selectByPrimary();
	}

	/**
	 * 统计订单数量
	 * 
	 * @param Trade
	 * @return Trade
	 * @date 2016年1月6日
	 * @auther luans
	 */
	public Trade queryTradeCountByUId(Trade trade) {
		return tradeMapper.queryTradeCountByUId(trade);
	}

	/**
	 * 删除订单
	 * 
	 * @param Trade
	 * @return int
	 * @date 2016年1月7日
	 * @auther luans
	 */
	public int delTradePC(Trade trade) {
		return tradeMapper.delTradePC(trade);
	}

	/**
	 * 确认订单
	 * 
	 * @param Trade
	 * @return int
	 * @date 2016年1月8日
	 * @auther luans
	 */
	public int makeSureTreade(Trade trade) {
		return tradeMapper.makeSureTreade(trade);
	}

	/**
	 * 取消订单
	 * 
	 * @param Trade
	 * @return int
	 * @date 2016年1月8日
	 * @auther luans
	 */
	public int cancelTrade(Trade trade) {
		return tradeMapper.cancelTrade(trade);
	}

	/**
	 * 根据订单ID查询订单信息
	 * 
	 * @param Trade
	 * @return Trade
	 * @date 2016年1月8日
	 * @auther luans
	 */
	public Trade queryTradeById(Integer id) {
		return tradeMapper.queryTradeById(id);
	}

	/**
	 * 根据订单编号查询订单信息
	 * 
	 * @param Trade
	 * @return int
	 * @date 2016年3月24日
	 * @auther luans
	 */
	public Trade queryTradeByNo(String tradeNo) {
		return tradeMapper.queryTradeByNo(tradeNo);
	}

	/**
	 * 支付宝支付成功后：保存支付支付宝信息
	 * 
	 * @param Trade
	 * @return Trade
	 * @date 2016年3月24日
	 * @auther luans
	 */
	public int updateForalPay(Trade trade) {
		return tradeMapper.updateForalPay(trade);
	}

	/**
	 * 根据用户的编号查询该用户的所有的订单
	 * 
	 * @param trade
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月8日
	 */
	@Override
	public List<Trade> getTradeListByUid(Trade trade) {
		return tradeMapper.getTradeListByUid(trade);
	}

	/**
	 * 根据订单的状态分组List
	 * 
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月8日
	 */
	@Override
	public List<Integer> getTradeCountListByState() {
		return tradeMapper.getTradeCountListByState();
	}

	/**
	 * 添加订单
	 * 
	 * @param Trade
	 * @return int
	 * @date 2016年3月3日
	 * @auther luans
	 */
	public int insertSelective(Trade record) {
		record.setIsDelete(0);// 删除状态：0正常 1用户删除
		record.setStatus(1);// 订单状态（1：等待付款 2：已付款，等待发货 3：已发货，等待收货 4：交易完成 5：交易取消
							// 6：供应商打印中）
		return tradeMapper.insertSelective(record);
	}

	/**
	 * 根据用户订单状态查询改状态下的所有订单
	 * 
	 * @param state
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月15日
	 */
	@Override
	public List<Trade> getTradeListByState(Integer uid, Integer status) {
		return tradeMapper.getTradeListByState(uid, status);
	}

	/**
	 * 微信支付成功支付后修改订单信息
	 */
	@Override
	public int updateWxPay(Trade trade) {
		return tradeMapper.updateWxPay(trade);
	}

}

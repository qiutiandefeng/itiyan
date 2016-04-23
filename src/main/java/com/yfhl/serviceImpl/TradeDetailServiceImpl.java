package com.yfhl.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.yfhl.entity.TradeDetail;
import com.yfhl.mapper.TradeDetailMapper;
import com.yfhl.service.TradeDetailService;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年11月25日 下午9:42:49 类说明
 */
@Service
public class TradeDetailServiceImpl implements TradeDetailService {

	@Resource
	private TradeDetailMapper tradeDetailMapper;

	public int deleteByPrimaryKey(Integer tradeDetailId) {
		// TODO Auto-generated method stub
		return tradeDetailMapper.deleteByPrimaryKey(tradeDetailId);
	}

	public int insert(TradeDetail record) {
		// TODO Auto-generated method stub
		return tradeDetailMapper.insert(record);
	}

	public TradeDetail selectByPrimaryKey(Integer tradeDetailId) {
		// TODO Auto-generated method stub
		return tradeDetailMapper.selectByPrimaryKey(tradeDetailId);
	}

	public int updateByPrimaryKeySelective(TradeDetail record) {
		// TODO Auto-generated method stub
		return tradeDetailMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(TradeDetail record) {
		// TODO Auto-generated method stub
		return tradeDetailMapper.updateByPrimaryKey(record);

	}

	/**
	 * 根据trade_Detail_Id查询订单信息
	 */
	public TradeDetail getTradeDetailByTradeId(Integer id) {
		// TODO Auto-generated method stub
		return tradeDetailMapper.getTradeDetailByTradeId(id);
	}

	public List<TradeDetail> getTradeDetailAll() {
		// TODO Auto-generated method stub
		return tradeDetailMapper.getTradeDetailAll();
	}

	public List<TradeDetail> getTradeDetailListByTradeId(Integer id) {
		// TODO Auto-generated method stub
		return tradeDetailMapper.getTradeDetailListByTradeId(id);
	}

	/**
	 * 添加订单详情
	 * 
	 * @param TradeDetail
	 * @return int
	 * @date 2016年3月3日
	 * @auther luans
	 */
	public int insertSelective(TradeDetail record) {
		return tradeDetailMapper.insertSelective(record);
	}
	/**
	 * 根据订单Id统计商品数量
	 * 
	 * @param int
	 * @return int
	 * @date 2016年3月24日
	 * @auther luans
	 */
	public int getCountModelBytid(int tid){
		return tradeDetailMapper.getCountModelBytid(tid);
	}
}

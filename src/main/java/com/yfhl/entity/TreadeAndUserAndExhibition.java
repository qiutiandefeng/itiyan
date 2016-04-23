package com.yfhl.entity;

import java.util.Date;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年11月16日 下午6:27:34
 * 类说明
 */
public class TreadeAndUserAndExhibition {

	//订单号
	private Integer tid; 
	
	//买家
	private String buyerUser;
	
	//商品名称
	private String exName;
	
	//设计师
	private String designerName;
	
	//品牌
	private String applydBrand;
	
	//订单状态
	private String state;
	
	//订单金额
	private float cashFee;
	
	//支付方式
	private String modePayment;
	
	//下单时间
	private Date addTime;


	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getBuyerUser() {
		return buyerUser;
	}

	public void setBuyerUser(String buyerUser) {
		this.buyerUser = buyerUser;
	}

	public String getExName() {
		return exName;
	}

	public void setExName(String exName) {
		this.exName = exName;
	}

	public String getDesignerName() {
		return designerName;
	}

	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}

	public String getApplydBrand() {
		return applydBrand;
	}

	public void setApplydBrand(String applydBrand) {
		this.applydBrand = applydBrand;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public float getCashFee() {
		return cashFee;
	}

	public void setCashFee(float cashFee) {
		this.cashFee = cashFee;
	}

	public String getModePayment() {
		return modePayment;
	}

	public void setModePayment(String modePayment) {
		this.modePayment = modePayment;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
}

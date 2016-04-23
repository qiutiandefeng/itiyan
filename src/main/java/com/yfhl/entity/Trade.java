package com.yfhl.entity;

import java.util.Date;
import java.util.List;

import com.yfhl.common.PageInfo;

public class Trade {
    private Integer id;//唯一编号

    private String tradeNo;//订单号

    private String tradeTitle;//订单名称

    private Integer uid;//用户编号

    private Float totalPrice;//订单总价

    private String tradeDetail;//trade_detail ID数组序列化

    private Date addTime;//下单时间

    private Date paymentTime;//付款时间

    private Date waitSupplierConformTime;//通知供货商时间

    private Date supplierConformTime;//供货商确认时间

    private Date finish3dprintingTime;//打印完成时间

    private Date shipmentsTime;//发货时间

    private Date finishTime;//结束时间

    private String remark;//订单备注

    private String phone;//联系电话

    private String realname;//真实姓名

    private String address;//送货地址

    private Integer zipcode;//邮政编码

    private Integer status;//订单状态（1：等待付款 2：已付款，等待发货 3：已发货，等待收货 4：交易完成 5：交易取消 6：供应商打印中）

    private String logistics;//物流信息

    private String cancelInfo;//订单取消原因

    private String alipayNo;//支付宝交易号

    private String alipayBuyerAccount;//买家支付宝账号

    private Integer supplierUid;//供应商uid

    private String wxpayNo;//微信交易号

    private String wxOpenid;//微信唯一标志

    private Float cashFee;//实际支付

    private String cheapCode;//优惠码

    private Float cheapMoney;

    private Integer isDelete;//0正常 1用户删除

    private Float postage;//邮费

    private Integer isPost;//系统默认/自取0 邮费1
	
	private Integer trdSelfDesigner;//订单来源：1：爱体验 2：设计师

    // 自定义属性
 	private PageInfo pageInfo = new PageInfo();// 分页实体类
 	
 	private String sumCount;// 用户管理(统计平台和微信端的总数)：总数
	private String pCount;// 用户管理(统计平台和微信端的总数):平台端总数
	private String wCount;// 用户管理(统计平台和微信端的总数):微信端总数
	
	private String condition;// 模糊查询条件
	private Integer markTradeFrom;// 标记查询来源：1:全部;2:平台端；3:微信端
	private Integer markManage;// 标记操作类型：1：添加；2：编辑；3：查看
    
	private Integer state;//查询的状态
	private String tradeOneNo;//查询的编号
	
	private List<TradeDetail> tradeDetailList;//订单详情List
	private Integer markUserid;//根据用户ID查询用户订单  
	private Integer stateCount; //所有订单数量
	private Integer state1Count; //待付款订单数
	private Integer state2Count; //待发货订单数
	private Integer state3Count; //待收货订单数
	private String  submit_views;//订单提交时，购物车ID和商品备注的整合信息
	private Integer addressid;//提交订单时，用户收货地址ID
	private Integer modelCount;//订单中商品数量
	private Integer marker_state;// 订单信息状态：1：正常 ；2：库存不足；3：商品下架
    
    public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getTradeOneNo() {
		return tradeOneNo;
	}

	public void setTradeOneNo(String tradeOneNo) {
		this.tradeOneNo = tradeOneNo;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getTradeTitle() {
        return tradeTitle;
    }

    public void setTradeTitle(String tradeTitle) {
        this.tradeTitle = tradeTitle == null ? null : tradeTitle.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTradeDetail() {
        return tradeDetail;
    }

    public void setTradeDetail(String tradeDetail) {
        this.tradeDetail = tradeDetail == null ? null : tradeDetail.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getWaitSupplierConformTime() {
        return waitSupplierConformTime;
    }

    public void setWaitSupplierConformTime(Date waitSupplierConformTime) {
        this.waitSupplierConformTime = waitSupplierConformTime;
    }

    public Date getSupplierConformTime() {
        return supplierConformTime;
    }

    public void setSupplierConformTime(Date supplierConformTime) {
        this.supplierConformTime = supplierConformTime;
    }

    public Date getFinish3dprintingTime() {
        return finish3dprintingTime;
    }

    public void setFinish3dprintingTime(Date finish3dprintingTime) {
        this.finish3dprintingTime = finish3dprintingTime;
    }

    public Date getShipmentsTime() {
        return shipmentsTime;
    }

    public void setShipmentsTime(Date shipmentsTime) {
        this.shipmentsTime = shipmentsTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics == null ? null : logistics.trim();
    }

    public String getCancelInfo() {
        return cancelInfo;
    }

    public void setCancelInfo(String cancelInfo) {
        this.cancelInfo = cancelInfo == null ? null : cancelInfo.trim();
    }

    public String getAlipayNo() {
        return alipayNo;
    }

    public void setAlipayNo(String alipayNo) {
        this.alipayNo = alipayNo == null ? null : alipayNo.trim();
    }

    public String getAlipayBuyerAccount() {
        return alipayBuyerAccount;
    }

    public void setAlipayBuyerAccount(String alipayBuyerAccount) {
        this.alipayBuyerAccount = alipayBuyerAccount == null ? null : alipayBuyerAccount.trim();
    }

    public Integer getSupplierUid() {
        return supplierUid;
    }

    public void setSupplierUid(Integer supplierUid) {
        this.supplierUid = supplierUid;
    }

    public String getWxpayNo() {
        return wxpayNo;
    }

    public void setWxpayNo(String wxpayNo) {
        this.wxpayNo = wxpayNo == null ? null : wxpayNo.trim();
    }

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid == null ? null : wxOpenid.trim();
    }

    public Float getCashFee() {
        return cashFee;
    }

    public void setCashFee(Float cashFee) {
        this.cashFee = cashFee;
    }

    public String getCheapCode() {
        return cheapCode;
    }

    public void setCheapCode(String cheapCode) {
        this.cheapCode = cheapCode == null ? null : cheapCode.trim();
    }

    public Float getCheapMoney() {
        return cheapMoney;
    }

    public void setCheapMoney(Float cheapMoney) {
        this.cheapMoney = cheapMoney;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Float getPostage() {
        return postage;
    }

    public void setPostage(Float postage) {
        this.postage = postage;
    }

    public Integer getIsPost() {
        return isPost;
    }

    public void setIsPost(Integer isPost) {
        this.isPost = isPost;
    }

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getSumCount() {
		return sumCount;
	}

	public void setSumCount(String sumCount) {
		this.sumCount = sumCount;
	}

	public String getpCount() {
		return pCount;
	}

	public void setpCount(String pCount) {
		this.pCount = pCount;
	}

	public String getwCount() {
		return wCount;
	}

	public void setwCount(String wCount) {
		this.wCount = wCount;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Integer getMarkTradeFrom() {
		return markTradeFrom;
	}

	public void setMarkTradeFrom(Integer markTradeFrom) {
		this.markTradeFrom = markTradeFrom;
	}

	public Integer getMarkManage() {
		return markManage;
	}

	public void setMarkManage(Integer markManage) {
		this.markManage = markManage;
	}

	public List<TradeDetail> getTradeDetailList() {
		return tradeDetailList;
	}

	public void setTradeDetailList(List<TradeDetail> tradeDetailList) {
		this.tradeDetailList = tradeDetailList;
	}

	public Integer getMarkUserid() {
		return markUserid;
	}

	public void setMarkUserid(Integer markUserid) {
		this.markUserid = markUserid;
	}

	public Integer getStateCount() {
		return stateCount;
	}

	public void setStateCount(Integer stateCount) {
		this.stateCount = stateCount;
	}

	public Integer getState1Count() {
		return state1Count;
	}

	public void setState1Count(Integer state1Count) {
		this.state1Count = state1Count;
	}

	public Integer getState2Count() {
		return state2Count;
	}

	public void setState2Count(Integer state2Count) {
		this.state2Count = state2Count;
	}

	public Integer getState3Count() {
		return state3Count;
	}

	public void setState3Count(Integer state3Count) {
		this.state3Count = state3Count;
	}

	public String getSubmit_views() {
		return submit_views;
	}

	public void setSubmit_views(String submit_views) {
		this.submit_views = submit_views;
	}

	public Integer getAddressid() {
		return addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	public Integer getTrdSelfDesigner() {
		return trdSelfDesigner;
	}

	public void setTrdSelfDesigner(Integer trdSelfDesigner) {
		this.trdSelfDesigner = trdSelfDesigner;
	}

	public Integer getModelCount() {
		return modelCount;
	}

	public void setModelCount(Integer modelCount) {
		this.modelCount = modelCount;
	}

	public Integer getMarker_state() {
		return marker_state;
	}

	public void setMarker_state(Integer marker_state) {
		this.marker_state = marker_state;
	}

	@Override
	public String toString() {
		return "Trade [id=" + id + ", tradeNo=" + tradeNo + ", tradeTitle="
				+ tradeTitle + ", uid=" + uid + ", totalPrice=" + totalPrice
				+ ", tradeDetail=" + tradeDetail + ", addTime=" + addTime
				+ ", paymentTime=" + paymentTime + ", waitSupplierConformTime="
				+ waitSupplierConformTime + ", supplierConformTime="
				+ supplierConformTime + ", finish3dprintingTime="
				+ finish3dprintingTime + ", shipmentsTime=" + shipmentsTime
				+ ", finishTime=" + finishTime + ", remark=" + remark
				+ ", phone=" + phone + ", realname=" + realname + ", address="
				+ address + ", zipcode=" + zipcode + ", status=" + status
				+ ", logistics=" + logistics + ", cancelInfo=" + cancelInfo
				+ ", alipayNo=" + alipayNo + ", alipayBuyerAccount="
				+ alipayBuyerAccount + ", supplierUid=" + supplierUid
				+ ", wxpayNo=" + wxpayNo + ", wxOpenid=" + wxOpenid
				+ ", cashFee=" + cashFee + ", cheapCode=" + cheapCode
				+ ", cheapMoney=" + cheapMoney + ", isDelete=" + isDelete
				+ ", postage=" + postage + ", isPost=" + isPost
				+ ", trdSelfDesigner=" + trdSelfDesigner + ", pageInfo="
				+ pageInfo + ", sumCount=" + sumCount + ", pCount=" + pCount
				+ ", wCount=" + wCount + ", condition=" + condition
				+ ", markTradeFrom=" + markTradeFrom + ", markManage="
				+ markManage + ", state=" + state + ", tradeOneNo="
				+ tradeOneNo + ", tradeDetailList=" + tradeDetailList
				+ ", markUserid=" + markUserid + ", stateCount=" + stateCount
				+ ", state1Count=" + state1Count + ", state2Count="
				+ state2Count + ", state3Count=" + state3Count
				+ ", submit_views=" + submit_views + ", addressid=" + addressid
				+ "]";
	}

}
package com.yfhl.entity;

public class TradeDetail {
	private Integer tradeDetailId;// 详情唯一编号

	private Integer id;// 模型ID

	private String name;// 名称

	private Integer qty;// 订购数目

	private Float price;// 单价

	private String remark;// 备注

	private String options;// 其他信息

	private Boolean modelType;// 1：商品库模型 2：用户上传模型

	private String tradeDetailImg;// java trade_detail_img 图片

	private Integer modeltypeId;// 商品规则的编号

	private Integer tradeId;// 订单编号

	
	//自定义字段
	private String modtTextture;//商品材质
	private String modtImg;//材质图片
	private String modtSize;//商品尺寸
	private Integer marker_changeNumber;//标记改变商品数量：1添加；2删除
	
	
	public Integer getTradeDetailId() {
		return tradeDetailId;
	}

	public void setTradeDetailId(Integer tradeDetailId) {
		this.tradeDetailId = tradeDetailId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options == null ? null : options.trim();
	}

	public Boolean getModelType() {
		return modelType;
	}

	public void setModelType(Boolean modelType) {
		this.modelType = modelType;
	}

	public String getTradeDetailImg() {
		return tradeDetailImg;
	}

	public void setTradeDetailImg(String tradeDetailImg) {
		this.tradeDetailImg = tradeDetailImg == null ? null : tradeDetailImg
				.trim();
	}

	public Integer getModeltypeId() {
		return modeltypeId;
	}

	public void setModeltypeId(Integer modeltypeId) {
		this.modeltypeId = modeltypeId;
	}

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public String getModtTextture() {
		return modtTextture;
	}

	public void setModtTextture(String modtTextture) {
		this.modtTextture = modtTextture;
	}

	public String getModtImg() {
		return modtImg;
	}

	public void setModtImg(String modtImg) {
		this.modtImg = modtImg;
	}

	public String getModtSize() {
		return modtSize;
	}

	public void setModtSize(String modtSize) {
		this.modtSize = modtSize;
	}

	public Integer getMarker_changeNumber() {
		return marker_changeNumber;
	}

	public void setMarker_changeNumber(Integer marker_changeNumber) {
		this.marker_changeNumber = marker_changeNumber;
	}

	@Override
	public String toString() {
		return "TradeDetail [tradeDetailId=" + tradeDetailId + ", id=" + id
				+ ", name=" + name + ", qty=" + qty + ", price=" + price
				+ ", remark=" + remark + ", options=" + options
				+ ", modelType=" + modelType + ", tradeDetailImg="
				+ tradeDetailImg + ", modeltypeId=" + modeltypeId
				+ ", tradeId=" + tradeId + ", modtTextture=" + modtTextture
				+ ", modtImg=" + modtImg + ", modtSize=" + modtSize + "]";
	}
	
}
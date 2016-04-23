package com.yfhl.entity;

/**
 * 商品规格实体类
 * 
 * @date 2015年12月11日
 * @author luans
 *
 */
public class ModelType {

	private Integer modtId;// 商品型号规格表ID

	private Integer modtModid;// 商品表外键：hs_model表ID

	private Float modtPrice;// 价格

	private Integer modtRepertory;// 库存

	private String modtImg;// 材质图片：“url_null”表示没有图片

	private String modtTexture;// 规格材质

	private String modtSize;// 规格大小
	
	private String modtColor;// 规格1：颜色#ffffff

	private String modtColorDesc;// 规格用于存放用户自定义商品分类—颜色
	
	private Integer textureId;// 材质规格

	private Integer modtDelstate;// 删除状态：1.正常；2.删除
	
	private String texttureMarker;//标记材质显示位置

	private String sizeMarker;//标记尺寸显示位置
	
	
	// 自定义字段
	private String markTitle;// 规格标头：后天拼接规格时用到
	private String markType;// 规格体，截取字符串可以获取详细规格内容
	private String texttrueName;//材质名称
	private String texttrueImg;//材质图片
	private Integer markSel;//标记查询内容：1：材质；2：颜色；3：尺寸

	public Integer getModtId() {
		return modtId;
	}

	public void setModtId(Integer modtId) {
		this.modtId = modtId;
	}

	public Integer getModtModid() {
		return modtModid;
	}

	public void setModtModid(Integer modtModid) {
		this.modtModid = modtModid;
	}

	public Float getModtPrice() {
		return modtPrice;
	}

	public void setModtPrice(Float modtPrice) {
		this.modtPrice = modtPrice;
	}

	public Integer getModtRepertory() {
		return modtRepertory;
	}

	public void setModtRepertory(Integer modtRepertory) {
		this.modtRepertory = modtRepertory;
	}

	public String getModtImg() {
		return modtImg;
	}

	public void setModtImg(String modtImg) {
		this.modtImg = modtImg;
	}

	public String getModtColor() {
		return modtColor;
	}

	public void setModtColor(String modtColor) {
		this.modtColor = modtColor;
	}

	public String getModtColorDesc() {
		return modtColorDesc;
	}

	public void setModtColorDesc(String modtColorDesc) {
		this.modtColorDesc = modtColorDesc;
	}

	public String getModtTexture() {
		return modtTexture;
	}

	public void setModtTexture(String modtTexture) {
		this.modtTexture = modtTexture;
	}

	public String getModtSize() {
		return modtSize;
	}

	public void setModtSize(String modtSize) {
		this.modtSize = modtSize;
	}

	public Integer getModtDelstate() {
		return modtDelstate;
	}

	public void setModtDelstate(Integer modtDelstate) {
		this.modtDelstate = modtDelstate;
	}

	public String getMarkTitle() {
		return markTitle;
	}

	public void setMarkTitle(String markTitle) {
		this.markTitle = markTitle;
	}

	public String getMarkType() {
		return markType;
	}

	public void setMarkType(String markType) {
		this.markType = markType;
	}

	public Integer getTextureId() {
		return textureId;
	}

	public void setTextureId(Integer textureId) {
		this.textureId = textureId;
	}

	public String getTexttrueName() {
		return texttrueName;
	}

	public void setTexttrueName(String texttrueName) {
		this.texttrueName = texttrueName;
	}

	public String getTexttrueImg() {
		return texttrueImg;
	}

	public void setTexttrueImg(String texttrueImg) {
		this.texttrueImg = texttrueImg;
	}

	public Integer getMarkSel() {
		return markSel;
	}

	public void setMarkSel(Integer markSel) {
		this.markSel = markSel;
	}
	
	public String getTexttureMarker() {
		return texttureMarker;
	}

	public void setTexttureMarker(String texttureMarker) {
		this.texttureMarker = texttureMarker;
	}

	public String getSizeMarker() {
		return sizeMarker;
	}

	public void setSizeMarker(String sizeMarker) {
		this.sizeMarker = sizeMarker == null ? null : sizeMarker.trim();
	}

	@Override
	public String toString() {
		return "ModelType [modtId=" + modtId + ", modtModid=" + modtModid
				+ ", modtPrice=" + modtPrice + ", modtRepertory="
				+ modtRepertory + ", modtImg=" + modtImg + ", modtTexture="
				+ modtTexture + ", modtSize=" + modtSize + ", modtColor="
				+ modtColor + ", modtColorDesc=" + modtColorDesc
				+ ", textureId=" + textureId + ", modtDelstate=" + modtDelstate
				+ ", texttureMarker=" + texttureMarker + ", sizeMarker="
				+ sizeMarker + ", markTitle=" + markTitle + ", markType="
				+ markType + ", texttrueName=" + texttrueName
				+ ", texttrueImg=" + texttrueImg + ", markSel=" + markSel + "]";
	}

	 
 
}
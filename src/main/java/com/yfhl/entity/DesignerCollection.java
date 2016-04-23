package com.yfhl.entity;

/**
 * 用户收藏设计师实体类
 * 
 * @author luans
 *
 */

public class DesignerCollection {

	private Integer dcId;// 设计师收藏主键ID

	private Integer dcDesignerid;// 被收藏设计师的ID

	private Integer dcUserid;// 用户的ID
	
	// 自定义字段
	private Integer markType;// 标记操作类型：1：添加收藏；2：取消收藏

	public Integer getDcId() {
		return dcId;
	}

	public void setDcId(Integer dcId) {
		this.dcId = dcId;
	}

	public Integer getDcDesignerid() {
		return dcDesignerid;
	}

	public void setDcDesignerid(Integer dcDesignerid) {
		this.dcDesignerid = dcDesignerid;
	}

	public Integer getDcUserid() {
		return dcUserid;
	}

	public void setDcUserid(Integer dcUserid) {
		this.dcUserid = dcUserid;
	}

	public Integer getMarkType() {
		return markType;
	}

	public void setMarkType(Integer markType) {
		this.markType = markType;
	}

	@Override
	public String toString() {
		return "DesignerCollection [dcId=" + dcId + ", dcDesignerid="
				+ dcDesignerid + ", dcUserid=" + dcUserid + ", markType="
				+ markType + "]";
	}
	
}
package com.yfhl.entity;

import com.yfhl.common.PageInfo;

/**
 * 商品收藏实体类
 * 
 * @date 2015年12月18日
 * @author luans
 *
 */
public class ModelCollection {

	private Integer mcId;// 商品收藏主键ID

	private Integer mcModelid;// 被收藏商品的ID

	private Integer mcDesignerid;// 商品设计师ID

	private Integer mcUserid;// 用户的ID

	// 自定义字段
	private PageInfo pageInfo = new PageInfo();// 分页实体类

	private String condition;// 模糊查询条件
	private Integer markType;// 标记操作类型：1：添加收藏；2：取消收藏
	private String modelName;// 商品名称
	private String modelImg;// 商品图片
	private String markMID;// 用于存放批量删除收藏时的商品收藏ID：中间用";"分隔

	public Integer getMcId() {
		return mcId;
	}

	public void setMcId(Integer mcId) {
		this.mcId = mcId;
	}

	public Integer getMcModelid() {
		return mcModelid;
	}

	public void setMcModelid(Integer mcModelid) {
		this.mcModelid = mcModelid;
	}

	public Integer getMcDesignerid() {
		return mcDesignerid;
	}

	public void setMcDesignerid(Integer mcDesignerid) {
		this.mcDesignerid = mcDesignerid;
	}

	public Integer getMcUserid() {
		return mcUserid;
	}

	public void setMcUserid(Integer mcUserid) {
		this.mcUserid = mcUserid;
	}

	public Integer getMarkType() {
		return markType;
	}

	public void setMarkType(Integer markType) {
		this.markType = markType;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelImg() {
		return modelImg;
	}

	public void setModelImg(String modelImg) {
		this.modelImg = modelImg;
	}

	public String getMarkMID() {
		return markMID;
	}

	public void setMarkMID(String markMID) {
		this.markMID = markMID;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "ModelCollection [mcId=" + mcId + ", mcModelid=" + mcModelid
				+ ", mcDesignerid=" + mcDesignerid + ", mcUserid=" + mcUserid
				+ ", pageInfo=" + pageInfo + ", condition=" + condition
				+ ", markType=" + markType + ", modelName=" + modelName
				+ ", modelImg=" + modelImg + ", markMID=" + markMID + "]";
	}

}
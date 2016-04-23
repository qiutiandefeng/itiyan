package com.yfhl.entity;

import java.util.Date;

import com.yfhl.common.PageInfo;

public class Comment {
	
	private Integer cid;//评论唯一编号

	private Integer mid;//模型编号

	private Integer uid;//用户编号

	private String content;//内容

	private Date addTime;//评论发表时间


	// 自定义属性
	private PageInfo pageInfo = new PageInfo();// 分页实体类
	private String condition;// 模糊查询条件
	private Integer markView;//商品详情页面：标记是否显示商品评论：1：显示；2：不显示 
	private String title;//商品名称
	private String username;//评论的用户名称
	private String userImg;//评论的用户的头像
	private String modelAuther;//商品作者
	private String autherImg;//作者头像
	

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getModelAuther() {
		return modelAuther;
	}

	public void setModelAuther(String modelAuther) {
		this.modelAuther = modelAuther;
	}

	public String getAutherImg() {
		return autherImg;
	}

	public void setAutherImg(String autherImg) {
		this.autherImg = autherImg;
	}

	public Integer getMarkView() {
		return markView;
	}

	public void setMarkView(Integer markView) {
		this.markView = markView;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", mid=" + mid + ", uid=" + uid
				+ ", content=" + content + ", addTime=" + addTime
				+ ", pageInfo=" + pageInfo + ", condition=" + condition
				+ ", markView=" + markView + ", title=" + title + ", username="
				+ username + ", modelAuther=" + modelAuther + ", autherImg="
				+ autherImg + "]";
	}

	 
}
package com.yfhl.entity;

import java.util.Date;

/**
 * 商品浏览实体类
 * 
 * @date 2015年12月14日
 * @author luans
 *
 */
public class Recent {
	private Integer rid;// 浏览表主键自增ID

	private Integer rUid;// 关联用户ID:浏览用户

	private Integer rMid;// 关联商品ID:浏览商品

	private Date rTime;// 浏览时间
	
	//自定义字段
	private String modelImg;//图片路径
	

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getrUid() {
		return rUid;
	}

	public void setrUid(Integer rUid) {
		this.rUid = rUid;
	}

	public Integer getrMid() {
		return rMid;
	}

	public void setrMid(Integer rMid) {
		this.rMid = rMid;
	}

	public Date getrTime() {
		return rTime;
	}

	public void setrTime(Date rTime) {
		this.rTime = rTime;
	}

	public String getModelImg() {
		return modelImg;
	}

	public void setModelImg(String modelImg) {
		this.modelImg = modelImg;
	}
	
}
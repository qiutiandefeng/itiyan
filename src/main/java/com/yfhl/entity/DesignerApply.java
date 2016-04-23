package com.yfhl.entity;

import java.util.Date;

import com.yfhl.common.PageInfo;

/**
 * 申请设计师实体类
 * @author luans
 * @date 2015年11月16日
 *
 */
public class DesignerApply {
	private Integer id;// 唯一编号

	private String realname;// 真实姓名

	private String field;// 领域

	private String phone;// 手机号

	private String job;// 职业

	private String applyReason;// 申请理由：品牌故事

	private Integer uid;// 用户ID

	private String applydDname;// 设计师名字

	private String applydBrand;// 品牌

	private String applydDtag;// 标签

	private String applydAddress;// 所在地

	private String applydUsername;// 用户名

	private String applydAvatar;// 用户头像路径

	private Integer applydState;// 状态:1: 申请中 2：已签约 3：未签约 4：未通过

	private String applydEmail;// 邮箱

	private Integer applydSex;// 性别:1. 男 2. 女 3.未知

	private String worksImg;// 作品图片，以分号隔开
	
    private Date applydTime;//申请时间
	
	//自定义字段
    private PageInfo pageInfo = new PageInfo();// 分页实体类
	private Integer markManage;// 标记操作类型：1：添加；2：编辑；3：查看
	
	private String condition;// 模糊查询条件

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname == null ? null : realname.trim();
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field == null ? null : field.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job == null ? null : job.trim();
	}

	public String getApplyReason() {
		return applyReason;
	}

	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason == null ? null : applyReason.trim();
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getApplydDname() {
		return applydDname;
	}

	public void setApplydDname(String applydDname) {
		this.applydDname = applydDname == null ? null : applydDname.trim();
	}

	public String getApplydBrand() {
		return applydBrand;
	}

	public void setApplydBrand(String applydBrand) {
		this.applydBrand = applydBrand == null ? null : applydBrand.trim();
	}

	public String getApplydDtag() {
		return applydDtag;
	}

	public void setApplydDtag(String applydDtag) {
		this.applydDtag = applydDtag == null ? null : applydDtag.trim();
	}

	public String getApplydAddress() {
		return applydAddress;
	}

	public void setApplydAddress(String applydAddress) {
		this.applydAddress = applydAddress == null ? null : applydAddress
				.trim();
	}

	public String getApplydUsername() {
		return applydUsername;
	}

	public void setApplydUsername(String applydUsername) {
		this.applydUsername = applydUsername == null ? null : applydUsername
				.trim();
	}

	public String getApplydAvatar() {
		return applydAvatar;
	}

	public void setApplydAvatar(String applydAvatar) {
		this.applydAvatar = applydAvatar == null ? null : applydAvatar.trim();
	}

	public Integer getApplydState() {
		return applydState;
	}

	public void setApplydState(Integer applydState) {
		this.applydState = applydState;
	}

	public String getApplydEmail() {
		return applydEmail;
	}

	public void setApplydEmail(String applydEmail) {
		this.applydEmail = applydEmail == null ? null : applydEmail.trim();
	}

	public Integer getApplydSex() {
		return applydSex;
	}

	public void setApplydSex(Integer applydSex) {
		this.applydSex = applydSex;
	}

	public String getWorksImg() {
		return worksImg;
	}

	public void setWorksImg(String worksImg) {
		this.worksImg = worksImg == null ? null : worksImg.trim();
	}

	public Integer getMarkManage() {
		return markManage;
	}

	public void setMarkManage(Integer markManage) {
		this.markManage = markManage;
	}

	public Date getApplydTime() {
		return applydTime;
	}

	public void setApplydTime(Date applydTime) {
		this.applydTime = applydTime;
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

	@Override
	public String toString() {
		return "DesignerApply [id=" + id + ", realname=" + realname
				+ ", field=" + field + ", phone=" + phone + ", job=" + job
				+ ", applyReason=" + applyReason + ", uid=" + uid
				+ ", applydDname=" + applydDname + ", applydBrand="
				+ applydBrand + ", applydDtag=" + applydDtag
				+ ", applydAddress=" + applydAddress + ", applydUsername="
				+ applydUsername + ", applydAvatar=" + applydAvatar
				+ ", applydState=" + applydState + ", applydEmail="
				+ applydEmail + ", applydSex=" + applydSex + ", worksImg="
				+ worksImg + ", applydTime=" + applydTime + ", pageInfo="
				+ pageInfo + ", markManage=" + markManage + ", condition="
				+ condition + "]";
	}

	 
	 
 
}
package com.yfhl.entity;

import java.util.Date;
import java.util.List;

import com.yfhl.common.PageInfo;

/**
 * 用户实体类
 * 
 * @date 2015年11月9日
 * @auther luans
 */
public class User {
	private Integer uid;// 用户唯一编号

	private String username;// 用户名

	private String email;// 电子邮件

	private String phone;// 手机号

	private String pwd;// 密码

	private String realname;// 真实姓名

	private String avatar;// 用户头像路径

	private Integer sex;// 1. 男 2. 女 3.未知

	private String job;// 职业

	private Integer dFavoriteNum;// 设计师被收藏数

	private String province;// 省份

	private String city;// 城市

	private String address;// 送货地址

	private String zipcode;// 邮政编码

	private Integer validEmail;// 0：未验证 1：已验证

	private Date regTime;// 注册时间

	private Date designerTime;// 设计师签约成功时间

	private Integer groupId;// 1：普通用户 2：管理员 3：供应商 4：签约设计师

	private String dTag;// 设计师标签

	private Integer studioStatus;// 1:申请中 2：已签约 3：未签约 4：未通过

	private Integer applyDesigner;// 1: 非申请状态 2:申请中

	private String applyReason;// 申请理由：（品牌故事）

	private String weiboId;// 微博ID

	private String qqOpenid;// QQ唯一识别码

	private String wxOpenid;// 微信openid

	private String wxpOpenid;

	private String wxUnionid;

	private String introduce;// 个人简介

	private String qq;// QQ号

	private String weixin;// 微信号

	private Integer delState;// 状态：1删除；2正常

	private String dUsername;// 设计师名字

	private String dBrand;// 品牌

	private String dField;// 领域

	private String dAddress;// 所在地

	private String uBirthYear;// 用户生日：年

	private String uBirthMoth;// 用户生日：月

	private String uBirthDay;// 用户生日：日

	// 自定义属性
	private PageInfo pageInfo = new PageInfo();// 分页实体类

	private String condition;// 模糊查询条件
	private Integer markUserfrom;// 标记查询来源：1:全部;2:平台端；3:微信端
	private Integer markManage;// 标记操作类型：1：添加；2：编辑；3：查看
	private Integer markSelect;// 标记是否是跳转到选择设计师页面：1：是；2：不是

	private String sumCount;// 用户管理(统计平台和微信端的总数)：总数
	private String pCount;// 用户管理(统计平台和微信端的总数):平台端总数
	private String wCount;// 用户管理(统计平台和微信端的总数):微信端总数
	private String oldImg;// 修改之前的头像路径：用于修改头像时，删除之前的头像图片
	private Integer shoppingCount;// 购物车数量
	private List<Model> designerList;//设计师商品集合
	private Integer dcId;//设计师收藏表ID:用于页面判断设计师是否被用户收藏
	private Integer markOrder;// pc端条件排序方式：1最新；2人气；

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd == null ? null : pwd.trim();
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname == null ? null : realname.trim();
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar == null ? null : avatar.trim();
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job == null ? null : job.trim();
	}

	public Integer getdFavoriteNum() {
		return dFavoriteNum;
	}

	public void setdFavoriteNum(Integer dFavoriteNum) {
		this.dFavoriteNum = dFavoriteNum;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode == null ? null : zipcode.trim();
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String getdTag() {
		return dTag;
	}

	public void setdTag(String dTag) {
		this.dTag = dTag == null ? null : dTag.trim();
	}

	public String getApplyReason() {
		return applyReason;
	}

	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason == null ? null : applyReason.trim();
	}

	public String getQqOpenid() {
		return qqOpenid;
	}

	public void setQqOpenid(String qqOpenid) {
		this.qqOpenid = qqOpenid == null ? null : qqOpenid.trim();
	}

	public String getWxOpenid() {
		return wxOpenid;
	}

	public void setWxOpenid(String wxOpenid) {
		this.wxOpenid = wxOpenid == null ? null : wxOpenid.trim();
	}

	public String getWxpOpenid() {
		return wxpOpenid;
	}

	public void setWxpOpenid(String wxpOpenid) {
		this.wxpOpenid = wxpOpenid == null ? null : wxpOpenid.trim();
	}

	public String getWxUnionid() {
		return wxUnionid;
	}

	public void setWxUnionid(String wxUnionid) {
		this.wxUnionid = wxUnionid == null ? null : wxUnionid.trim();
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce == null ? null : introduce.trim();
	}

	public Integer getValidEmail() {
		return validEmail;
	}

	public void setValidEmail(Integer validEmail) {
		this.validEmail = validEmail;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getStudioStatus() {
		return studioStatus;
	}

	public void setStudioStatus(Integer studioStatus) {
		this.studioStatus = studioStatus;
	}

	public Integer getApplyDesigner() {
		return applyDesigner;
	}

	public void setApplyDesigner(Integer applyDesigner) {
		this.applyDesigner = applyDesigner;
	}

	public String getWeiboId() {
		return weiboId;
	}

	public void setWeiboId(String weiboId) {
		this.weiboId = weiboId;
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

	public Integer getMarkUserfrom() {
		return markUserfrom;
	}

	public void setMarkUserfrom(Integer markUserfrom) {
		this.markUserfrom = markUserfrom;
	}

	public Integer getMarkManage() {
		return markManage;
	}

	public void setMarkManage(Integer markManage) {
		this.markManage = markManage;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public Integer getDelState() {
		return delState;
	}

	public void setDelState(Integer delState) {
		this.delState = delState;
	}

	public Date getDesignerTime() {
		return designerTime;
	}

	public void setDesignerTime(Date designerTime) {
		this.designerTime = designerTime;
	}

	public String getdUsername() {
		return dUsername;
	}

	public void setdUsername(String dUsername) {
		this.dUsername = dUsername;
	}

	public String getdBrand() {
		return dBrand;
	}

	public void setdBrand(String dBrand) {
		this.dBrand = dBrand;
	}

	public String getdField() {
		return dField;
	}

	public void setdField(String dField) {
		this.dField = dField;
	}

	public String getdAddress() {
		return dAddress;
	}

	public void setdAddress(String dAddress) {
		this.dAddress = dAddress;
	}

	public Integer getMarkSelect() {
		return markSelect;
	}

	public void setMarkSelect(Integer markSelect) {
		this.markSelect = markSelect;
	}

	public String getuBirthYear() {
		return uBirthYear;
	}

	public void setuBirthYear(String uBirthYear) {
		this.uBirthYear = uBirthYear;
	}

	public String getuBirthMoth() {
		return uBirthMoth;
	}

	public void setuBirthMoth(String uBirthMoth) {
		this.uBirthMoth = uBirthMoth;
	}

	public String getuBirthDay() {
		return uBirthDay;
	}

	public void setuBirthDay(String uBirthDay) {
		this.uBirthDay = uBirthDay;
	}

	public String getOldImg() {
		return oldImg;
	}

	public void setOldImg(String oldImg) {
		this.oldImg = oldImg;
	}

	public Integer getShoppingCount() {
		return shoppingCount;
	}
	
	public void setShoppingCount(Integer shoppingCount) {
		this.shoppingCount = shoppingCount;
	}

	public List<Model> getDesignerList() {
		return designerList;
	}

	public void setDesignerList(List<Model> designerList) {
		this.designerList = designerList;
	}

	public Integer getDcId() {
		return dcId;
	}

	public void setDcId(Integer dcId) {
		this.dcId = dcId;
	}

	public Integer getMarkOrder() {
		return markOrder;
	}

	public void setMarkOrder(Integer markOrder) {
		this.markOrder = markOrder;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", email="
				+ email + ", phone=" + phone + ", pwd=" + pwd + ", realname="
				+ realname + ", avatar=" + avatar + ", sex=" + sex + ", job="
				+ job + ", dFavoriteNum=" + dFavoriteNum + ", province="
				+ province + ", city=" + city + ", address=" + address
				+ ", zipcode=" + zipcode + ", validEmail=" + validEmail
				+ ", regTime=" + regTime + ", designerTime=" + designerTime
				+ ", groupId=" + groupId + ", dTag=" + dTag + ", studioStatus="
				+ studioStatus + ", applyDesigner=" + applyDesigner
				+ ", applyReason=" + applyReason + ", weiboId=" + weiboId
				+ ", qqOpenid=" + qqOpenid + ", wxOpenid=" + wxOpenid
				+ ", wxpOpenid=" + wxpOpenid + ", wxUnionid=" + wxUnionid
				+ ", introduce=" + introduce + ", qq=" + qq + ", weixin="
				+ weixin + ", delState=" + delState + ", dUsername="
				+ dUsername + ", dBrand=" + dBrand + ", dField=" + dField
				+ ", dAddress=" + dAddress + ", uBirthYear=" + uBirthYear
				+ ", uBirthMoth=" + uBirthMoth + ", uBirthDay=" + uBirthDay
				+ ", pageInfo=" + pageInfo + ", condition=" + condition
				+ ", markUserfrom=" + markUserfrom + ", markManage="
				+ markManage + ", markSelect=" + markSelect + ", sumCount="
				+ sumCount + ", pCount=" + pCount + ", wCount=" + wCount
				+ ", oldImg=" + oldImg + ", shoppingCount=" + shoppingCount
				+ "]";
	}

	 

}
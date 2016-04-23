package com.yfhl.entity;

import java.util.Date;

/**
 * 用户收货地址实体类
 * 
 * @author luans
 *
 */
public class UserAddress {

	private Integer id;// 唯一编号

	private Integer uid;// 用户ID

	private String username;// 收货人姓名

	private String telephone;// 电话

	private String email;// 邮箱

	private Integer zipcode;// 邮编

	private String province;// 省份

	private String city;// 城市

	private String address;// 地址

	private int isDefault;// 默认：1: 是 0：不是

	private Date addTime;// 添加时间

	private String addressArea;// 区

	private Integer provinceId;// 省份的id

	private Integer cityId;// 城市的id

	private Integer addressAreaid;// 区域的id
	
	// 自定义属性
	private Integer markManage;// 标记操作类型：1：添加；2：编辑；3：查看

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
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

	public String getAddressArea() {
		return addressArea;
	}

	public void setAddressArea(String addressArea) {
		this.addressArea = addressArea == null ? null : addressArea.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getAddressAreaid() {
		return addressAreaid;
	}

	public void setAddressAreaid(Integer addressAreaid) {
		this.addressAreaid = addressAreaid;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public Integer getMarkManage() {
		return markManage;
	}

	public void setMarkManage(Integer markManage) {
		this.markManage = markManage;
	}

	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", uid=" + uid + ", username="
				+ username + ", telephone=" + telephone + ", email=" + email
				+ ", zipcode=" + zipcode + ", province=" + province + ", city="
				+ city + ", address=" + address + ", isDefault=" + isDefault
				+ ", addTime=" + addTime + ", addressArea=" + addressArea
				+ ", provinceId=" + provinceId + ", cityId=" + cityId
				+ ", addressAreaid=" + addressAreaid + ", markManage="
				+ markManage + "]";
	}

}
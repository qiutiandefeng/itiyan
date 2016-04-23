package com.yfhl.entity;

import java.util.Date;

/**
 * 注册激活码表
 * 
 * @author luans
 * @date 2016年3月7日
 *
 */
public class ActiveAccount {

	private Integer aaId;// 注册码激活表ID

	private String aaName;// 注册用户的手机号/邮箱号

	private String aaPwd;// MD5加密后的密码

	private String aaActivecode;// 激活码

	private String aaUrl;// 激活成功后跳转的路径

	private Date aaDate;// 添加时间

	public Integer getAaId() {
		return aaId;
	}

	public void setAaId(Integer aaId) {
		this.aaId = aaId;
	}

	public String getAaName() {
		return aaName;
	}

	public void setAaName(String aaName) {
		this.aaName = aaName == null ? null : aaName.trim();
	}

	public String getAaPwd() {
		return aaPwd;
	}

	public void setAaPwd(String aaPwd) {
		this.aaPwd = aaPwd == null ? null : aaPwd.trim();
	}

	public String getAaActivecode() {
		return aaActivecode;
	}

	public void setAaActivecode(String aaActivecode) {
		this.aaActivecode = aaActivecode == null ? null : aaActivecode.trim();
	}

	public String getAaUrl() {
		return aaUrl;
	}

	public void setAaUrl(String aaUrl) {
		this.aaUrl = aaUrl == null ? null : aaUrl.trim();
	}

	public Date getAaDate() {
		return aaDate;
	}

	public void setAaDate(Date aaDate) {
		this.aaDate = aaDate;
	}

	@Override
	public String toString() {
		return "ActiveAccount [aaId=" + aaId + ", aaName=" + aaName
				+ ", aaPwd=" + aaPwd + ", aaActivecode=" + aaActivecode
				+ ", aaUrl=" + aaUrl + ", aaDate=" + aaDate + "]";
	}

}
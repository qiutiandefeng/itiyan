package com.yfhl.entity;

import java.util.Date;

public class Area {
    private Long id;

	private Date addtime;//添加时间

	private Boolean deletestatus;//状态

	private String areaname;//名称

	private Integer level;//级别

	private Integer sequence;

	private Long parentId;//父级

	private Boolean common;//省份为：1，其他级别为：0

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Boolean getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(Boolean deletestatus) {
		this.deletestatus = deletestatus;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Boolean getCommon() {
		return common;
	}

	public void setCommon(Boolean common) {
		this.common = common;
	}

	
}
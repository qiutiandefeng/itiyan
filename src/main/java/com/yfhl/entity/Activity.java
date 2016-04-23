package com.yfhl.entity;

/**
 * 活动实体类
 * @author luans
 *
 */
public class Activity {
	
    private Integer id;//

    private String name;//活动名称

    private String remark;//活动备注

    private Integer addTime;//添加时间

    private Integer startTime;//活动开始时间(cheap_code生效时间)

    private Integer endTime;//活动结束时间(cheap_code过期时间)

    private Integer userId;//活动添加用户

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
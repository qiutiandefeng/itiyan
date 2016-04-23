package com.yfhl.entity;

import java.util.Date;

/**
 * 优惠码表
 * @author luans
 *
 */
public class CheapCode {
    private Integer id;//优惠码ID

    private String codename;//优惠码

    private Integer money;//优惠金额

    private Integer moneyrange;//使用范围

    private Byte status;//使用状态

    private String tradeNo;//订单编号

    private Integer dueDate;//到期时间

    private Date addTime;//添加时间

    private Integer useTime;//使用时间

    private Byte isTake;//是否领取,0否 1是

    private Integer activityId;//所属活动id 0为其他(旧版设计冗余)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename == null ? null : codename.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getMoneyrange() {
        return moneyrange;
    }

    public void setMoneyrange(Integer moneyrange) {
        this.moneyrange = moneyrange;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public Integer getDueDate() {
        return dueDate;
    }

    public void setDueDate(Integer dueDate) {
        this.dueDate = dueDate;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    public Byte getIsTake() {
        return isTake;
    }

    public void setIsTake(Byte isTake) {
        this.isTake = isTake;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
}
package com.retech.common.entity;

import java.util.Date;

public class Order {
    private String orderid;

    private Integer userid;

    private Integer orderstatus;

    private Float money;

    private Date tradingtime;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Date getTradingtime() {
        return tradingtime;
    }

    public void setTradingtime(Date tradingtime) {
        this.tradingtime = tradingtime;
    }
}
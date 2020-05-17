package com.shiluying.platformbackend.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Proxy(lazy = false)
public class GoodOrder {
    @Id
    @GeneratedValue
    @NotNull
    private int order_id;
    @NotNull
    private int good_id;
    @NotNull
    private String time;
    @NotNull
    private int buyer_id;
    @NotNull
    private int seller_id;
    @NotNull
    private int state;

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public int getGood_id() {
        return good_id;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public String getTime() {
        return time;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
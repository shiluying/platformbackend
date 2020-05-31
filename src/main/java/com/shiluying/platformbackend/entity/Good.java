package com.shiluying.platformbackend.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Proxy(lazy = false)
public class Good {
    @Id
    @GeneratedValue
    private int good_id;
    private String good_name;
    private int state;
    private String photo;
    private String good_describe;
    private int num;
    private float price;
    private int user_id;

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getGood_describe() {
        return good_describe;
    }

    public void setGood_describe(String good_describe) {
        this.good_describe = good_describe;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Good{" +
                "good_id=" + good_id +
                ", good_name='" + good_name + '\'' +
                ", state=" + state +
                ", photo='" + photo + '\'' +
                ", good_describe='" + good_describe + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", user_id=" + user_id +
                '}';
    }
}

package com.shiluying.platformbackend.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Proxy(lazy = false)
public class User {
    @Id
    @GeneratedValue
    private int user_id;
    private String name;
    private String pwd;
    private int type;
    private int examine;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getType(){
        return type;
    }

    public void setType(int type){
        this.type=type;
    }

    public int getExamine(){
        return examine;
    }

    public void setExamine(int examine){
        this.examine=examine;
    }
}

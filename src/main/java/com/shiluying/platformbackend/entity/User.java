package com.shiluying.platformbackend.entity;


import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Proxy(lazy = false)
public class User {
    @Id
    @GeneratedValue
    private int user_id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    private String info;
    @NotNull
    private String pwd;
    @NotNull
    @Column(columnDefinition="int default 0",nullable=false)
    private int type;
    @NotNull
    @Column(columnDefinition="int default 0",nullable=false)
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", info='" + info + '\'' +
                ", pwd='" + pwd + '\'' +
                ", type=" + type +
                ", examine=" + examine +
                '}';
    }
}

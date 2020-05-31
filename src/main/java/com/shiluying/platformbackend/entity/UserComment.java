package com.shiluying.platformbackend.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Proxy(lazy = false)
public class UserComment {
    @Id
    @GeneratedValue
    @NotNull
    private int comment_id;
    private String comment;
    @NotNull
    private int user_id;
    private String photo;
    @NotNull
    private int sender_id;

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public int getComment_id() {
        return comment_id;
    }
}

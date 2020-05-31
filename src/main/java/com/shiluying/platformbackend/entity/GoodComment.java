package com.shiluying.platformbackend.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Proxy(lazy = false)
public class GoodComment {
    @Id
    @GeneratedValue
    @NotNull
    private int comment_id;
    @NotNull
    private String comment;
    private String photo;
    @NotNull
    private int good_id;
    @NotNull
    private int buyer_id;

    public int getBuyer_id() {
        return buyer_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public int getGood_id() {
        return good_id;
    }

    public String getComment() {
        return comment;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }
}

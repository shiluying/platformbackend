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
    private int seller_id;
    @NotNull
    private int buyer_id;

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
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

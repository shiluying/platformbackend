package com.shiluying.platformbackend.dao;

import com.shiluying.platformbackend.entity.UserComment;

import java.util.List;

public interface UserCommentDao {
    List<UserComment> findCommentById(Integer user_id);

    UserComment addUserComment(UserComment userComment);
}
package com.shiluying.platformbackend.dao;

import com.shiluying.platformbackend.entity.UserComment;

import java.util.List;

public interface UserCommentDao {
    List<UserComment> getUserCommentByReceiverId(Integer receiver_id);

    UserComment addUserComment(UserComment userComment);
}

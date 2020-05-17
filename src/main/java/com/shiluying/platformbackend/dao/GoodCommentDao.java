package com.shiluying.platformbackend.dao;

import com.shiluying.platformbackend.entity.GoodComment;

import java.util.List;

public interface GoodCommentDao {
    List<GoodComment> findCommentById(Integer good_id);

    GoodComment addGoodComment(GoodComment goodComment);
}

package com.shiluying.platformbackend.daoImpl;

import com.shiluying.platformbackend.dao.GoodCommentDao;
import com.shiluying.platformbackend.entity.GoodComment;
import com.shiluying.platformbackend.repository.GoodCommentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodCommentDaoImpl implements GoodCommentDao {
    @Autowired
    private GoodCommentRespository goodCommentRespository;

    @Override
    public List<GoodComment> findCommentById(Integer good_id) {
        return goodCommentRespository.findCommentById(good_id);
    }

    @Override
    public GoodComment addGoodComment(GoodComment goodComment) {
        return goodCommentRespository.save(goodComment);
    }
}

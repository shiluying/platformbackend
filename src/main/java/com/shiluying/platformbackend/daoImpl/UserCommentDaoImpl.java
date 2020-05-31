package com.shiluying.platformbackend.daoImpl;

import com.shiluying.platformbackend.dao.UserCommentDao;
import com.shiluying.platformbackend.entity.UserComment;
import com.shiluying.platformbackend.repository.UserCommentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserCommentDaoImpl implements UserCommentDao {
    @Autowired
    private UserCommentRespository userCommentRespository;

    @Override
    public List<UserComment> findCommentById(Integer sender_id) {
        return userCommentRespository.findCommentById(sender_id);
    }

    @Override
    public UserComment addUserComment(UserComment userComment) {
        return userCommentRespository.save(userComment);
    }
}

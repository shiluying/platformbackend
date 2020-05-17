package com.shiluying.platformbackend.serviceImpl;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.dao.UserCommentDao;
import com.shiluying.platformbackend.entity.UserComment;
import com.shiluying.platformbackend.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentServiceImpl implements UserCommentService {
    @Autowired
    private UserCommentDao userCommentDao;

    @Override
    public ServerResponse findUserCommentById(Integer user_id) {
        ServerResponse serverResponse;
        List<UserComment> userComments=userCommentDao.findCommentById(user_id);
        serverResponse=ServerResponse.createBySuccess(userComments);
        return serverResponse;
    }

    @Override
    public ServerResponse addUserComment(String comment, int buyer_id, int seller_id) {
        ServerResponse serverResponse;
        UserComment userComment=new UserComment();
        userComment.setBuyer_id(buyer_id);
        userComment.setComment(comment);
        userComment.setSeller_id(seller_id);
        UserComment userCommentInfo = userCommentDao.addUserComment(userComment);
        if(userCommentInfo!=null) {
            serverResponse = ServerResponse.createBySuccess("用户评论添加成功", userCommentInfo);
        }else {
            serverResponse = ServerResponse.createByErrorMessage("用户评论添加失败");
        }
        return serverResponse;
    }
}

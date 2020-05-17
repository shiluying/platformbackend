package com.shiluying.platformbackend.serviceImpl;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.dao.GoodCommentDao;
import com.shiluying.platformbackend.entity.GoodComment;
import com.shiluying.platformbackend.service.GoodCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodCommentServiceImpl implements GoodCommentService {
    @Autowired
    private GoodCommentDao goodCommentDao;

    @Override
    public ServerResponse findGoodCommentById(Integer good_id) {
        ServerResponse serverResponse;
        List<GoodComment> goodComments=goodCommentDao.findCommentById(good_id);
        serverResponse=ServerResponse.createBySuccess(goodComments);
        return serverResponse;
    }

    @Override
    public ServerResponse addGoodComment(String comment, int buyer_id, int good_id) {
        ServerResponse serverResponse;
        GoodComment goodComment=new GoodComment();
        goodComment.setBuyer_id(buyer_id);
        goodComment.setComment(comment);
        goodComment.setGood_id(good_id);
        GoodComment goodCommentInfo = goodCommentDao.addGoodComment(goodComment);
        if(goodCommentInfo!=null) {
            serverResponse = ServerResponse.createBySuccess("商品评论添加成功", goodCommentInfo);
        }else {
            serverResponse = ServerResponse.createByErrorMessage("商品评论添加失败");
        }
        return serverResponse;
    }
}

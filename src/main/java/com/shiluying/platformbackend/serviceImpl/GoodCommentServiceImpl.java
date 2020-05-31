package com.shiluying.platformbackend.serviceImpl;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.dao.GoodCommentDao;
import com.shiluying.platformbackend.entity.GoodComment;
import com.shiluying.platformbackend.service.GoodCommentService;
import com.shiluying.platformbackend.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ServerResponse addGoodComment(GoodComment goodComment) {
        ServerResponse serverResponse;
        GoodComment goodCommentInfo = goodCommentDao.addGoodComment(goodComment);
        if(goodCommentInfo!=null) {
            serverResponse = ServerResponse.createBySuccess("商品评论添加成功", goodCommentInfo);
        }else {
            serverResponse = ServerResponse.createByErrorMessage("商品评论添加失败");
        }
        return serverResponse;
    }
    @Override
    public ServerResponse upLoadImg(MultipartFile multipartFile) throws IOException {
        ServerResponse serverResponse;
        ImageUtil imageUtil = new ImageUtil();
        String path = imageUtil.uploadImg(multipartFile,imageUtil.GOODCOMMENT_IMG);
        String filename = multipartFile.getOriginalFilename();
        Map dict = new HashMap();
        dict.put("name",filename);
        dict.put("url",path);
        serverResponse=ServerResponse.createBySuccess(dict);
        return serverResponse;
    }
}

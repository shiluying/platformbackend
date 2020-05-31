package com.shiluying.platformbackend.serviceImpl;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.dao.UserCommentDao;
import com.shiluying.platformbackend.entity.UserComment;
import com.shiluying.platformbackend.service.UserCommentService;
import com.shiluying.platformbackend.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserCommentServiceImpl implements UserCommentService {
    @Autowired
    private UserCommentDao userCommentDao;

    @Override
    public ServerResponse getUserCommentByReceiverId(Integer receiver_id) {
        ServerResponse serverResponse;
        List<UserComment> userComments=userCommentDao.getUserCommentByReceiverId(receiver_id);
        serverResponse=ServerResponse.createBySuccess(userComments);
        return serverResponse;
    }

    @Override
    public ServerResponse addUserComment(UserComment userComment) {
        ServerResponse serverResponse;
        UserComment userCommentInfo = userCommentDao.addUserComment(userComment);
        if(userCommentInfo!=null) {
            serverResponse = ServerResponse.createBySuccess("用户评论添加成功", userCommentInfo);
        }else {
            serverResponse = ServerResponse.createByErrorMessage("用户评论添加失败");
        }
        return serverResponse;
    }
    @Override
    public ServerResponse upLoadImg(MultipartFile multipartFile) throws IOException {
        ServerResponse serverResponse;
        ImageUtil imageUtil = new ImageUtil();
        String path = imageUtil.uploadImg(multipartFile,imageUtil.USERCOMMENT_IMG);
        String filename = multipartFile.getOriginalFilename();
        Map dict = new HashMap();
        dict.put("name",filename);
        dict.put("url",path);
        serverResponse=ServerResponse.createBySuccess(dict);
        return serverResponse;
    }
}

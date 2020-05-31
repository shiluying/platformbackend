package com.shiluying.platformbackend.controller;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.entity.UserComment;
import com.shiluying.platformbackend.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UserCommentController {
    @Autowired
    private UserCommentService usercommentService;

//    查找所有包含user_id的评论
    @RequestMapping(value = "/getUserCommentByUserId",method = RequestMethod.GET)
    public ServerResponse getUserCommentByUserId(@RequestParam("sender_id") int sender_id) {
        return usercommentService.findUserCommentById(sender_id);
    }

//    添加用户评论
    @RequestMapping(value = "/addUserComment",method = RequestMethod.POST)
    public ServerResponse addUserComment(@RequestBody UserComment userComment) {
        return usercommentService.addUserComment(userComment);
    }
    //    上传图片
    @RequestMapping("/upLoadUserCommenntImg")
    public ServerResponse upLoadImg(@PathVariable("file") MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            return usercommentService.upLoadImg(file);
        }
        return null;
    }


}

package com.shiluying.platformbackend.controller;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserCommentController {
    @Autowired
    private UserCommentService usercommentService;

//    查找所有包含user_id的评论
    @RequestMapping(value = "/getUserComment",method = RequestMethod.GET)
    public ServerResponse findUserCommentById(@RequestParam("user_id") int user_id) {
        return usercommentService.findUserCommentById(user_id);
    }

//    添加用户评论
    @RequestMapping(value = "/addUserComment",method = RequestMethod.GET)
    public ServerResponse addUserComment(@RequestParam ("comment") String comment,
                                         @RequestParam ("buyer_id") int buyer_id,
                                         @RequestParam ("seller_id") int seller_id) {
        return usercommentService.addUserComment(comment,buyer_id,seller_id);
    }

}

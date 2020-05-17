package com.shiluying.platformbackend.controller;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.service.GoodCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class GoodCommentController {
    @Autowired
    private GoodCommentService goodcommentService;

    //    查找所有包含good_id的评论
    @RequestMapping(value = "/getGoodComment",method = RequestMethod.GET)
    public ServerResponse findGoodCommentById(@RequestParam("good_id") int good_id) {
        return goodcommentService.findGoodCommentById(good_id);
    }

    //    添加用户评论
    @RequestMapping(value = "/addGoodComment",method = RequestMethod.GET)
    public ServerResponse addGoodComment(
                                         @RequestParam("comment") String comment,
                                         @RequestParam("buyer_id") int buyer_id,
                                         @RequestParam("good_id") int good_id) {
        return goodcommentService.addGoodComment(comment,buyer_id,good_id);
    }
}

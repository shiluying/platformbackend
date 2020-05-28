package com.shiluying.platformbackend.controller;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.service.GoodCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class GoodCommentController {
    @Autowired
    private GoodCommentService goodcommentService;

    //    查找所有包含good_id的评论
    @RequestMapping(value = "/getGoodCommentByGoodId",method = RequestMethod.GET)
    public ServerResponse getGoodCommentByGoodId(@RequestParam("good_id") int good_id) {
        return goodcommentService.findGoodCommentById(good_id);
    }

    //    添加商品评论
    @RequestMapping(value = "/addGoodComment",method = RequestMethod.GET)
    public ServerResponse addGoodComment(
                                         @RequestParam("comment") String comment,
                                         @RequestParam("buyer_id") int buyer_id,
                                         @RequestParam("good_id") int good_id) {
        return goodcommentService.addGoodComment(comment,buyer_id,good_id);
    }
}

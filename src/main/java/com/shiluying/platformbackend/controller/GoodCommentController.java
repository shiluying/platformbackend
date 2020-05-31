package com.shiluying.platformbackend.controller;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.entity.GoodComment;
import com.shiluying.platformbackend.entity.UserComment;
import com.shiluying.platformbackend.service.GoodCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


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
    @RequestMapping(value = "/addGoodComment",method = RequestMethod.POST)
    public ServerResponse addGoodComment(@RequestBody GoodComment goodComment) {
        return goodcommentService.addGoodComment(goodComment);
    }
    //    上传图片
    @RequestMapping("/upLoadGoodCommentImg")
    public ServerResponse upLoadImg(@PathVariable("file") MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            return goodcommentService.upLoadImg(file);
        }
        return null;
    }
}

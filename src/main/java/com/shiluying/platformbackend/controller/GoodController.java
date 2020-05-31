package com.shiluying.platformbackend.controller;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.entity.Good;
import com.shiluying.platformbackend.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
public class GoodController {
    @Autowired
    private GoodService goodService;

//    根据商品ID查找商品
    @RequestMapping(value = "/findGoodByFilter",method = RequestMethod.GET)
    public ServerResponse findGoodByFilter(@RequestParam("filter") String filter) {
        return goodService.findGoodByFilter(filter);
    }

//    查找所有商品
    @RequestMapping(value = "/findAllGood",method = RequestMethod.GET)
    public ServerResponse findAllGood() {
        return goodService.findAllGood();
    }

//    根据用户ID查找商品
    @RequestMapping(value = "/findGoodByUserId",method = RequestMethod.GET)
    public ServerResponse findGoodByUserId(@RequestParam("user_id") Integer user_id) {
        return goodService.findGoodByUserId(user_id);
    }

//    查找处于某种状态的商品（商品审核）
    @RequestMapping(value = "/findGoodByState",method = RequestMethod.GET)
    public ServerResponse findGoodByState(@RequestParam("state") Integer state) {
        return goodService.findGoodByState(state);
    }

//    修改某商品的状态
    @RequestMapping(value = "/changeGoodState",method = RequestMethod.PUT)
    public ServerResponse changeGoodState(@RequestBody Good good) {
        return goodService.changeGoodState(good.getGood_id(),good.getState());
    }

//    添加商品
    @RequestMapping(value = "/addGood",method = RequestMethod.POST)
    public ServerResponse addGood(@RequestBody Good good) {

        return goodService.addGood(good);
    }

//    修改商品
    @RequestMapping(value = "/changeGood",method = RequestMethod.PUT)
    public ServerResponse changeGood(@RequestBody Good good) {
        return goodService.changeGood(good);
    }

//    上传图片
    @RequestMapping("/upLoadImg")
    public ServerResponse upLoadImg(@PathVariable("file") MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            return goodService.upLoadImg(file);
        }
       return null;
    }

//    购买商品
    @RequestMapping(value = "/buyGood",method = RequestMethod.PUT)
    public ServerResponse buyGood(@RequestBody Good good) {
        System.out.println(good.toString());
        return goodService.buyGood(good);
    }

//    删除商品
    @RequestMapping(value = "/deleteGood",method = RequestMethod.DELETE)
    public ServerResponse deleteGood(@RequestParam("id") Integer id) {
        return goodService.deleteGood(id);
    }
}

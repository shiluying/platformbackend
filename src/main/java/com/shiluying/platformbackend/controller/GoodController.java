package com.shiluying.platformbackend.controller;

import com.shiluying.platformbackend.Response.ServerResponse;
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
    @GetMapping(value = "/findGood/{id}")
    public ServerResponse findGood(@PathVariable("id") Integer id) {
        return goodService.findGoodById(id);
    }

//    查找所有商品
    @GetMapping(value = "/findGood")
    public ServerResponse findGood() {
        return goodService.findAllGood();
    }

//    根据用户ID查找商品
    @GetMapping(value = "/findAllByUserId/{user_id}")
    public ServerResponse findAllByUserId(@PathVariable("user_id") Integer user_id) {
        return goodService.findAllByUserId(user_id);
    }

//    查找处于某种状态的商品（商品审核）
    @GetMapping(value = "/findAllByState/{state}")
    public ServerResponse findAllByState(@PathVariable("state") Integer state) {
        return goodService.findAllByState(state);
    }

//    修改某商品的状态
    @GetMapping(value = "/changeGoodState/{id}/{state}")
    public ServerResponse changeGoodState(@PathVariable("id") Integer id,@PathVariable("state") Integer state) {
        return goodService.changeGoodState(id,state);
    }

//    添加商品
    @RequestMapping(value = "/addGood",method = RequestMethod.GET)
    public ServerResponse addGood( @RequestParam("good_describe") String good_describe,
                                  @RequestParam("photo") String photo,
                                  @RequestParam("price") float price,
                                   @RequestParam("user_id") Integer user_id) {
        return goodService.addGood(good_describe,photo,price,user_id);
    }

//    修改商品
    @RequestMapping(value = "/changeGood",method = RequestMethod.GET)
    public ServerResponse changeGood(@RequestParam("id") Integer id,
                                     @RequestParam("state") Integer state,
                                     @RequestParam String photo,
                                     @RequestParam String good_describe,
                                     @RequestParam("price") float price) {
        return goodService.changeGood(id,state,photo,good_describe,price);
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
    @GetMapping(value = "/buyGood/{id}")
    public ServerResponse buyGood(@PathVariable("id") Integer id) {
        return goodService.buyGood(id);
    }

//    删除商品
    @RequestMapping(value = "/deleteGood",method = RequestMethod.GET)
    public ServerResponse deleteGood(@RequestParam("id") Integer id) {
        return goodService.deleteGood(id);
    }
}

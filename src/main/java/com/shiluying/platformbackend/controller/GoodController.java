package com.shiluying.platformbackend.controller;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.entity.Good;
import com.shiluying.platformbackend.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

//    添加商品，默认state为0
    @GetMapping(value = "/addGood/{id}/{good_describe}/{price}/{user_id}")
    public ServerResponse addGood(@PathVariable("id") Integer id, @PathVariable("good_describe") String good_describe,
                                  @PathVariable("price") float price, @PathVariable("user_id") Integer user_id) {
        return goodService.addGood(id,good_describe,price,user_id);
    }
}

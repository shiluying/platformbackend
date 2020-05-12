package com.shiluying.platformbackend.controller;

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

    @GetMapping(value = "/findGood/{id}")
    public Good findGood(@PathVariable("id") Integer id) {
        return goodService.findGoodById(id);
    }

    @GetMapping(value = "/checkGood/{state}")
    public List<Good> checkGood(@PathVariable("state") Integer state) {
        return goodService.checkGood(state);
    }

    @GetMapping(value = "/changeGoodState/{id}/{state}")
    public boolean changeGoodState(@PathVariable("id") Integer id,@PathVariable("state") Integer state) {
        return goodService.changeGoodState(id,state);
    }

}

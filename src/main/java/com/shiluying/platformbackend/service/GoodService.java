package com.shiluying.platformbackend.service;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.entity.Good;

import java.util.List;

public interface GoodService {
    ServerResponse findGoodById(Integer id);
    ServerResponse findAllGood();
    ServerResponse findAllByState(Integer state);
    ServerResponse changeGoodState(Integer id, Integer state);
    ServerResponse addGood(Integer id,String good_describe,float price,Integer user_id);
    ServerResponse findAllByUserId(Integer user_id);
}

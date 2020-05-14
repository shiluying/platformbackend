package com.shiluying.platformbackend.service;

import com.shiluying.platformbackend.Response.ServerResponse;

public interface GoodService {
    ServerResponse findGoodById(Integer id);
    ServerResponse findAllGood();
    ServerResponse findAllByState(Integer state);
    ServerResponse changeGoodState(Integer id, Integer state);
    ServerResponse changeGood(Integer id,Integer state,String good_describe,float price);
    ServerResponse addGood(String good_describe,float price,Integer user_id);
    ServerResponse findAllByUserId(Integer user_id);
}

package com.shiluying.platformbackend.service;

import com.shiluying.platformbackend.Response.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface GoodService {

    int findGoodStateById(Integer id);

    ServerResponse findAllGood();
    ServerResponse findAllByState(Integer state);
    ServerResponse changeGoodState(Integer id, Integer state);
    ServerResponse changeGood(Integer id,Integer state,String photo,String good_describe,float price);
    ServerResponse addGood(String good_describe,String photo,float price,Integer user_id);
    ServerResponse findAllByUserId(Integer user_id);
    ServerResponse upLoadImg(MultipartFile multipartFile) throws IOException;

    ServerResponse buyGood(Integer id);

    ServerResponse deleteGood(Integer id);

    ServerResponse findGoodById(Integer id);
}

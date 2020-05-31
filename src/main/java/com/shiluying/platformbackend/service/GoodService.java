package com.shiluying.platformbackend.service;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.entity.Good;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface GoodService {

    ServerResponse findAllGood();

    ServerResponse findGoodByState(Integer state);

    ServerResponse changeGoodState(Integer id, Integer state);

    ServerResponse changeGood(Good good);

    ServerResponse addGood(Good good);

    ServerResponse findGoodByUserId(Integer user_id);

    ServerResponse upLoadImg(MultipartFile multipartFile) throws IOException;

    ServerResponse buyGood(Good good);

    ServerResponse deleteGood(Integer id);

    ServerResponse findGoodById(Integer id);

    ServerResponse findGoodByFilter(String filter);
}

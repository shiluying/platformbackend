package com.shiluying.platformbackend.service;

import com.shiluying.platformbackend.entity.Good;

import java.util.List;

public interface GoodService {
    Good findGoodById(Integer id);
    List<Good> findAllGood();
    List<Good> checkGood(Integer state);
    Boolean changeGoodState(Integer id,Integer state);
}

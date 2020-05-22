package com.shiluying.platformbackend.dao;

import com.shiluying.platformbackend.entity.Good;

import java.util.List;

public interface GoodDao {
    void deleteGood(Integer id);
    Good findOne(Integer id);
    List<Good> findAll();
    List<Good> findAllByState(Integer state);
    int changeGoodState(Integer id, Integer state);
    Good addGood(Good good);
    List<Good> findAllByUserId(Integer user_id);
    int changeGood(Integer id, Integer state,String photo, String good_describe, float price);
}

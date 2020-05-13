package com.shiluying.platformbackend.dao;

import com.shiluying.platformbackend.entity.Good;

import java.util.List;
import java.util.Map;

public interface GoodDao {
    Good findOne(Integer id);
    List<Good> findAll();
    List<Good> findAllByState(Integer state);
    int changeGoodState(Integer id, Integer state);
    Good addGood(Good good);
    List<Good> findAllByUserId(Integer user_id);
}

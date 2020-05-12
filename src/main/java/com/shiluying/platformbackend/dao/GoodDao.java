package com.shiluying.platformbackend.dao;

import com.shiluying.platformbackend.entity.Good;

import java.util.List;

public interface GoodDao {
    Good findOne(Integer id);
    List<Good> findAll();
    void changeGoodState(Integer id, Integer state);
}

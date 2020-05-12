package com.shiluying.platformbackend.dao;

import com.shiluying.platformbackend.entity.User;

public interface UserDao {
    User findOne(Integer id);
}

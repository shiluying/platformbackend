package com.shiluying.platformbackend.service;

import com.shiluying.platformbackend.entity.User;

public interface UserService {
    User findUserById(Integer id);
    Boolean checkUser(Integer id,String pwd);
}
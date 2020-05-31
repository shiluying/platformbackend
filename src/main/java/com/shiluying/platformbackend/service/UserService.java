package com.shiluying.platformbackend.service;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.entity.User;

public interface UserService {
    ServerResponse findUserById(Integer id);
    ServerResponse findAllUser();
    ServerResponse checkUser(String email,String pwd);
    ServerResponse changeUserType(Integer id,Integer type);
    ServerResponse changeUserExamine(Integer id,Integer examine);
    ServerResponse addUser(User user);
    ServerResponse deleteUser(Integer id);

    ServerResponse checkAdminUser(String email, String pwd);
}
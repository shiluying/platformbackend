package com.shiluying.platformbackend.service;

import com.shiluying.platformbackend.Response.ServerResponse;

public interface UserService {
    ServerResponse findUserById(Integer id);
    ServerResponse findAllUser();
    ServerResponse checkUser(Integer id,String pwd);
    ServerResponse changeUserType(Integer id,Integer type);
    ServerResponse changeUserExamine(Integer id,Integer examine);
    ServerResponse addUser(Integer id,String name,String pwd,Integer type,Integer examine);
    ServerResponse deleteUser(Integer id);
}
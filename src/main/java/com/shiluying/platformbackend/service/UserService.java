package com.shiluying.platformbackend.service;

import com.shiluying.platformbackend.entity.User;

import java.util.List;

public interface UserService {
    User findUserById(Integer id);
    List<User> findAllUser();
    Boolean checkUser(Integer id,String pwd);
    Boolean changeUserType(Integer id,Integer type);
    Boolean changeUserExamine(Integer id,Integer examine);
    Boolean addUser(Integer id,String name,String pwd,Integer type,Integer examine);
    Boolean deleteUser(Integer id);
}
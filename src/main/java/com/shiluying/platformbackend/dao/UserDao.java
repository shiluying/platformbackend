package com.shiluying.platformbackend.dao;

import com.shiluying.platformbackend.entity.User;

import java.util.List;

public interface UserDao {
    User findOne(Integer id);
    List<User> findAll();
    int changeUserType(Integer id, Integer type);
    int changeUserExamine(Integer id, Integer examine);
    User addUser(User user);
    List<User> checkUser(Integer id,String pwd);
    void deleteUser(Integer id);
}

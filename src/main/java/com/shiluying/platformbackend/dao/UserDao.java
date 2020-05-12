package com.shiluying.platformbackend.dao;

import com.shiluying.platformbackend.entity.User;

import java.util.List;

public interface UserDao {
    User findOne(Integer id);
    List<User> findAll();
    void changeUserType(Integer id, Integer type);
    void changeUserExamine(Integer id, Integer examine);
    void addUser(User user);
    void deleteUser(Integer id);
}

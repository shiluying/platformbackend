package com.shiluying.platformbackend.serviceImpl;

import com.shiluying.platformbackend.dao.UserDao;
import com.shiluying.platformbackend.entity.User;
import com.shiluying.platformbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(Integer id) {
        return userDao.findOne(id);
    }
    @Override
    public Boolean checkUser(Integer id, String pwd){
        User user=findUserById(id);
        if(user==null){
        }else if(user.getPwd().equals(pwd)){
            return true;
        }
        return false;
    }
}

package com.shiluying.platformbackend.serviceImpl;

import com.shiluying.platformbackend.dao.UserDao;
import com.shiluying.platformbackend.entity.User;
import com.shiluying.platformbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(Integer id) {
        return userDao.findOne(id);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAll();
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

    @Override
    public Boolean changeUserType(Integer id, Integer type) {
        userDao.changeUserType(id,type);
        return true;
    }

    @Override
    public Boolean changeUserExamine(Integer id, Integer examine) {
        userDao.changeUserExamine(id,examine);
        return true;
    }

    @Override
    public Boolean addUser(Integer id, String name, String pwd, Integer type, Integer examine) {
        User user = new User();
        user.setUser_id(id);
        user.setName(name);
        user.setPwd(pwd);
        user.setType(type);
        user.setExamine(examine);
        userDao.addUser(user);
        return true;
    }

    @Override
    public Boolean deleteUser(Integer id) {
        userDao.deleteUser(id);
        return true;
    }
}

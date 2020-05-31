package com.shiluying.platformbackend.daoImpl;

import com.shiluying.platformbackend.dao.UserDao;
import com.shiluying.platformbackend.entity.User;
import com.shiluying.platformbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;


    @Override
    public User findOne(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public int changeUserType(Integer id, Integer type) {
        return userRepository.updateTypeById(id,type);
    }

    @Override
    public int changeUserExamine(Integer id, Integer examine) {
        return userRepository.updateExamineById(id,examine);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> checkUser(String email,String pwd) {
        return userRepository.checkUser(email,pwd);
    }
}
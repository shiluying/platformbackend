package com.shiluying.platformbackend.daoImpl;

import com.shiluying.platformbackend.dao.UserDao;
import com.shiluying.platformbackend.entity.User;
import com.shiluying.platformbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;


    @Override
    public User findOne(Integer id) {
        return userRepository.getOne(id);
    }
}
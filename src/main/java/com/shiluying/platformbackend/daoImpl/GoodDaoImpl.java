package com.shiluying.platformbackend.daoImpl;

import com.shiluying.platformbackend.dao.GoodDao;
import com.shiluying.platformbackend.entity.Good;
import com.shiluying.platformbackend.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodDaoImpl implements GoodDao {
    @Autowired
    private GoodRepository goodRepository;


    @Override
    public Good findOne(Integer id) {
        return goodRepository.getOne(id);
    }

    @Override
    public List<Good> findAll() {
        return goodRepository.findAll();
    }

    @Override
    public void changeGoodState(Integer id, Integer state) {
        goodRepository.updateStateById(id,state);
    }
}
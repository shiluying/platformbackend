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
        Good good;
        try{
            good=goodRepository.getOne(id);
        }catch (Exception e){
            System.out.println("can not find good by id");
            good=null;
        }
        return good;
    }

    @Override
    public List<Good> findAll() {
        return goodRepository.findAll();
    }

    @Override
    public List<Good> findAllByState(Integer state) {
        return goodRepository.findAllByState(state);
    }

    @Override
    public List<Good> findAllByUserId(Integer user_id) {
        return goodRepository.findAllByUserId(user_id);
    }

    @Override
    public int changeGoodState(Integer id, Integer state) {
        return goodRepository.updateStateById(id,state);
    }

    @Override
    public int changeGood(Integer id, Integer state, String good_describe, float price) {
        return goodRepository.updateGood(id,state,good_describe,price);
    }

    @Override
    public Good addGood(Good good) {
        return goodRepository.save(good);
    }
}
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
    public void deleteGood(Integer id) {
        goodRepository.deleteById(id);
    }

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
    public List<Good> findAllGoodName(String good_name) {
        return goodRepository.findAllGoodName("%"+good_name+"%");
    }

    @Override
    public int changeGoodState(Integer id, Integer state) {
        return goodRepository.updateStateById(id,state);
    }

    @Override
    public int changeGood(Good good) {
        return goodRepository.updateGood(good.getGood_id(),good.getGood_name(),good.getState(),good.getPhoto(),good.getGood_describe(),good.getNum(),good.getPrice()
        );
    }

    @Override
    public Good addGood(Good good) {
        return goodRepository.save(good);
    }
}
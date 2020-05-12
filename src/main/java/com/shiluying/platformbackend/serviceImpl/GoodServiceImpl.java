package com.shiluying.platformbackend.serviceImpl;

import com.shiluying.platformbackend.dao.GoodDao;
import com.shiluying.platformbackend.entity.Good;
import com.shiluying.platformbackend.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodDao goodDao;

    @Override
    public Good findGoodById(Integer id) {
        return goodDao.findOne(id);
    }

    @Override
    public List<Good> findAllGood() {
        return goodDao.findAll();
    }

    @Override
    public List<Good> checkGood(Integer state) {
        List<Good> goodList = new ArrayList<Good>();
        List<Good> goods =findAllGood();
        for(Good good : goods){
            if(good.getState()==state){
                goodList.add(good);
            }
        }
        return goodList;
    }

    @Override
    public Boolean changeGoodState(Integer id, Integer state) {
        goodDao.changeGoodState(id,state);
        return true;
    }
}

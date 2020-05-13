package com.shiluying.platformbackend.serviceImpl;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.dao.GoodDao;
import com.shiluying.platformbackend.entity.Good;
import com.shiluying.platformbackend.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodDao goodDao;

    @Override
    public ServerResponse findGoodById(Integer id) {
        ServerResponse serverResponse;
        Good good=goodDao.findOne(id);
        if(good==null){
            serverResponse=ServerResponse.createByErrorMessage("商品不存在");
        }else{
            serverResponse=ServerResponse.createBySuccess("商品存在",good);
        }
        return serverResponse;
    }

    @Override
    public ServerResponse findAllGood() {
        ServerResponse serverResponse;
        List<Good> goods=goodDao.findAll();
        serverResponse=ServerResponse.createBySuccess(goods);
        return serverResponse;
    }

    @Override
    public ServerResponse findAllByState(Integer state) {
        ServerResponse serverResponse;
        List<Good> goodList =goodDao.findAllByState(state);
        serverResponse=ServerResponse.createBySuccess(goodList);
        return serverResponse;
    }
    @Override
    public ServerResponse changeGoodState(Integer id, Integer state) {
        ServerResponse serverResponse;
//        确认商品是否存在
        serverResponse=findGoodById(id);
        if(serverResponse.getStatus()==500){// 商品不存在
            return serverResponse;
        }else if(serverResponse.getStatus()==200) {// 商品存在， 修改商品状态
           int code= goodDao.changeGoodState(id,state);
           if(code==1){
               serverResponse=ServerResponse.createBySuccessMessage("商品状态修改成功");
           }else{
               serverResponse=ServerResponse.createByErrorMessage("商品状态修改失败");
           }
        }else{
            serverResponse=ServerResponse.createByError();
        }
        return serverResponse;
    }

    @Override
    public ServerResponse addGood(Integer id, String good_describe, float price, Integer user_id) {
        ServerResponse serverResponse;
        Good good=new Good();
        good.setGood_id(id);
        good.setGood_describe(good_describe);
        good.setPrice(price);
        good.setUser_id(user_id);
        Good good_info=goodDao.addGood(good);
        if(good_info!=null) {
            serverResponse = ServerResponse.createBySuccess("商品添加成功", good_info);
        }else {
            serverResponse = ServerResponse.createByErrorMessage("商品添加失败");
        }
        return serverResponse;
    }

    @Override
    public ServerResponse findAllByUserId(Integer user_id) {
        ServerResponse serverResponse;
        List<Good> goodList =goodDao.findAllByUserId(user_id);
        serverResponse=ServerResponse.createBySuccess(goodList);
        return serverResponse;
    }
}

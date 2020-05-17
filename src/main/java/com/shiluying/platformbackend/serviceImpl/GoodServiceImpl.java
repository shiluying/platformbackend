package com.shiluying.platformbackend.serviceImpl;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.dao.GoodDao;
import com.shiluying.platformbackend.entity.Good;
import com.shiluying.platformbackend.service.GoodService;
import com.shiluying.platformbackend.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodDao goodDao;

    @Override
    public ServerResponse findGoodById(Integer id) {
        ServerResponse serverResponse;
        Good good=goodDao.findOne(id);
        if(good!=null){
            serverResponse=ServerResponse.createBySuccess("商品存在",good);

        }else{
            serverResponse=ServerResponse.createByErrorMessage("商品不存在");
        }
        return serverResponse;
    }
//    确认商品状态
    @Override
    public int findGoodStateById(Integer id){
        Good good=goodDao.findOne(id);
        if(good!=null){
            return good.getState();
        }else{
            return -1;
        }
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
               serverResponse=ServerResponse.createBySuccess("商品状态修改成功",serverResponse.getData());
           }else{
               serverResponse=ServerResponse.createByErrorMessage("商品状态修改失败");
           }
        }else{
            serverResponse=ServerResponse.createByError();
        }
        return serverResponse;
    }

    @Override
    public ServerResponse changeGood(Integer id, Integer state, String good_describe, float price) {
        ServerResponse serverResponse;
//        确认商品是否存在
        serverResponse=findGoodById(id);
        if(serverResponse.getStatus()==500){// 商品不存在
            return serverResponse;
        }else if(serverResponse.getStatus()==200) {// 商品存在， 修改商品
            int code= goodDao.changeGood(id,state,good_describe,price);
            if(code==1){
                serverResponse=ServerResponse.createBySuccessMessage("商品修改成功");
            }else{
                serverResponse=ServerResponse.createByErrorMessage("商品修改失败");
            }
        }else{
            serverResponse=ServerResponse.createByError();
        }
        return serverResponse;
    }

    @Override
    public ServerResponse addGood(String good_describe, float price, Integer user_id) {
        ServerResponse serverResponse;
        Good good=new Good();
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

    @Override
    public ServerResponse upLoadImg(MultipartFile multipartFile) throws IOException {
        ServerResponse serverResponse;
        ImageUtil imageUtil = new ImageUtil();
        String path = imageUtil.uploadImg(multipartFile,imageUtil.COMMODITY_IMG);
        serverResponse=ServerResponse.createBySuccess(path);
        return serverResponse;
    }

    @Override
    public ServerResponse buyGood(Integer id) {
        ServerResponse serverResponse;
        Good good =goodDao.findOne(id);
//        商品已被锁定，不能购买
        if(good.getState()==2){
            serverResponse=ServerResponse.createByErrorMessage("商品已被锁定，不能购买");
        }else if(good.getState()==1){
//            修改商品状态
//            。。。。
            serverResponse=ServerResponse.createBySuccess("商品锁定成功,请确认支付",good);
        }else{
            serverResponse=ServerResponse.createByError();
        }
        return serverResponse;
    }
}

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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

    @Override
    public ServerResponse findGoodByFilter(String filter) {
        ServerResponse serverResponse;
        List<Good> goodList=new ArrayList<Good>();
        List<Good> goods;
        if(isInteger(filter)){
            goods=goodDao.findAllByUserId(Integer.valueOf(filter));
            Good good=goodDao.findOne(Integer.valueOf(filter));
            goodList.addAll(goods);
            goodList.add(good);
        }else{
            goods=goodDao.findAllGoodName(filter);
            goodList.addAll(goods);
        }
        serverResponse=ServerResponse.createBySuccess(goodList);
        return serverResponse;
    }
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
    @Override
    public ServerResponse findAllGood() {
        ServerResponse serverResponse;
        List<Good> goods=goodDao.findAll();
        serverResponse=ServerResponse.createBySuccess(goods);
        return serverResponse;
    }

    @Override
    public ServerResponse findGoodByState(Integer state) {
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
            Good goodInfo = (Good)serverResponse.getData();
            if(goodInfo.getState()==state){
                if(state==2){
                    serverResponse=ServerResponse.createByErrorMessage("商品已进入锁定状态");
                }
                else{
                    serverResponse=ServerResponse.createByErrorMessage("商品状态未改变");
                }
            }
            else{
                int code= goodDao.changeGoodState(id,state);
                if(code==1){
                    serverResponse=ServerResponse.createBySuccess("商品状态修改成功",serverResponse.getData());
                }else{
                    serverResponse=ServerResponse.createByErrorMessage("商品状态修改失败");
                }
            }

        }else{
            serverResponse=ServerResponse.createByError();
        }
        return serverResponse;
    }

    @Override
    public ServerResponse changeGood(Good good) {
        ServerResponse serverResponse;
//        确认商品是否存在
        serverResponse=findGoodById(good.getGood_id());
        if(serverResponse.getStatus()==500){// 商品不存在
            return serverResponse;
        }else if(serverResponse.getStatus()==200) {// 商品存在， 修改商品
            int code= goodDao.changeGood(good);
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
    public ServerResponse addGood(Good good) {
        ServerResponse serverResponse;
        Good good_info=goodDao.addGood(good);
        if(good_info!=null) {
            serverResponse = ServerResponse.createBySuccess("商品添加成功", good_info);
        }else {
            serverResponse = ServerResponse.createByErrorMessage("商品添加失败");
        }
        return serverResponse;
    }

    @Override
    public ServerResponse findGoodByUserId(Integer user_id) {
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
        String filename = multipartFile.getOriginalFilename();
        Map dict = new HashMap();
        dict.put("name",filename);
        dict.put("url",path);
        serverResponse=ServerResponse.createBySuccess(dict);
        return serverResponse;
    }

    @Override
    public ServerResponse buyGood(Good good) {
        ServerResponse serverResponse;
        Good goodInfo =goodDao.findOne(good.getGood_id());
        System.out.println(goodInfo.toString());
        int num=goodInfo.getNum()-good.getNum();
        System.out.println(num);
        goodInfo.setNum(num);
        System.out.println(goodInfo.toString());
        goodInfo.setState(1);
        serverResponse= changeGood(goodInfo);
        return serverResponse;
    }

    @Override
    public ServerResponse deleteGood(Integer id) {
        goodDao.deleteGood(id);
        ServerResponse serverResponse=findGoodById(id);
        if(serverResponse.getStatus()==500){// 商品不存在
            serverResponse=ServerResponse.createBySuccessMessage("商品删除成功");
        }else if(serverResponse.getStatus()==200) {// 商品存在
            serverResponse=ServerResponse.createByErrorMessage("商品删除失败");
        }else{
            serverResponse=ServerResponse.createByError();
        }
        return serverResponse;
    }
}

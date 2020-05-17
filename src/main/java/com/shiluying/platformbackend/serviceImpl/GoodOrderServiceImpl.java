package com.shiluying.platformbackend.serviceImpl;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.dao.GoodOrderDao;
import com.shiluying.platformbackend.entity.GoodOrder;
import com.shiluying.platformbackend.service.GoodOrderService;
import com.shiluying.platformbackend.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GoodOrderServiceImpl implements GoodOrderService {

    @Autowired
    private GoodOrderDao goodOrderDao;
    @Override
    public GoodOrder findOne(int order_id){
        return goodOrderDao.findOne(order_id);
    }

    @Override
    public ServerResponse getGoodOrderById(int user_id) {
        ServerResponse serverResponse;
        List<GoodOrder> goodOrders=goodOrderDao.findGoodOrderByUserId(user_id);
        serverResponse=ServerResponse.createBySuccess(goodOrders);
        return serverResponse;
    }

    @Override
    public ServerResponse addOrder(int buyer_id, int seller_id, int good_id) {
        ServerResponse serverResponse;
//        确认当前商品状态为已发布
        GoodService goodService = new GoodServiceImpl();
        int good_state = goodService.findGoodStateById(good_id);
        if(good_state==-1){
            serverResponse = ServerResponse.createByErrorMessage("商品不存在");
        }else if(good_state==1){
//            锁定商品
            goodService.changeGoodState(good_id,2);
            GoodOrder goodOrder = new GoodOrder();
            goodOrder.setBuyer_id(buyer_id);
            goodOrder.setGood_id(good_id);
            goodOrder.setSeller_id(seller_id);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置时间格式
            goodOrder.setTime(df.format(new Date()));
            goodOrder.setState(0);//state:0 未付款
//            创建订单
            GoodOrder goodOrderInfo=goodOrderDao.addOrder(goodOrder);
            if(goodOrderInfo!=null) {
                serverResponse = ServerResponse.createBySuccess("订单创建成功", goodOrderInfo);
            }else {
//                取消锁定
                goodService.changeGoodState(good_id,1);
                serverResponse = ServerResponse.createByErrorMessage("订单创建失败");
            }
        }else{
            serverResponse = ServerResponse.createByError();
        }
        return serverResponse;
    }

    @Override
    public ServerResponse updateOrderStateById(int order_id, int state) {
        ServerResponse serverResponse;
//        确认订单是否存在
        serverResponse=getGoodOrderById(order_id);
        if(serverResponse.getStatus()==500){// 订单不存在
            return serverResponse;
        }else if(serverResponse.getStatus()==200) {// 订单存在， 修改订单状态
            int code= goodOrderDao.changeOrderState(order_id,state);
            if(code==1){
                serverResponse=ServerResponse.createBySuccess("订单状态修改成功",serverResponse.getData());
            }else{
                serverResponse=ServerResponse.createByErrorMessage("订单状态修改失败");
            }
        }else{
            serverResponse=ServerResponse.createByError();
        }
        return serverResponse;
    }

    @Override
    public ServerResponse cancelOrder(int order_id) {
        ServerResponse serverResponse;
        GoodOrder goodOrder= findOne(order_id);
        GoodService goodService = new GoodServiceImpl();
//        订单存在， 修改商品状态
        goodService.changeGoodState(goodOrder.getGood_id(),1);
        GoodOrder goodOrderInfo= findOne(order_id);
        goodOrderDao.cancelOrder(goodOrder);
        if(goodOrderInfo!=null){
            serverResponse=ServerResponse.createBySuccess("订单取消成功");
        }else{
            serverResponse=ServerResponse.createByErrorMessage("订单取消失败");
        }
        return serverResponse;
    }
}

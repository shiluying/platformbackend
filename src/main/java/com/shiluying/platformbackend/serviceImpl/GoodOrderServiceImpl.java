package com.shiluying.platformbackend.serviceImpl;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.entity.GoodOrder;
import com.shiluying.platformbackend.repository.GoodOrderRepository;
import com.shiluying.platformbackend.service.GoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GoodOrderServiceImpl implements GoodOrderService {
    @Autowired
    private GoodOrderRepository goodOrderRepository;

    @Override
    public GoodOrder findOne(int order_id){
        return goodOrderRepository.getOne(order_id);
    }

    @Override
    public ServerResponse getGoodOrderByUserId(int user_id) {
        ServerResponse serverResponse;
        List<GoodOrder> goodOrders=goodOrderRepository.findGoodOrderById(user_id);
        serverResponse=ServerResponse.createBySuccess(goodOrders);
        return serverResponse;
    }

    @Override
    public ServerResponse addOrder(GoodOrder goodOrder) {
        ServerResponse serverResponse;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置时间格式
        goodOrder.setTime(df.format(new Date()));
        goodOrder.setState(0);//state:0 未付款
//            创建订单
        GoodOrder goodOrderInfo=goodOrderRepository.save(goodOrder);
        if(goodOrderInfo!=null) {
            serverResponse = ServerResponse.createBySuccess("订单创建成功", goodOrderInfo);
        }else {
            serverResponse = ServerResponse.createByErrorMessage("订单创建失败");
        }
        return serverResponse;
    }

    @Override
    public ServerResponse updateOrderStateById(int order_id, int state) {
        ServerResponse serverResponse;
//        确认订单是否存在
        serverResponse=getGoodOrderByUserId(order_id);
        if(serverResponse.getStatus()==500){// 订单不存在
            return serverResponse;
        }else if(serverResponse.getStatus()==200) {// 订单存在， 修改订单状态
            int code= goodOrderRepository.updateStateById(order_id,state);
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
        goodOrderRepository.delete(goodOrder);
        if(goodOrder!=null){
            serverResponse=ServerResponse.createBySuccess("订单取消成功");
        }else{
            serverResponse=ServerResponse.createByErrorMessage("订单取消失败");
        }
        return serverResponse;
    }
}

package com.shiluying.platformbackend.controller;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.entity.GoodOrder;
import com.shiluying.platformbackend.service.GoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodOrderController {

    @Autowired
    private GoodOrderService goodOrderService;
//    根据user_id查询订单
    @RequestMapping(value = "/getGoodOrderByUserId",method = RequestMethod.GET)
    public ServerResponse getGoodOrderByUserId(@RequestParam("user_id") int user_id) {
        return goodOrderService.getGoodOrderByUserId(user_id);
    }
//    创建订单
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public ServerResponse addOrder(@RequestBody GoodOrder goodOrder) {
        return goodOrderService.addOrder(goodOrder);
    }
//    取消订单
    @RequestMapping(value = "/deleteOrder",method = RequestMethod.DELETE)
    public ServerResponse cancelOrder(@RequestParam("order_id") int order_id) {
        return goodOrderService.cancelOrder(order_id);
    }
//    更改订单状态
    @RequestMapping(value = "/changeOrderState",method = RequestMethod.PUT)
    public ServerResponse updateOrderStateById(@RequestBody GoodOrder goodOrder) {
        return goodOrderService.updateOrderStateById(goodOrder.getOrder_id(),goodOrder.getState());
    }
}

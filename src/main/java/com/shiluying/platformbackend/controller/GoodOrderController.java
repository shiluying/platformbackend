package com.shiluying.platformbackend.controller;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.service.GoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodOrderController {

    @Autowired
    private GoodOrderService goodOrderService;
//    查询订单
    @RequestMapping(value = "/getGoodOrderById",method = RequestMethod.GET)
    public ServerResponse getGoodOrderById(@RequestParam("user_id") int user_id) {
        return goodOrderService.getGoodOrderById(user_id);
    }
//    创建订单
    @RequestMapping(value = "/addOrder",method = RequestMethod.GET)
    public ServerResponse addOrder(@RequestParam("buyer_id") int buyer_id,
                                   @RequestParam("seller_id") int seller_id,
                                   @RequestParam("good_id") int good_id,
                                   @RequestParam("price") float price
                                   ) {
        return goodOrderService.addOrder(buyer_id,seller_id,good_id,price);
    }
//    取消订单
    @RequestMapping(value = "/cancelOrder",method = RequestMethod.GET)
    public ServerResponse cancelOrder(@RequestParam("order_id") int order_id) {
        return goodOrderService.cancelOrder(order_id);
    }
//    更改订单状态
    @RequestMapping(value = "/updateOrderStateById",method = RequestMethod.GET)
    public ServerResponse updateOrderStateById(@RequestParam("order_id") int order_id,
                                               @RequestParam("state") int state) {
        return goodOrderService.updateOrderStateById(order_id,state);
    }
//    确认订单
    @RequestMapping(value = "/confirmOrder",method = RequestMethod.GET)
    public ServerResponse confirmOrder(@RequestParam("order_id") int order_id,
                                               @RequestParam("state") int state,
                                               @RequestParam("place") String place,
                                               @RequestParam("date") String date) {
        return goodOrderService.confirmOrder(order_id,state,place,date);
    }
}

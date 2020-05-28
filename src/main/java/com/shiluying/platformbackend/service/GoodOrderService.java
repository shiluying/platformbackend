package com.shiluying.platformbackend.service;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.entity.GoodOrder;

public interface GoodOrderService {
    GoodOrder findOne(int order_id);

    ServerResponse getGoodOrderByUserId(int user_id);

    ServerResponse addOrder(int buyer_id, int seller_id, int good_id, float price, String date, String place);

    ServerResponse updateOrderStateById(int order_id, int state);

    ServerResponse cancelOrder(int order_id);
}

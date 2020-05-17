package com.shiluying.platformbackend.dao;


import com.shiluying.platformbackend.entity.GoodOrder;

import java.util.List;

public interface GoodOrderDao {
    List<GoodOrder> findGoodOrderByUserId(int user_id);

    GoodOrder addOrder(GoodOrder goodOrder);

    int changeOrderState(int order_id, int state);

    void cancelOrder(GoodOrder goodOrder);

    GoodOrder findOne(int order_id);
}

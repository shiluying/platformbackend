package com.shiluying.platformbackend.daoImpl;

import com.shiluying.platformbackend.dao.GoodOrderDao;
import com.shiluying.platformbackend.entity.GoodOrder;
import com.shiluying.platformbackend.repository.GoodOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodOrderDaoImpl implements GoodOrderDao {

    @Autowired
    private GoodOrderRepository goodOrderRepository;

    @Override
    public List<GoodOrder> findGoodOrderByUserId(int user_id) {
        return goodOrderRepository.findGoodOrderById(user_id);
    }

    @Override
    public GoodOrder addOrder(GoodOrder goodOrder) {
        return goodOrderRepository.save(goodOrder);
    }

    @Override
    public int changeOrderState(int order_id, int state) {
        return goodOrderRepository.updateStateById(order_id,state);
    }

    @Override
    public void cancelOrder(GoodOrder goodOrder) {
         goodOrderRepository.delete(goodOrder);
    }

    @Override
    public GoodOrder findOne(int order_id) {
        return goodOrderRepository.getOne(order_id);
    }
}

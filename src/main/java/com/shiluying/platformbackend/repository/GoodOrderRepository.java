package com.shiluying.platformbackend.repository;

import com.shiluying.platformbackend.entity.GoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface GoodOrderRepository extends JpaRepository<GoodOrder, Integer> {

    @Query(value = "select * from good_order where buyer_id= :user_id or seller_id= :user_id",nativeQuery = true)
    List<GoodOrder> findGoodOrderById(int user_id);

    @Transactional
    @Modifying
    @Query(value = "update good_order set state= :state where order_id= :order_id",nativeQuery = true)
    int updateStateById(@Param("order_id") Integer id, @Param("state") Integer state);
}

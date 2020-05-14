package com.shiluying.platformbackend.repository;

import com.shiluying.platformbackend.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface GoodRepository extends JpaRepository<Good, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update good set state= :state where good_id= :id",nativeQuery = true)
    int updateStateById(@Param("id") Integer id,@Param("state") Integer state);

    @Transactional
    @Modifying
    @Query(value = "update good set state= :state, good_describe=:good_describe, price=:price where good_id= :id",nativeQuery = true)
    int updateGood(Integer id, Integer state, String good_describe, float price);

    @Query(value = "select * from good where state= :state",nativeQuery = true)
    List<Good> findAllByState(@Param("state") Integer state);

    @Query(value = "select * from good where user_id= :user_id",nativeQuery = true)
    List<Good> findAllByUserId(@Param("user_id") Integer user_id);


}

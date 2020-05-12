package com.shiluying.platformbackend.repository;

import com.shiluying.platformbackend.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface GoodRepository extends JpaRepository<Good, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update good set state= :state where good_id= :id",nativeQuery = true)
    void updateStateById(@Param("id") Integer id,@Param("state") Integer state);
}

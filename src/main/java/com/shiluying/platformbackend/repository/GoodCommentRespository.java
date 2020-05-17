package com.shiluying.platformbackend.repository;

import com.shiluying.platformbackend.entity.GoodComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodCommentRespository extends JpaRepository<GoodComment, Integer> {

    @Query(value = "select * from good_comment where good_id= :good_id",nativeQuery = true)
    List<GoodComment> findCommentById(@Param("good_id") Integer good_id);
}

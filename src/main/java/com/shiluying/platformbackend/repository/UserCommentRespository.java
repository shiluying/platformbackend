package com.shiluying.platformbackend.repository;


import com.shiluying.platformbackend.entity.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserCommentRespository extends JpaRepository<UserComment, Integer> {
    @Query(value = "select * from user_comment where sender_id= :sender_id",nativeQuery = true)
    List<UserComment> findCommentById(@Param("sender_id") Integer user_id);
}

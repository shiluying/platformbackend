package com.shiluying.platformbackend.repository;

import com.shiluying.platformbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update user set type= :type where user_id= :id",nativeQuery = true)
    int updateTypeById(@Param("id") Integer id, @Param("type") Integer type);

    @Transactional
    @Modifying
    @Query(value = "update user set examine= :examine where user_id= :id",nativeQuery = true)
    int updateExamineById(@Param("id") Integer id,@Param("examine") Integer examine);

//    @Query(value = "select * from user where email= :email and pwd= :pwd",nativeQuery = true)
    List<User> findByEmailAndPwd(String email,String pwd);

}

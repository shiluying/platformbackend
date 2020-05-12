package com.shiluying.platformbackend.repository;

import com.shiluying.platformbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

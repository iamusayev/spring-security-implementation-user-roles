package com.example.homeworkspringsecurity.dao.repository;

import com.example.homeworkspringsecurity.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

}

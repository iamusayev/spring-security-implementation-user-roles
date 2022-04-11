package com.example.homeworkspringsecurity.dao.repository;

import com.example.homeworkspringsecurity.dao.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByName(String name);

}

package com.example.homeworkspringsecurity.service;

import com.example.homeworkspringsecurity.dao.entity.RoleEntity;
import com.example.homeworkspringsecurity.dao.entity.UserEntity;
import com.example.homeworkspringsecurity.dao.repository.UserRepository;
import com.example.homeworkspringsecurity.dao.repository.RoleRepository;
import com.example.homeworkspringsecurity.model.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void createUser(UserEntity entity) {        
        RoleEntity roleUser = roleRepository.findByName("USER");
        List<RoleEntity> userRoles = new ArrayList<>();
        userRoles.add(roleUser);
        
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        entity.setRoles(userRoles);
        userRepository.save(entity);
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(Long id) {
        var userEntity = userRepository.findById(id).orElseThrow();
        userEntity.setStatus(Status.REMOVED);
        userRepository.save(userEntity);
    }

}

package com.example.homeworkspringsecurity.controller;

import com.example.homeworkspringsecurity.dao.entity.UserEntity;
import com.example.homeworkspringsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserEntity entity) {
        userService.createUser(entity);
    }

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserEntity> getAll() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }


}

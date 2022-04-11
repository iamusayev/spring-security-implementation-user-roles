package com.example.homeworkspringsecurity.config;

import com.example.homeworkspringsecurity.dao.entity.UserEntity;
import com.example.homeworkspringsecurity.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserDetail implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        UserDetailDecorator userDetailsDecorator = new UserDetailDecorator(user);
        return userDetailsDecorator;
    }
}

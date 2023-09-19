package com.huoranger.service;

import com.huoranger.entity.User;
import com.huoranger.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public List<User> users() {
        return userRepository.findAll();
    }

}

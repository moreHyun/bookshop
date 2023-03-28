package com.greedy.bookshop.main.member.service;

import com.greedy.bookshop.main.member.dto.UserDTO;
import com.greedy.bookshop.main.member.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserDTO getUserById(String id) {
        return userMapper.getUserById(id);
    }
}
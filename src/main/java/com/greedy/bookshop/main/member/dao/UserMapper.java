package com.greedy.bookshop.main.member.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.greedy.bookshop.main.member.dto.UserDTO;

@Mapper
public interface UserMapper {
    UserDTO getUserById(@Param("id") String id);
}
package com.greedy.bookshop.main.member.dao;


import org.apache.ibatis.annotations.Mapper;

import com.greedy.bookshop.main.member.dto.MemberDTO;

@Mapper
public interface MemberMapper {

    MemberDTO findMemberById(String username);
    
    int insertMember(MemberDTO member); // 회원가입 insert
}


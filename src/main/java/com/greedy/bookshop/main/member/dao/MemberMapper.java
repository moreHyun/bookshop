package com.greedy.bookshop.main.member.dao;


import com.greedy.bookshop.main.member.dto.MemberDTO;

public interface MemberMapper {

    MemberDTO findMemberById(String username);
    
    int insertMember(MemberDTO member); // 회원가입 insert
}


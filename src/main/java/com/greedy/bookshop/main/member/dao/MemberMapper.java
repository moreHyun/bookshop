package com.greedy.bookshop.main.member.dao;


import com.greedy.bookshop.main.member.dto.MemberDTO;

public interface MemberMapper {

    MemberDTO findMemberById(String username);

}


package com.greedy.bookshop.member.dao;

import org.apache.ibatis.annotations.Mapper;
import com.greedy.bookshop.member.dto.MemberDTO;


@Mapper
public interface MemberMapper {

    MemberDTO findByMemberId(String memberId);

    String selectMemberById(String memberId);

    int insertMember(MemberDTO member);

    int insertMemberRole();

    int updateMember(MemberDTO member);

    int deleteMember(MemberDTO member);


}

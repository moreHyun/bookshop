package com.greedy.bookshop.admin.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.bookshop.admin.member.common.paging.SelectCriteria;
import com.greedy.bookshop.admin.member.model.dto.MemberDTO;


@Mapper
public interface MemberMapper {


	int selectTotalCount(Map<String, String> searchMap);

	List<MemberDTO> selectMemberList(SelectCriteria selectCriteria);

	MemberDTO selectMemberDetail(String id);

	void updateMember(MemberDTO member);

	

}

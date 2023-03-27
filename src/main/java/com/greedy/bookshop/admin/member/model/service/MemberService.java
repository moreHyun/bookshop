package com.greedy.bookshop.admin.member.model.service;

import java.util.Map;


import com.greedy.bookshop.admin.member.model.dto.MemberDTO;




public interface MemberService {

	Map<String, Object> selectMemberList(Map<String, String> searchMap, int page);

	MemberDTO selectMemberDetail(String id);

	void updateMember(MemberDTO member);
	

	


}

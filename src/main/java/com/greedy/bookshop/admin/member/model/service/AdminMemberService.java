package com.greedy.bookshop.admin.member.model.service;

import java.util.Map;


import com.greedy.bookshop.admin.member.model.dto.AdminMemberDTO;




public interface AdminMemberService {

	Map<String, Object> selectMemberList(Map<String, String> searchMap, int page);

	AdminMemberDTO selectMemberDetail(String id);

	void updateMember(AdminMemberDTO member);
	

	


}

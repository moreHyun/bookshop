package com.greedy.bookshop.admin.member.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.greedy.bookshop.admin.member.common.paging.Pagenation;
import com.greedy.bookshop.admin.member.common.paging.SelectCriteria;
import com.greedy.bookshop.admin.member.model.dao.AdminMemberMapper;
import com.greedy.bookshop.admin.member.model.dto.AdminMemberDTO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service("adminMemberService") //빈 네임 등록
@Transactional
/* @Transactional 어노테이션이 붙은 클래스 내부의 메소드는 모두 transaction 관리가 된다.
 * @Transactional 어노테이션은 메소드 레벨로 분리해서 작성할 수도 있다.
 * 메소드 동작시 Exception이 발생하면 전체 트랜잭션을 롤백하고 정상 수행 시에는 commit하는 동작이 일어난다. */
public class AdminMemberServiceImpl implements AdminMemberService {
	
	private final AdminMemberMapper adminMemberMapper; //의존성 주입 코드
	
	@Autowired
	public AdminMemberServiceImpl(AdminMemberMapper adminMemberMapper) {
		this.adminMemberMapper = adminMemberMapper;
	} //의존성 주입~~


	@Override
	public Map<String, Object> selectMemberList(Map<String, String> searchMap, int page) {
		
		//1. 전체 회원 수 확인 (검색어가 있는 경우 포함) -> 페이징 처리 계산을 위해서
		int totalCount = adminMemberMapper.selectTotalCount(searchMap);
		log.info("[MemberService] totalCount : {}", totalCount);
		
		/*한 페이지에 보여줄 회원의 수*/
		int limit = 5;
		
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 5;
		
		/*2. 페이징 처리와 연관된 값을 계산하여 SelectCriteria 타입의 객체에 담는다.*/
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[MemberService] selectCriteria : {}", selectCriteria);
		
		/*3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다.*/
		List<AdminMemberDTO> memberList = adminMemberMapper.selectMemberList(selectCriteria);
		log.info("[MemberService] memberList : {}", memberList);

		Map<String, Object> memberListAndPaging = new HashMap<>();
		memberListAndPaging.put("paging", selectCriteria);
		memberListAndPaging.put("memberList", memberList);
		
		return memberListAndPaging;
		
	}

	

	@Override
	public AdminMemberDTO selectMemberDetail(String id) {
		
		return adminMemberMapper.selectMemberDetail(id);
	}

	 @Override
	    public void updateMember(AdminMemberDTO member) {
		 adminMemberMapper.updateMember(member);
	    }

	}

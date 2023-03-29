package com.greedy.bookshop.admin.paydeli.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.bookshop.admin.member.common.paging.Pagenation;
import com.greedy.bookshop.admin.member.common.paging.SelectCriteria;
import com.greedy.bookshop.admin.member.model.dto.MemberDTO;
import com.greedy.bookshop.admin.paydeli.model.dao.AdminOrderMapper;
import com.greedy.bookshop.admin.paydeli.model.dto.AdminOrderDTO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service("adminOrderService") //빈 네임 등록
@Transactional
/* @Transactional 어노테이션이 붙은 클래스 내부의 메소드는 모두 transaction 관리가 된다.
 * @Transactional 어노테이션은 메소드 레벨로 분리해서 작성할 수도 있다.
 * 메소드 동작시 Exception이 발생하면 전체 트랜잭션을 롤백하고 정상 수행 시에는 commit하는 동작이 일어난다. */
public class AdminOrderServiceImpl implements AdminOrderService {
	
	private final AdminOrderMapper adminOrderMapper; //의존성 주입 코드
	
	@Autowired
	public AdminOrderServiceImpl(AdminOrderMapper adminOrderMapper) {
		this.adminOrderMapper = adminOrderMapper;
	} //의존성 주입~~



	@Override
	public Map<String, Object> selectOrderList(Map<String, String> searchMap, int page) {
		//1. 전체 회원 수 확인 (검색어가 있는 경우 포함) -> 페이징 처리 계산을 위해서
		int totalCount = adminOrderMapper.selectOrderTotalCount(searchMap);
		log.info("[AdminOrderService] totalCount : {}", totalCount);
		
		/*한 페이지에 보여줄 회원의 수*/
		int limit = 5;
		
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 5;
		
		/*2. 페이징 처리와 연관된 값을 계산하여 SelectCriteria 타입의 객체에 담는다.*/
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[MemberService] selectCriteria : {}", selectCriteria);
		
		/*3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다.*/
		List<AdminOrderDTO> orderList = adminOrderMapper.selectOrderList(selectCriteria);
		log.info("[AdminOrderService] orderList : {}", orderList);

		Map<String, Object> orderListAndPaging = new HashMap<>();
		orderListAndPaging.put("paging", selectCriteria);
		orderListAndPaging.put("orderList", orderList);
		
		return orderListAndPaging;
	}



	@Override
	public AdminOrderDTO selectOrderDetail(int orderCode) {
		
		return adminOrderMapper.selectOrderDetail(orderCode);
	}


	
	
	}



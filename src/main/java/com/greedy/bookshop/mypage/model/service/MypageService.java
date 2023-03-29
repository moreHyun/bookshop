package com.greedy.bookshop.mypage.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.bookshop.center.common.Pagenation;
import com.greedy.bookshop.center.common.SelectCriteria;
import com.greedy.bookshop.mypage.dao.MypageMapper;
import com.greedy.bookshop.mypage.dto.OrderDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class MypageService {
	
	private final MypageMapper mypageMapper;
	
	public MypageService(MypageMapper mypageMapper) {
		this.mypageMapper = mypageMapper;
	}
	
	/* 주문테이블에서 주문상태에 따른 행의 갯수 조회 */
	public Map<String, Integer> selectOrderCounts() {
		
		/* 결제완료 행의 갯수 */
		int payCount = mypageMapper.selectPayCount();
		
		/* 배송준비 행의 갯수 */
		int readyCount = mypageMapper.selectReadyCount();
		
		/* 배송완료 행의 갯수 */
		int completeCount = mypageMapper.selectCompleteCount();
		
		Map<String, Integer> counts = new HashMap<>();
		counts.put("pay", payCount);
		counts.put("ready", readyCount);
		counts.put("complete", completeCount);
		
		return counts;
		
		
	}

	/* 페이징 바 */

	public Map<String, Object> selectOrderList(Map<String, String> searchMap, int page) {

		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = mypageMapper.selectOrderCount(searchMap); 
		log.info("[MypageService] totalCount : {}", totalCount);
		
		/* 한 페이지에 보여줄 게시물의 수 */
		int limit = 5;
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[MypageService] selectCriteria : {}", selectCriteria);
		
		/* 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다.*/
		List<OrderDTO> orderList = mypageMapper.selectOrderList(selectCriteria); 
		log.info("[MypageService] orderList : {}", orderList);
		
		Map<String, Object> noticeListAndPaging = new HashMap<>();
		noticeListAndPaging.put("paging", selectCriteria);
		noticeListAndPaging.put("order", orderList);
		
		return noticeListAndPaging;
	}

	public Map<String, Integer> selectApprovedCounts() {
		
		/* 환불완료 행의 갯수 */
		int YesCount = mypageMapper.selectYesCount();
		
		/* 환불안된 행의 갯수 */
		int NoCount = mypageMapper.selectNoCount();
		
		Map<String, Integer> counts = new HashMap<>();
		counts.put("Yes", YesCount);
		counts.put("No", NoCount);
		
		return counts;
	}
	
	public Map<String, Object> selectRefundList(Map<String, String> searchMap, int page) {
		
		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = mypageMapper.selectRefundCount(searchMap); 
		log.info("[MypageService] totalCount : {}", totalCount);
		
		int limit = 5;
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[MypageService] selectCriteria : {}", selectCriteria);
		
		/* 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다.*/
		List<OrderDTO> refundList = mypageMapper.selectRefundList(selectCriteria); 
		log.info("[MypageService] refundList : {}", refundList);
		
		Map<String, Object> noticeListAndPaging = new HashMap<>();
		noticeListAndPaging.put("paging", selectCriteria);
		noticeListAndPaging.put("refund", refundList);
		
		return noticeListAndPaging;
	}

	
	

}

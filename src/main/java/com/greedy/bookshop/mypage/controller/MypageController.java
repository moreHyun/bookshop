package com.greedy.bookshop.mypage.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.bookshop.member.dto.MemberDTO;
import com.greedy.bookshop.mypage.model.service.MypageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	private final MypageService mypageService;
	
	public MypageController(MypageService mypageService) {
		this.mypageService = mypageService;
	}
	
	
	@GetMapping("/orderhistory")
	public String selectMainView(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue, Model model) {
		
		/* 페이징 바 */
		log.info("[MypageController] page : {}", page);
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		log.info("[MypageController] searchMap : {}", searchMap);
		
		 Map<String, Object> noticeListAndPaging = mypageService.selectOrderList(searchMap, page);
		 model.addAttribute("paging", noticeListAndPaging.get("paging"));
		 model.addAttribute("orderLists", noticeListAndPaging.get("order"));
		 
		 log.info("[MypageController] page : {}", noticeListAndPaging.get("paging"));
		 log.info("[MypageController] order : {}", noticeListAndPaging.get("order"));
		
		/* 주문/배송조회 상단 */
		Map<String, Integer> orderList = mypageService.selectOrderCounts();
		
		log.info("[MypageController] : {}", orderList);
		
		model.addAttribute("orderList", orderList);
		
				
		
		return "mypage/orderhistory";
	}
	
	@GetMapping("/refundhistory")
	public String selcectRefund(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue, Model model) {
		
		/* 페이징 바*/
		log.info("[MypageController] page : {}", page);
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		log.info("[MypageController] searchMap : {}", searchMap);
		
		Map<String, Object> noticeListAndPaging = mypageService.selectRefundList(searchMap, page);
		model.addAttribute("paging", noticeListAndPaging.get("paging"));
		model.addAttribute("orderLists", noticeListAndPaging.get("refund"));
		
		/* 환불내역 상단 */
		Map<String, Integer> refundList = mypageService.selectApprovedCounts();
		
		log.info("[MypageController] : {}", refundList);
		
		model.addAttribute("refundList", refundList);
		
		
		return "mypage/refundhistory";
	}
	

	@GetMapping("/userinfoupdate")
	public String userInfoUpdate() {
		
		return "mypage/editinfo";
	}
	
	@GetMapping("/memdelete")
	public String memberDelte() {
		
		return "mypage/memdelete";
	}
	
	@GetMapping("/addressregist")
	public String addressRegist() {
		
		return "mypage/addressregist";
	}
	

}

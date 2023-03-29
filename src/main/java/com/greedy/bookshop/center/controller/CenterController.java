package com.greedy.bookshop.center.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.bookshop.center.model.dto.NoticeDTO;
import com.greedy.bookshop.center.model.service.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/center")
public class CenterController {
	
	private final NoticeService noticeService;
	
	public CenterController(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@GetMapping("/notice/list")
	public String noticeList(@RequestParam(defaultValue="1") int page,
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {
		
		log.info("[CenterController] page : {}", page);
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		log.info("[CenterController] searchMap : {}", searchMap);
		
		 Map<String, Object> noticeListAndPaging = noticeService.selectNoticeList(searchMap, page);
		 model.addAttribute("paging", noticeListAndPaging.get("paging"));
		 model.addAttribute("noticeList", noticeListAndPaging.get("notice"));
		 
		 log.info("[CenterController] page : {}", noticeListAndPaging.get("paging"));
		 log.info("[CenterController] notice : {}", noticeListAndPaging.get("notice"));
		 
		return "center/noticeList";  
	}
	
	@GetMapping("/notice/detail")
	public String selectNoticeDetail(@RequestParam int no, Model model) {
		
		NoticeDTO NoticeDetail = NoticeService.selectNoticeDetail(no);
		log.info("[CenterController] NOticeDetail : {}", NoticeDetail);
		
		model.addAttribute("noticeDetail", NoticeDetail);
		
		return "center/NoticeDetail";
	}
	

}

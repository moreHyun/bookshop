package com.greedy.bookshop.admin.paydeli.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greedy.bookshop.admin.paydeli.model.dto.AdminOrderDTO;
import com.greedy.bookshop.admin.paydeli.model.service.AdminOrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/order")
public class AdminOrderController {
	
	private AdminOrderService adminOrderService;


	@Autowired
	public AdminOrderController(AdminOrderService adminOrderService) {

		this.adminOrderService = adminOrderService;
		
	}
	
	
	@GetMapping("/list")
	public String orderList(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {
		
		log.info("[AdminOrderController] page : {}", page);
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		log.info("[AdminOrderController] searchMap : {}", searchMap);
		
		Map<String, Object> orderListAndPaging = adminOrderService.selectOrderList(searchMap, page);
		model.addAttribute("paging", orderListAndPaging.get("paging"));
		model.addAttribute("orderList", orderListAndPaging.get("orderList"));
		
		return "admin/paydeli/list";
	}
	
	@GetMapping("/detail")
	public String selectOrderDetail(@RequestParam int orderCode, Model model) {
		
		AdminOrderDTO orderDetail = adminOrderService.selectOrderDetail(orderCode);
		log.info("[MemberController] orderDetail : {}", orderDetail);
		
		model.addAttribute("order", orderDetail);
		
		return "admin/paydeli/detail";
	}
	 
	  
}

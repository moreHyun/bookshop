package com.greedy.bookshop.admin.paydeli.model.service;

import java.util.Map;

import com.greedy.bookshop.admin.paydeli.model.dto.AdminOrderDTO;



public interface AdminOrderService {
	
	Map<String, Object> selectOrderList(Map<String, String> searchMap, int page);

	AdminOrderDTO selectOrderDetail(int orderCode);

}

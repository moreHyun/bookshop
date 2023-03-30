package com.greedy.bookshop.admin.paydeli.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.bookshop.admin.member.common.paging.SelectCriteria;
import com.greedy.bookshop.admin.paydeli.model.dto.AdminDeliveryDTO;
import com.greedy.bookshop.admin.paydeli.model.dto.AdminOrderDTO;


@Mapper
public interface AdminOrderMapper {


	int selectOrderTotalCount(Map<String, String> searchMap);

	List<AdminOrderDTO> selectOrderList(SelectCriteria selectCriteria);

	AdminOrderDTO selectOrderDetail(int orderCode);
	
	void updateDelivery(AdminDeliveryDTO delivery);

}
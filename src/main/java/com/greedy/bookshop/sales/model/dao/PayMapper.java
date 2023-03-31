package com.greedy.bookshop.sales.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.bookshop.sales.model.dto.PayDTO;

@Mapper
public interface PayMapper 
{

	List<PayDTO> getCartItem(long bookCode);
	
}

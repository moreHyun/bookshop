package com.greedy.bookshop.sales.service;

import com.greedy.bookshop.sales.model.dao.PayMapper;
import com.greedy.bookshop.sales.model.dto.CartDTO;
import com.greedy.bookshop.sales.model.dto.PayDTO;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PayService
{
	private final PayMapper mapper;

    public PayService(PayMapper mapper)
    {
        this.mapper = mapper;
    }

 

	public List<PayDTO> getCartitem(long bookCode) 
	{
		List<PayDTO> l = mapper.getCartItem(bookCode);
		for(PayDTO p : l)
			log.info("p : " + p);
		
		return l;
	}

}

package com.greedy.bookshop.admin.product.model.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.bookshop.admin.product.model.dao.AdminProductMapper;
import com.greedy.bookshop.admin.product.model.dto.BookDTO;
import com.greedy.bookshop.admin.product.model.dto.BookSearchCriteria;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminProductServiceImpl implements AdminProductService{
	
	@Autowired
	private AdminProductMapper adminProductMapper;	
	
	/* 상품 등록 */
	@Override
	public Map<String, Object> bookEnroll(BookDTO book) {
		log.info("(service)bookEnroll........");
		
		adminProductMapper.bookEnroll(book);
		
		return null;
	}
	
    // 상품 조회 페이지
    @Override
    public List<BookDTO> getBookList(BookSearchCriteria bookSearchCriteria) {
    	log.info("(service)getBookList........");
    	
        return adminProductMapper.getBookList(bookSearchCriteria);
    }
    
}


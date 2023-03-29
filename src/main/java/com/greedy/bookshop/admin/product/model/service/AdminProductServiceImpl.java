package com.greedy.bookshop.admin.product.model.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.bookshop.admin.product.model.dao.AdminProductMapper;
import com.greedy.bookshop.admin.product.model.dto.BookDTO;
import com.greedy.bookshop.admin.product.model.dto.BookSearchDTO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
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
    public List<BookSearchDTO> getBookList(Integer bookCode, String bookName, String bookAuthor, Integer categoryCode,
			String salesStatus) {
    	log.info("(service)getBookList........");
    	
        return adminProductMapper.getBookList(categoryCode, salesStatus, salesStatus, categoryCode, salesStatus);
    }
    
    // 상품 수정 기능
    @Override
    public void updateBook(BookSearchDTO book) {
    	log.info("(service)updateBook........");
    	
    	adminProductMapper.updateBook(book);
    }
}


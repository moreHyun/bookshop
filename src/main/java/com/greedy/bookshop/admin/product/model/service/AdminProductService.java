package com.greedy.bookshop.admin.product.model.service;

import java.util.List;
import java.util.Map;

import com.greedy.bookshop.admin.product.model.dto.BookDTO;
import com.greedy.bookshop.admin.product.model.dto.BookSearchCriteria;

public interface AdminProductService {
	
	/* 상품 등록 */
	public Map<String, Object> bookEnroll(BookDTO book);

	public List<BookDTO> getBookList(BookSearchCriteria bookSearchCriteria);






}

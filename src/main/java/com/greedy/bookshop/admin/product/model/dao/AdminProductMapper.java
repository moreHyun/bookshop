package com.greedy.bookshop.admin.product.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.bookshop.admin.product.model.dto.BookDTO;
import com.greedy.bookshop.admin.product.model.dto.BookSearchCriteria;

@Mapper
public interface AdminProductMapper {
	
	/* 상품 등록 */
	public void bookEnroll(BookDTO book);
	
	public List<BookDTO> getBookList(BookSearchCriteria booksearchCriteria);

}

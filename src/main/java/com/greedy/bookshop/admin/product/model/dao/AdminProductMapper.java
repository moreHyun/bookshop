package com.greedy.bookshop.admin.product.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.bookshop.admin.product.model.dto.BookDTO;
import com.greedy.bookshop.admin.product.model.dto.BookSearchDTO;

@Mapper
public interface AdminProductMapper {
	
	/* 상품 등록 */
	public void bookEnroll(BookDTO book);
	
	public List<BookSearchDTO> getBookList(Integer bookCode, String bookName, String bookAuthor, Integer categoryCode,
			String salesStatus);

	public void updateBook(BookSearchDTO book);
	
}

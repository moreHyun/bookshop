package com.greedy.bookshop.admin.product.model.dto;

import lombok.Data;

@Data
public class BookSearchDTO {
	
//	도서 코드
	private Integer bookCode;
//	도서명
	private String bookName;
//	저자
	private String bookAuthor;
//	카테고리 코드
	private Integer categoryCode;
//	판매여부
	private String salesStatus;

}

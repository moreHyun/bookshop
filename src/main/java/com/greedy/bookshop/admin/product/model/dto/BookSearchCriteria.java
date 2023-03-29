package com.greedy.bookshop.admin.product.model.dto;

import lombok.Data;

@Data
public class BookSearchCriteria {
	
	private Integer bookCode;
	private String bookName;
	private String bookAuthor;
	private Integer subCategory;

}

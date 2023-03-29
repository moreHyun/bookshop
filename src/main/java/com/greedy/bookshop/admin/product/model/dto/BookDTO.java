package com.greedy.bookshop.admin.product.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BookDTO {
	
//	도서 코드
	private int bookCode;
//	도서명
	@NotBlank(message = "상품명은 필수 입력 값입니다.")
	private String bookName;
//	도서가격
	@NotNull(message = "가격은 필수 입력 값입니다.")
	private int bookPrice;
//	저자
	@NotNull(message = "작가명은 필수 입력 값입니다.")
	private String bookAuthor;
//	출판사
	private String bookPublisher;
//	카테고리 코드
	private int categoryCode;
//	재고량
	private int bookInventory;
//	판매여부
	private String salesStatus;
//	조회수
	private int bookHit;
//	ISBN
	@NotNull(message = "ISBN-13은 필수 입력 값입니다.")
	private String bookIsbn;
//	번역가
	private String bookTranslator;
//	책소개
	private String bookIntroduction;
//	할인률
	private int bookDiscount;
//	최종가격
	private int bookTotalPrice;
}

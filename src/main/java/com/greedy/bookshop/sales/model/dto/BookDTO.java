package com.greedy.bookshop.sales.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDTO
{
    private long bookCode; // 도서코드
    private String bookName; // 도서명
    private long bookPrice; // 도서가격
    private String bookAuthor; // 저자
    private String bookPublisher; // 출판사
    private long categoryCode; // 카테고리 코드
    private long bookInventory; // 재고량
    private String SalesStatus; // 판매여부
    private long bookHit; // 조회수
    private String bookISBN; // isbm
    private String bookTranslator; // 번역가
    private String bookInteoduction; // 책 소개
    private long bookDiscount;
    private long bookTotalPrice;


}

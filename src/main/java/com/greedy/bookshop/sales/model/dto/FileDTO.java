package com.greedy.bookshop.sales.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileDTO
{
    private long fileCode; // 파일코드 not null
    private String fileMainPath; // 파일 대표이미지 경로 not null
    private String fileType; // 파일타입
    private String fileName; // 파일 원본이름
    private long fileCategoryCode; // 파일 카테고리 별 코드 공지사항 : 1 | faq : 2 | 1:1 질문 : 3 | 도서 : 4
    private long noticeCode; // 공지사항 코드
    private long faqCode; // 자주묻는 질문 코드
    private long askCode; // 1:1 질문 코드
    private long bookCode; // 도서 코드

















}

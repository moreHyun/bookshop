package com.greedy.bookshop.center.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeDTO {

	private int noticeCode;
	private String noticeTitle;
	private String noticeContent;
	private String userName;
	private int noticeUserCode;
	private Date noticeDateCreate;
	private Date noticeRevisionDate;
	private int noticeHit;
	private String noticeStatus;
}



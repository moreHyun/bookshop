package com.greedy.bookshop.admin.paydeli.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class AdminDeliveryDTO {

	private int deliveryCode;  			//배송코드
	private String deliveryStatus;		//배송상태 
	private Date deliveryDate;			//배송일자
	private int orderCode;				//주문번호
	private int invoiceNumber;			//송장번호
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date purchaseDate;			//구매확정일
	

}



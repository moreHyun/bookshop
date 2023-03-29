package com.greedy.bookshop.admin.paydeli.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AdminDeliveryDTO {

	private int deliveryCode;  			//배송코드
	private String deliveryStatus;		//배송상태 
	private Date deliveryDate;			//배송일자
	private int orderCode;				//주문번호
	private int invoiceNumber;			//송장번호
	private Date purchaseDate;			//구매확정일
	

}



package com.greedy.bookshop.admin.paydeli.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public final class AdminOrderDTO {

	private int orderCode;
	private int totalAmount;
	private int deliveryPrice;
	private Date orderDate;
	private String orderStatus;
	private String orderRecipient;
	private int orderRecipientphone;
	private String destinationNickname;
	private int postalCode;
	private String address;
	private String detailedAddress;
	private String orderMemo;
	private int userCode;
	
	private OrderMemberDTO id;
	
	private AdminDeliveryDTO deliveryCode;
	private AdminDeliveryDTO deliveryStatus;
	private AdminDeliveryDTO invoiceNumber;
	private AdminDeliveryDTO purchaseDate;
	
	
}
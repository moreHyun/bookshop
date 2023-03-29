package com.greedy.bookshop.mypage.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDTO {
	
	private int orderCode;
	private int orderTotalAmount;
	private int deliveryPrice;
	private Date orderDate;
	private String orderStatus;
	private String orderRecipient;
	private String orderRecipientPhone;
	private String orderDestinationNickname;
	private String orderPostalCode;
	private String orderAddress;
	private String orderDetailedAddress;
	private String orderMeno;
	private int userCode;
	private String bookName;
	private int productQuantity;
	private int price;
	private Date refundDate;
	private String refundStatus;
	

}

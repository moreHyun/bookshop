package com.greedy.bookshop.admin.member.model.dto;



import lombok.Data;

/* TBL_USER_DELIVERY */
	@Data
	public class MemberDeliveryDTO {
		
		private int code;					//배송코드
		private String recipient;			//수령인이름
		private int phone;					//수령인연락처
		private String nickname;			//수령처별칭
		private String postalCode;			//우편번호
		private String detailedAddress;		//상세주소
		private String address;				//주소
		private String meno;				//배송메모
		private int userCode;				//회원코드
		
}
	


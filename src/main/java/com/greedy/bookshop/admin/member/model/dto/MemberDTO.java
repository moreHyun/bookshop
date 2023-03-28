package com.greedy.bookshop.admin.member.model.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

/* TBL_USER */
	@Data
	public class MemberDTO {
		
		private int code;								//회원번호
		private String id;								//회원아이디
		private String pwd;								//회원비밀번호
		private String name;							//회원이름
		private String no;								//회원주민번호
		private String phone;							//회원연락처
		private Date createUserDate;					//계정생성일
		private Date deleteUserDate;					//계정삭제일
		private String status;							//계정탈퇴여부

		private int gradecode;							//회원등급코드
		private int rolecode;							//회원권한코드
		private List<MemberDeliveryDTO> memberDeliveryList; 
		
		
	
	
}
	


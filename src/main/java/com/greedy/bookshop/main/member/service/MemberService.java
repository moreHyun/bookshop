package com.greedy.bookshop.main.member.service;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.greedy.bookshop.main.member.dao.MemberMapper;
import com.greedy.bookshop.main.member.dto.MemberDTO;

public class MemberService {
	
	private final MemberMapper memberMapper;
	private final PasswordEncoder passwordEncoder;
	
	public MemberService(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
		this.memberMapper = memberMapper;
		this.passwordEncoder = passwordEncoder;
	}
		
		public MemberDTO register(MemberDTO memberDTO) {
	        if (memberMapper.findMemberById(memberDTO.getId()) != null) {
	            throw new RuntimeException("이미 사용중인 이메일 입니다.");
	        }
	
	        memberDTO.setPwd(passwordEncoder.encode(memberDTO.getPwd()));
	        int result = memberMapper.insertMember(memberDTO);
	
	        if (result == 1) {
	            return memberDTO;
	        } else {
	            throw new RuntimeException("회원 가입에 실패하셨습니다. 다시 시도해 보세요.");
	        }
	    }
}

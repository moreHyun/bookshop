package com.greedy.bookshop.main.member.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.greedy.bookshop.main.member.dao.MemberMapper;
import com.greedy.bookshop.main.member.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("unused")
@Slf4j
@Service
@ComponentScan(basePackages = {"com.greedy.bookshop.main.member.dao"})
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

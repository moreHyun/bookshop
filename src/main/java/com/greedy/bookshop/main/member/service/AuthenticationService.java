package com.greedy.bookshop.main.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import com.greedy.bookshop.main.member.dao.MemberMapper;
import com.greedy.bookshop.main.member.dto.MemberDTO;
import com.greedy.bookshop.main.member.dto.CustomUser;
import com.greedy.bookshop.main.member.dto.MemberRoleDTO;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("unused")
@Slf4j
@Service
@ComponentScan(basePackages = {"com.greedy.bookshop.main.member.dao"})
public class AuthenticationService implements UserDetailsService {


    private final MemberMapper memberMapper;
//    private final PasswordEncoder passwordEncoder;
    
    public AuthenticationService(MemberMapper memberMapper/*, PasswordEncoder passwordEncoder*/) {
        this.memberMapper = memberMapper;
//		this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("username : " + username);

        log.error("username : {}", username);
        log.warn("username : {}", username);
        log.info("username : {}", username);
        log.debug("username : {}", username);
        log.trace("username : {}", username);

        /* 사용자 정의 타입으로 유저 조회 */
        MemberDTO member = memberMapper.findMemberById(username);

        log.info("member : {}", member);

        /* 조회 된 값이 없을 시 처리 (아이디가 데이터베이스에 존재하지 않음) */
        if(member == null) throw new UsernameNotFoundException("username not found");

        /* 권한 리스트 만들기 */
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(MemberRoleDTO role : member.getMemberRoleList()) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority().getName()));
        }

        //return new User(member.getId(), member.getPwd(), authorities);

        /* User 객체에 담기지 않는 추가 정보를 User를 extends 한 CustomUser에 담아서 리턴한다. */

        return new CustomUser(member, authorities);
    }

	public MemberDTO register(MemberDTO memberDTO) {
		return null;
	}


    








}
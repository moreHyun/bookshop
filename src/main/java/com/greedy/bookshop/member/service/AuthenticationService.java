package com.greedy.bookshop.member.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greedy.bookshop.member.dao.MemberMapper;
import com.greedy.bookshop.member.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthenticationService implements UserDetailsService {

    private final MemberMapper mapper;

    public AuthenticationService(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

   
        log.info("[AuthenticationService] memberId : {}", username);

        MemberDTO member = mapper.findByMemberId(username);

        log.info("[AuthenticationService] member : {}", member);

        if(member == null){
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다");
        }

        return member;
    }

}


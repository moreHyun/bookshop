package com.greedy.bookshop.main.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greedy.bookshop.main.member.dto.CustomUser;
import com.greedy.bookshop.main.member.dto.MemberDTO;
import com.greedy.bookshop.main.member.service.AuthenticationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/login")
    public void loginForm() {}

    @GetMapping("/mypage")
    public void mypage(@AuthenticationPrincipal CustomUser user) {

        log.info("로그인 유저 정보 : {}", user);
    }
    
    private final AuthenticationService authenticationService;

    public MemberController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody MemberDTO memberDTO) {
        try {
            MemberDTO createdMember = authenticationService.register(memberDTO);
            return ResponseEntity.ok(createdMember);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}




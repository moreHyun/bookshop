package com.greedy.bookshop.main.member.service;

import org.springframework.security.core.Authentication;

public interface AuthenticationService {
    Authentication authenticate(Authentication authentication);
}
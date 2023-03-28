package com.greedy.bookshop.main.config;

import com.greedy.bookshop.main.member.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private AuthenticationService authenticationService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager() {
		return authentication -> authenticationService.authenticate(authentication);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authenticationProvider((AuthenticationProvider) authenticationService)
				.authorizeRequests()
				.antMatchers("/login", "/css/**", "/js/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.successForwardUrl("/")
				.permitAll()
				.and()
				.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutSuccessUrl("/login")
				.permitAll();
		return http.build();
	}
}

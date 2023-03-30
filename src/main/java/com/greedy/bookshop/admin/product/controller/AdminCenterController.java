package com.greedy.bookshop.admin.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/center")
public class AdminCenterController {
	
	/* 공지사항 */
	@GetMapping("/notice")
	public String centerNoticePage() {
		return "admin/center/notice";
	}
	
	@GetMapping("/notice/regist")
	public String centerNoticeRegistPage() {
		return "admin/center/noticeRegist";
	}
	
	@GetMapping("/notice/select")
	public String centerNoticeSelectPage() {
		return "admin/center/noticeSelect";
	}
	
	/* 자주 묻는 질문 */
	@GetMapping("/faq")
	public String centerFaqPage() {
		return "admin/center/faq";
	}
	
	@GetMapping("/faq/regist")
	public String centerFaqRegistPage() {
		return "admin/center/faqRegist";
	}

}

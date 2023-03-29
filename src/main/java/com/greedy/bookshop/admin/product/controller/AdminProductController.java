package com.greedy.bookshop.admin.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.bookshop.admin.product.model.dto.BookDTO;
import com.greedy.bookshop.admin.product.model.dto.BookSearchCriteria;
import com.greedy.bookshop.admin.product.model.service.AdminProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping
public class AdminProductController {
	
	@Autowired
	private AdminProductService adminProductService;
	
	@GetMapping("/admin/product/regist")
	public String productRegistPage() {
		
		return "admin/product/productRegist";
	}
	
	/* 상품 등록 */
	@PostMapping("/admin/product/regist")
	public String productRegist(BookDTO book, RedirectAttributes rttr, Model model) {
	    log.info("productRegistPOST...... : {}", book);

	    Map<String, Object> arr = adminProductService.bookEnroll(book);
	    model.addAttribute("srr", arr);
	    
	    rttr.addFlashAttribute("regist_result", book.getBookName());
	    
	    return "redirect:/admin/product/productRegist";
	}
	
	/* 상품 조회 및 수정 */
	
	// 상품 조회 페이지
	@GetMapping("/admin/product/list")
	public String productSelectPage(BookSearchCriteria booksearchCriteria, Model model) {
		
		
		log.info("productSelectPage searchCriteria GetMapping : {}", booksearchCriteria);
		List<BookDTO> bookSearchList = adminProductService.getBookList(booksearchCriteria);
		
		log.info("{}", bookSearchList);
		
		model.addAttribute("bookSearchList", bookSearchList);
		
	    // 요청 파라미터를 사용하는 메서드
	    return "admin/product/productSelectUpdate";
	}
	
}
	
	

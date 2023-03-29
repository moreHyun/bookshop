package com.greedy.bookshop.admin.member.controller;


import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import com.greedy.bookshop.admin.member.model.dto.AdminMemberDTO;
import com.greedy.bookshop.admin.member.model.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class AdminMemberController {
	
	private MemberService memberService;


	@Autowired
	public AdminMemberController(MemberService memberService) {

		this.memberService = memberService;
		
	}
	
	@GetMapping("/list")
	public String memberList(@RequestParam(defaultValue="1") int page, 
			@RequestParam(required=false) String searchCondition, 
			@RequestParam(required=false) String searchValue,
			Model model) {
		
		log.info("[AdminMemberController] page : {}", page);
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		log.info("[AdminMemberController] searchMap : {}", searchMap);
		
		Map<String, Object> memberListAndPaging = memberService.selectMemberList(searchMap, page);
		model.addAttribute("paging", memberListAndPaging.get("paging"));
		model.addAttribute("memberList", memberListAndPaging.get("memberList"));
		
		return "admin/member/list";
	}
	
	@GetMapping("/detail")
	public String selectMemberDetail(@RequestParam String id, Model model) {
		
		AdminMemberDTO memberDetail = memberService.selectMemberDetail(id);
		log.info("[AdminMemberController] memberDetail : {}", memberDetail);
		
		model.addAttribute("member", memberDetail);
		
		return "admin/member/detail";
	}
	
	  @GetMapping("/edit/{id}")
	    public String editForm(@PathVariable("id") String id, Model model) {
			
			AdminMemberDTO memberDetail = memberService.selectMemberDetail(id);
			log.info("[AdminMemberController] memberDetail : {}", memberDetail);
			
			model.addAttribute("member", memberDetail);
			
			return "admin/member/edit";
	    }
	  
	
	  @PostMapping("/edit")
	  public String updateMember(@ModelAttribute("member") AdminMemberDTO member){
	 
		  memberService.updateMember(member);
		  
			    	
	    	return "redirect:/member/list";
	    	
	  }
	 
	  
	 
	  
}

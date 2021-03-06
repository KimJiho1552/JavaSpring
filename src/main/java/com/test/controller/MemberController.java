package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.entity.Member;
import com.test.mapper.BoardMapper;

@Controller
public class MemberController {
	@Autowired
	BoardMapper mapper; //의존성 주입
	
	@GetMapping("/member/memberList")
	public void listMember(Model model) {
		model.addAttribute("list", mapper.selectMemberList());
	}
	
	@GetMapping("/member/memberRegistry")
	public void getMemberRegistry() {}
	
	@PostMapping("/member/memberRegistry")
	public String postMemberRegistry(Member member) {
		mapper.InsertMember(member.getUserid(), member.getUsername(), member.getAge());
		return "redirect:/member/memberList";
	}
}

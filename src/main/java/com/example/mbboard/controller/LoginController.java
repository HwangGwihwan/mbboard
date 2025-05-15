package com.example.mbboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mbboard.dto.Member;
import com.example.mbboard.service.ILoginService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	@Autowired ILoginService loginService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, Member member) {
		Member loginMember = loginService.login(member);
		// 로그인 성공
		if (loginMember != null) {
			session.setAttribute("loginMember", loginMember);
			return "/member/memberHome";
		}

		// 로그인 실패
		return "redirect:/login?error=true";
	}
	
	@GetMapping("/joinMember")
	public String joinMember() {
		return "joinMember";
	}
	
	@PostMapping("/joinMember")
	public String joinMember(Member member) {
		loginService.insert(member);
		return "redirect:/login";
	}
	
	// 로그인 상태에서 요청가능 -> 필터1
	@GetMapping("/member/info")
	public String info() {
		return "/member/info";	
	}
	
	@GetMapping("/member/changePw")
	public String changePw(Model model
			, @RequestParam String memberId) {
		Member member = loginService.selectMemberOne(memberId);
		model.addAttribute("member", member);
		return "/member/changePw";
	}
	
	@PostMapping("/member/changePw")
	public String changePw(Member member) {
		loginService.updateMember(member);
		return "redirect:/logout";
	}
	
	// 로그인 상태이고 role이 'ADMIN' 요청가능 -> 필터2
	@GetMapping("/admin/adminHome")
	public String adminHome(Model model) {
		List<Member> memberList = loginService.selectMember();
		model.addAttribute("memberList", memberList);
		return "/admin/adminHome";
	}
	
	@GetMapping("/admin/changeRole")
	public String changeRole(Model model
			, @RequestParam String memberId) {
		Member member = loginService.selectMemberOne(memberId);
		if (member.getMemberRole().equals("MEMBER")) {
			member.setMemberRole("ADMIN");
		} else {
			member.setMemberRole("MEMBER");
		}
		
		loginService.updateMember(member);
		
		List<Member> memberList = loginService.selectMember();
		model.addAttribute("memberList", memberList);
		return "/admin/adminHome";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}

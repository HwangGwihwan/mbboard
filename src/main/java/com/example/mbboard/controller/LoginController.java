package com.example.mbboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mbboard.dto.ConnectCount;
import com.example.mbboard.dto.Member;
import com.example.mbboard.service.ILoginService;
import com.example.mbboard.service.IRootService;
import com.example.mbboard.service.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	@Autowired ILoginService loginService;
	@Autowired IRootService rootService;
	
	@GetMapping("/findMemberPw")
	public String findMemberPW() {
		return "findMemberPw";
	}
	
	@PostMapping("/findMemberPw")
	public String findMemberPw(Model model, Member member) {
		loginService.changeMemberPwByAdmin(member);
		// 분실 비밀번호 변경 페이지로 redirect
		model.addAttribute("member", member);
		return "rechangeMemberPw";
	}
	
	@PostMapping("/changeMemberPw")
	public String changeMemberPw(Member member) {
		int row = loginService.changeMemberPw(member);
		
		if (row > 0) { // 10분 안에 바꿈
			return "/login";
		} else { // 비밀번호 새로 받아야함
			return "redirect:/findMemberPw";
		}
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, Member member, HttpServletResponse response) {
		Member loginMember = loginService.login(member);
		// 로그인 성공
		if (loginMember != null) {
			// 클라이언트 쿠키에도 로그인에 성공한 ID만 저장
			
			if (member.getSaveIdCk() != null) {
				Cookie c = new Cookie("saveId", member.getMemberId());
				response.addCookie(c);
			} else {
				Cookie c = new Cookie("saveId", "");
				response.addCookie(c);
			}

			session.setAttribute("loginMember", loginMember);
			
			// 멤버(ADMIN, MEMBER) 카운트 + 1
			ConnectCount cc = new ConnectCount();
			cc.setMemberRole(loginMember.getMemberRole());
			if (rootService.getConnectCountByKey(cc) == null) {
				rootService.addConnectCount(cc);
			} else {
				rootService.modifyConnectCount(cc);
			}
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

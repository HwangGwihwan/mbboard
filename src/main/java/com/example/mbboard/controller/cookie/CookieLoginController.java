package com.example.mbboard.controller.cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mbboard.dto.ConnectCount;
import com.example.mbboard.dto.Member;
import com.example.mbboard.listener.ConnectCountListener;
import com.example.mbboard.listener.ContectBootListener;
import com.example.mbboard.service.ILoginService;
import com.example.mbboard.service.IRootService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CookieLoginController {
	@Autowired ILoginService loginService;

	@GetMapping("/cookieLogin")
	public String cookieLogin() {
		return "/cookie/cookieLogin";
	}
	
	@PostMapping("/cookieLogin")
	public String cookieLogin(Member member, HttpServletResponse response) {
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
			
			Cookie loginMemberId = new Cookie("loginMemberId", member.getMemberId());
			response.addCookie(loginMemberId);

			return "redirect:/cookieSuccess";
		}

		// 로그인 실패
		return "redirect:/cookieLogin";
	}
	
	@GetMapping("/cookieSuccess")
	public String cookieSuccess(@CookieValue(value="loginMemberId", required = false) String loginMeberId) {
		if (loginMeberId == null || loginMeberId.equals("")) {
			return "redirect:/cookieLogin";
		}
		
		return "cookie/cookieSuccess";
	}
	
	@GetMapping("/cookieLogout")
	public String logout(HttpServletResponse response) {
		Cookie loginMemberId = new Cookie("loginMemberId", null);
		response.addCookie(loginMemberId);
		return "/cookie/cookieLogin";
	}

}

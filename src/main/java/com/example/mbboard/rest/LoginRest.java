package com.example.mbboard.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mbboard.service.ILoginService;

@RestController
public class LoginRest {
	@Autowired ILoginService loginService;

	@GetMapping("/idCheck/{memberId}")
	public boolean idCheck(@PathVariable String memberId) {
		if (loginService.selectId(memberId) != null) {
			return true;
		}
		return false;
	}
}

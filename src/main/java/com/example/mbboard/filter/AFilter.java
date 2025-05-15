package com.example.mbboard.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter("/a")
public class AFilter implements Filter {
	public AFilter() {
		log.info("AFilter 객체 생성 후 자동으로 빈 등록됨");
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		log.info("/a 선행 내용");
		
		chain.doFilter(request, response);
		
		log.info("/a 후행 내용");
	}

}

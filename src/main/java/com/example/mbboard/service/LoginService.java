package com.example.mbboard.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mbboard.dto.Member;
import com.example.mbboard.mapper.LoginMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class LoginService implements ILoginService{
	@Autowired LoginMapper loginMapper;
	@Autowired JavaMailSender javaMailSender;

	public Member login(Member paramMember) {
		return loginMapper.login(paramMember);
	}
	
	public String selectId(String memberId) {
		return loginMapper.selectId(memberId);
	}
	
	public List<Member> selectMember() {
		return loginMapper.selectMember();
	}
	
	public Member selectMemberOne(String memberId) {
		return loginMapper.selectMemberOne(memberId);
	}

	public int insert(Member paramMember) {
		return loginMapper.insert(paramMember);
	}
	
	public int updateMember(Member paramMember) {
		return loginMapper.updateMember(paramMember);
	}

	public void changeMemberPwByAdmin(Member member) {
		String randomPw = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
		member.setMemberPw(randomPw);
		int row = loginMapper.updateMemberPwByAmdin(member);
		
		if (row == 1) {
			// 메일로 변경된 비번 전송
			log.info("변경된 비밀번호 : " + randomPw);
			
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom("admin@localhost.com");
			msg.setTo(member.getEmail());
			msg.setSubject("변경된 비밀번호 입니다");
			msg.setText("10분안에 로그인하여 수정하셔야 합니다. 비밀번호 : " + randomPw);
			
			javaMailSender.send(msg);
		}
	}

	public int changeMemberPw(Member member) {
		return loginMapper.updateMemberPw(member);
	}
}

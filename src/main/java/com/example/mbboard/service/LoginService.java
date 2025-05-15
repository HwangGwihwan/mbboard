package com.example.mbboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.mbboard.MbboardApplication;
import com.example.mbboard.dto.Member;
import com.example.mbboard.mapper.LoginMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class LoginService implements ILoginService{
	@Autowired LoginMapper loginMapper;


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
}

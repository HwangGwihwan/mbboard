package com.example.mbboard.service;

import java.util.List;

import com.example.mbboard.dto.Member;

public interface ILoginService {
	Member login(Member paramMember);
	String selectId(String memberId);
	List<Member> selectMember();
	Member selectMemberOne(String memberId);
	
	int insert(Member paramMember);
	int updateMember(Member paramMember);
	
	void changeMemberPwByAdmin(Member member);
	int changeMemberPw(Member member);
}

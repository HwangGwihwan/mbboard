package com.example.mbboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mbboard.dto.Member;

@Mapper
public interface LoginMapper {
	Member login(Member member);
	String selectId(String memberId);
	List<Member> selectMember();
	Member selectMemberOne(String memberId);
	int insert(Member member);
	int updateMember(Member member);
	int updateMemberPwByAmdin(Member member);
	int updateMemberPw(Member member);
}

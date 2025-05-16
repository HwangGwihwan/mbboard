package com.example.mbboard.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.mbboard.dto.ConnectCount;

@Mapper
public interface ConnectCountMapper {
	Map<String, Integer> selectConnectCountAll();
	Map<String, Integer> selectConnectCountToday();
	
	// 오늘날짜의 카운팅 있는지 없는지
	String selectConnectDateBykey(ConnectCount cc);
	
	// selectConnectDateBykey 반환값이 없다면
	int insertConnectCount(ConnectCount cc);
	// 있다면
	int updateConenctCount(ConnectCount cc);
}

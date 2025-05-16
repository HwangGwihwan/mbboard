package com.example.mbboard.service;

import java.util.Map;

import com.example.mbboard.dto.ConnectCount;

public interface IRootService {
	
	// 오늘 && memberRole의 데이터(행)이 없을때 -> insert count = 1
	int addConnectCount(ConnectCount cc);
	// 오늘 && memberRole의 데이터(행)이 있을때 -> update count = count + 1
	int modifyConnectCount(ConnectCount cc);
	
	String getConnectCountByKey(ConnectCount cc);
	
	Map<String, Integer> getConnectCountAll();
	Map<String, Integer> getConnectCountToday();
}

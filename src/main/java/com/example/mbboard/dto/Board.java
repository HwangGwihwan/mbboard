package com.example.mbboard.dto;

import lombok.Data;

@Data
public class Board {
	int boardNo;
	String boardTitle;
	String boardContent;
	String boardUser;
	String updatedate;
	String createdate;
}

package com.example.mbboard.service;

import java.util.List;

import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;

public interface IBoardService {
	int count(String s);
	List<Board> selectBoard(Page p);
	Board selectBoardOne(int boardNo);
	int insertBoard(Board b);
	int updateBoard(Board b);
	int deleteBoard(int boardNo);
}

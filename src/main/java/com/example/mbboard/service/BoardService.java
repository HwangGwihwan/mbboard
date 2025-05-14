package com.example.mbboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.mbboard.MbboardApplication;
import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;
import com.example.mbboard.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class BoardService implements IBoardService{
	@Autowired BoardMapper boardMapper;

	public int count(String s) {
		return boardMapper.count(s);
	}

	public List<Board> selectBoard(Page p) {
		return boardMapper.selectBoardListByPage(p);
	}
	
	public Board selectBoardOne(int boardNo) {
		return boardMapper.selectBoardOne(boardNo);
	}
	
	public int insertBoard(Board b) {
		return boardMapper.insertBoard(b);
	}
	
	public int updateBoard(Board b) {
		return boardMapper.updateBoard(b);
	}
	
	public int deleteBoard(int boardNo) {
		return boardMapper.deleteBoardByKey(boardNo);
	}
}

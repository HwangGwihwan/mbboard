package com.example.mbboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;
import com.example.mbboard.service.BoardService;
import com.example.mbboard.service.IBoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired IBoardService boardService;
	
	@GetMapping("/boardList")
	public String boardList(Model model
			, @RequestParam(defaultValue = "1") int currentPage
			, @RequestParam(defaultValue = "") String searchWord) {
				
		Page p = new Page(10, currentPage, boardService.count(searchWord), searchWord);
		List<Board> boardList = boardService.selectBoard(p);
		model.addAttribute("boardList", boardList);
		model.addAttribute("page", p);
		return "boardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoard() {
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board b) {
		boardService.insertBoard(b);
		return "redirect:/boardList";
	}
	
	@GetMapping("/boardOne")
	public String boardOne(Model model
			, @RequestParam int boardNo) {
		Board board = boardService.selectBoardOne(boardNo);
		model.addAttribute("board", board);
		return "boardOne";
	}
	
	@GetMapping("/modifyBoard")
	public String modifyBoard(Model model
			, @RequestParam int boardNo) {
		Board board = boardService.selectBoardOne(boardNo);
		model.addAttribute("board", board);
		return "modifyBoard";
	}
	
	@PostMapping("/modifyBoard")
	public String modifyBoard(Board b) {
		boardService.updateBoard(b);
		return "redirect:/boardOne?boardNo=" + b.getBoardNo();
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(@RequestParam int boardNo) {
		boardService.deleteBoard(boardNo);
		return "redirect:/boardList";
	}
}

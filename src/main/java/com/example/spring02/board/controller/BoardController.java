package com.example.spring02.board.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.board.dto.BoardDTO;
import com.example.spring02.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger=
			LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardService boardService;
	
@RequestMapping("list.do")
	public ModelAndView listAll() throws Exception {
	
		List<BoardDTO> list = boardService.listAll();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/board/board_list");
		Map<String,Object> map = new HashMap<>();
		map.put("list", list);
		mav.addObject("map", map);
		return mav;
	}

@RequestMapping("/detail/{bno}")
	public ModelAndView detail(@PathVariable("bno") int bno,ModelAndView mav) throws Exception {
		mav.setViewName("/board/detail");
		mav.addObject("dto", boardService.detail(bno));
		logger.info("성공?"+bno);
	return mav;
}

@RequestMapping("delete.do")
	public String delete(@RequestParam int bno) throws Exception {
		boardService.delete(bno);
		return "redirect:/board/list.do";
}

@RequestMapping("insert.do")
	public ModelAndView insert(HttpSession session) {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("board/write");
	mav.addObject("session", session);
	return mav;
}

@RequestMapping("write.do")
	public String write(@ModelAttribute BoardDTO dto) throws Exception {
	boardService.insert(dto);
	return "redirect:/board/list.do";
	
}

@RequestMapping("update.do")
	public String update(BoardDTO dto) throws Exception{
	boardService.update(dto);
	return "redirect:/board/list.do";
}

}

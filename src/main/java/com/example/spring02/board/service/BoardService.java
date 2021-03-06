package com.example.spring02.board.service;

import java.util.List;

import com.example.spring02.board.dto.BoardDTO;

public interface BoardService {

	public List<BoardDTO> listAll()throws Exception;
	public BoardDTO detail(int bno)throws Exception;
	public void delete (int bno)throws Exception;
	public void insert(BoardDTO dto) throws Exception;
	public void update(BoardDTO dto) throws Exception;
}

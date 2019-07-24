package com.example.spring02.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring02.board.dao.BoardDAO;
import com.example.spring02.board.dto.BoardDTO;
@Service
public class BoardServiceImpl implements BoardService {

	
	@Autowired
	BoardDAO boardDao;
	
	@Override
	public List<BoardDTO> listAll()throws Exception {
		return boardDao.listAll();
	}

	@Override
	public BoardDTO detail(int bno)throws Exception {
		return boardDao.detail(bno);
	}

	@Override
	public void delete(int bno)throws Exception {
		boardDao.delete(bno);
	}

	@Override
	public void insert(BoardDTO dto) throws Exception {
		boardDao.insert(dto);
	}

	@Override
	public void update(BoardDTO dto) throws Exception {
		boardDao.update(dto);
	}

}

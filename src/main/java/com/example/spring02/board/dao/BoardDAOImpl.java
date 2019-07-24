package com.example.spring02.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring02.board.dto.BoardDTO;


@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<BoardDTO> listAll() throws Exception{
		return sqlsession.selectList("board.selectAll");

	}

	@Override
	public BoardDTO detail(int bno) throws Exception{
		return sqlsession.selectOne("board.detail",bno);
	}

	@Override
	public void delete(int bno) throws Exception{
		sqlsession.delete("board.delete", bno);
	}

	@Override
	public void insert(BoardDTO dto) throws Exception {
		sqlsession.insert("board.insert",dto);
	}

	@Override
	public void update(BoardDTO dto) throws Exception {
		sqlsession.update("board.update",dto);
	}

}

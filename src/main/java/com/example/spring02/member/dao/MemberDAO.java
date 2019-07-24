package com.example.spring02.member.dao;

import java.util.List;

import com.example.spring02.board.dto.BoardDTO;
import com.example.spring02.member.dto.MemberDTO;

public interface MemberDAO {

	public List<MemberDTO> listAll ();
	public MemberDTO detail(String userid)throws Exception;
	public void delete(String userid);
	public boolean checkPw(String userid,String passwd);
	public void insert(MemberDTO dto);
	public String login_check(MemberDTO dto);
}

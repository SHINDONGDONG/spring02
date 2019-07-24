package com.example.spring02.member.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring02.member.dto.MemberDTO;

public interface MemberService {

	public List<MemberDTO> listAll ();
	public MemberDTO detail(String userid)throws Exception;
	public void delete(String userid);
	public boolean checkPw(String userid,String passwd);
	public void insert(MemberDTO dto);
	public String login_check(MemberDTO dto,HttpSession session);
	public void logout(HttpSession session);
}

package com.example.spring02.member.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring02.member.dao.MemberDAO;
import com.example.spring02.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDao;
	
	@Override
	public List<MemberDTO> listAll() {
		return memberDao.listAll();
	}

	@Override
	public MemberDTO detail(String userid) throws Exception {
		return memberDao.detail(userid);
	}

	@Override
	public void delete(String userid) {
		memberDao.delete(userid);
	}

	@Override
	public boolean checkPw(String userid,String passwd) {
		return memberDao.checkPw(userid, passwd);
	}

	@Override
	public void insert(MemberDTO dto) {
		memberDao.insert(dto);
	}

	@Override
	public String login_check(MemberDTO dto, HttpSession session) {
		String name = memberDao.login_check(dto);
		if(name !=null) {
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", name);
		}
		return name;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

}

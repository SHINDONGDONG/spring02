package com.example.spring02.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring02.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<MemberDTO> listAll() {
		return sqlsession.selectList("member.listAll");
	}

	@Override
	public MemberDTO detail(String userid) throws Exception {
		return sqlsession.selectOne("member.detail",userid);
	}

	@Override
	public void delete(String userid) {
		sqlsession.selectOne("member.delete",userid);
	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		boolean result = false;
		Map<String,String> map = new HashMap<>();
		map.put("userid",userid);
		map.put("passwd",passwd);
		int count = sqlsession.selectOne("member.checkPw",map);
		if(count ==1)result = true;
		return result;
	}

	@Override
	public void insert(MemberDTO dto) {
		sqlsession.insert("member.insert",dto);
	}

	@Override
	public String login_check(MemberDTO dto) {
		return sqlsession.selectOne("member.login_check",dto);
	}

	
	
	

}

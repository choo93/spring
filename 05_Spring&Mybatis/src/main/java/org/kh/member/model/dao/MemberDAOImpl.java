package org.kh.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.kh.member.model.vo.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{

	@Override
	public Member selectOneMember(SqlSessionTemplate sqlSession, Member vo) {
		return sqlSession.selectOne("member.selectOneMember", vo);
		
	}

	public int updateMember(SqlSessionTemplate sqlSession, Member vo) {		
		return sqlSession.update("member.updateMember", vo);
	}

	public int enrollMember(SqlSessionTemplate sqlSession, Member m) {
		int result = sqlSession.insert("member.insertMember", m);
		return result;
	}

	public int deleteMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.delete("member.deleteMember", m.getUserId());
	}

	public List<Member> showAll(SqlSessionTemplate sqlSession) {
		
		List<Member> list = sqlSession.selectList("member.showAll");
		
		return list;
	}

}

package org.kh.member.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kh.member.common.Log4jAdvice;
import org.kh.member.model.dao.MemberDAOImpl;
import org.kh.member.model.vo.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Resource(name="memberDAO")
	private MemberDAOImpl memberDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Member selectOneMember(Member vo) {
		Member m = memberDAO.selectOneMember(sqlSession,vo);
		
		return m;
		
	}

	public int updateMember(Member vo) {
		return memberDAO.updateMember(sqlSession, vo);
		
	}

	public int enrollMember(Member m) {
		return memberDAO.enrollMember(sqlSession, m);
	}

	public int deleteMember(Member m) {
		return memberDAO.deleteMember(sqlSession,m);
		
	}

	public List<Member> showAll() {
		return memberDAO.showAll(sqlSession);
		
	}

	
	
}

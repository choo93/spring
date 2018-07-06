package org.kh.member.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kh.member.common.Log4jAdvice;
import org.kh.member.model.dao.MemberDAOImpl;
import org.kh.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Resource(name="memberDAO")
	private MemberDAOImpl memberDAO;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Member selectOneMember(Member vo) {
		Member m = memberDAO.selectOneMember(jdbcTemplate,vo);
		
		return m;
	}

	public int updateMember(Member vo) {
		int result = memberDAO.updateMember(jdbcTemplate, vo);
		
		
		return result;
	}

	public int enrollMember(Member m) {
		return memberDAO.enrollMember(jdbcTemplate, m);
	}

	public int deleteMember(Member m) {
		return memberDAO.deleteMember(jdbcTemplate,m);
	}

	public List<Member> showAll() {
		return memberDAO.showAll(jdbcTemplate);
	}

	
	
}

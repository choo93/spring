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
	
	private Log4jAdvice log;
	
	@Resource(name="memberDAO")
	private MemberDAOImpl memberDAO;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public MemberServiceImpl() {
		log = new Log4jAdvice(); 
	}

	@Override
	public Member selectOneMember(Member vo) {
		log.pringLogging();
		Member m = memberDAO.selectOneMember(jdbcTemplate,vo);
		
		return m;
	}

	public int updateMember(Member vo) {
		log.pringLogging();
		int result = memberDAO.updateMember(jdbcTemplate, vo);
		
		
		return result;
	}

	public int enrollMember(Member m) {
		log.pringLogging();
		return memberDAO.enrollMember(jdbcTemplate, m);
	}

	public int deleteMember(Member m) {
		log.pringLogging();
		
		return memberDAO.deleteMember(jdbcTemplate,m);
	}

	public List<Member> showAll() {
		log.pringLogging();
		
		return memberDAO.showAll(jdbcTemplate);
	}

	
	
}

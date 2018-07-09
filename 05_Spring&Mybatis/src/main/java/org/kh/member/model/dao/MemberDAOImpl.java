package org.kh.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.kh.member.model.vo.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{

	@Override
	public Member selectOneMember(JdbcTemplate jdbc, Member vo) {
		
		// query 메소드는 인자값은 2개 혹은 3개
		// 2개 => 쿼리문, RowMapper
		// 3개 => 쿼리문, 쿼리문Parameter, RowMapper
		// 쿼리문 : 말 그대로 SQL 구문
		// RowMapper : 작동한 쿼리문에 대한 결과값을 처리하는 것이 명시된 객체
		// 쿼리문Parameter : 쿼리문에 ?가 있을 경우에 사용되는 인자값
		String query = "select * from member where user_id=? and user_pw = ?";
		
		// 쿼리문 Parameter (Object형)
		Object [] params = {vo.getUserId(),vo.getUserPw()};
		
		List<Member> list = jdbc.query(query, params, new MemberRowMapper());
		
		if(!list.isEmpty()) {
			return (Member)list.get(0);
		}else {
			return null;
		}
		
	}

	public int updateMember(JdbcTemplate jdbcTemplate, Member vo) {
		String query = "update member set user_pw = ?, user_phone = ? where user_id = ?";
		
		Object [] params = {vo.getUserPw(), vo.getUserPhone(), vo.getUserId()};
		
		int result = jdbcTemplate.update(query, params);
		
		return result;
	}

	public int enrollMember(JdbcTemplate jdbcTemplate, Member m) {
		String query = "insert into member values(?,?,?,?)";
		
		Object [] params = {m.getUserId(),m.getUserPw(),m.getUserName(),m.getUserPhone()};
		
		
		return jdbcTemplate.update(query, params);
	}

	public int deleteMember(JdbcTemplate jdbcTemplate, Member m) {
		String query = "delete member where user_id = ?";
		
		int result = jdbcTemplate.update(query, m.getUserId());
		
		return result;
	}

	public List<Member> showAll(JdbcTemplate jdbcTemplate) {
		String query = "select * from member";
		
		List<Member> list = jdbcTemplate.query(query, new MemberRowMapper());
		
		return list;
	}

}

package org.kh.member.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.kh.member.model.vo.Member;
import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rset, int rowNum) throws SQLException {
		Member m = new Member();
		m.setUserId(rset.getString(1));
		m.setUserPw(rset.getString(2));
		m.setUserName(rset.getString(3));
		m.setUserPhone(rset.getString(4));
		return m;
	}

}

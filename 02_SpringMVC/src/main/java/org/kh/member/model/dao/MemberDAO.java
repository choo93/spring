package org.kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.kh.member.model.vo.Member;

public class MemberDAO {

	public Member selectOneMember(Connection conn, Member vo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m =null;
				
		String query = "select * from member where user_id =? and user_pw = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPw());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setUserId(rset.getString(1));
				m.setUserPw(rset.getString(2));
				m.setUserName(rset.getString(3));
				m.setUserPhone(rset.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return m;
	}

}

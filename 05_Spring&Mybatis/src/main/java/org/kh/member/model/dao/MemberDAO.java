package org.kh.member.model.dao;

import org.kh.member.model.vo.Member;
import org.mybatis.spring.SqlSessionTemplate;

public interface MemberDAO {
	public Member selectOneMember(SqlSessionTemplate sqlSession, Member vo);
}

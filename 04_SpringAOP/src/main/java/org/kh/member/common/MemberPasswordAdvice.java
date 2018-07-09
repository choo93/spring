package org.kh.member.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.kh.member.model.vo.Member;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MemberPasswordAdvice {
	@Pointcut("execution(* org.kh.member.model.service.*ServiceImpl.*(org.kh.member.model.vo.Member))")
	public void enrollPassEncry() {}
	
	
	@Before("enrollPassEncry()")
	public void passwordEncry(JoinPoint jp)throws Exception {
		Member vo = (Member)jp.getArgs()[0];
		
		String pw = vo.getUserPw();
		if(pw!=null) {
			String encryPw = SHA256Util.encryData(pw);
			vo.setUserPw(encryPw);
		}
		
	}
}

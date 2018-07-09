package org.kh.member.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// 빈 객체 생성
@Service
@Aspect
public class LogAdvice {
	@Pointcut("execution(* org.kh.member.model.service..*ServiceImpl.*(..))")
	public void allPointcut() {}
	@Pointcut("execution(int org.kh.member.model.service..*ServiceImpl.*(org.kh.member.model.vo.Member))")
	public void transactionPointcut() {}
	
	@Before("allPointcut()")
	public void printLog() {
		System.out.println("[공통 로그 - LogAdvice] : 비즈니스 로직 수행 전 로그 기록 입니다.");
	}
	
	@Before("transactionPointcut()")
	public void printTransactionLog() {
		System.out.println("[트랜잭션 로그 - LogAdvice] : 트랜잭션 처리 로그");
	}
	
	public Object aroundLog(ProceedingJoinPoint pjp)throws Throwable{
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		SimpleDateFormat sdf = new SimpleDateFormat("kk시 mm분 ss초");
		String getTime = sdf.format(date);
		
		System.out.println("[Before : " + getTime + "] : 비즈니스 메소드 수행 전 로그");
		Object returnObj = pjp.proceed();	// proceed 메소드를 바탕으로 전과 후로 나뉨
		
		now = System.currentTimeMillis();
		date = new Date(now);
		sdf = new SimpleDateFormat("kk시 mm분 ss초");
		getTime = sdf.format(date);
		System.out.println("[after : " + getTime + "] : 비즈니스 메소드 수행 후 로그");
		
		System.out.println("======기타 정보========");
		Signature sig = pjp.getSignature();
		System.out.println(sig.getName());
		
		return returnObj;
	}
}

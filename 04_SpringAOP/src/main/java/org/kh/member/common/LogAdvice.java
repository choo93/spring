package org.kh.member.common;

public class LogAdvice {
	public void printLog() {
		System.out.println("[공통 로그 - LogAdvice] : 비즈니스 로직 수행 전 로그 기록 입니다.");
	}
	
	public void printTransactionLog() {
		System.out.println("[트랜잭션 로그 - LogAdvice] : 트랜잭션 처리 로그");
	}
}

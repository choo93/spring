package org.kh.test.ano;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("com")
public class Computer {
	@Resource(name="sony")
	private Speaker speaker;
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public Computer() {
		System.out.println("컴퓨터 객체 생성 성공!");
	}
	public void powerOn() {
		System.out.println("컴퓨터가 켜졌습니다.");
	}
}

package org.kh.test.ano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("comMgr")
public class ComMgr {

	@Autowired
	private Computer com;

	public ComMgr() {
		System.out.println("ComMgr객체 생성 완료");
	}

	public Computer getCom() {
		return com;
	}

	public void setCom(Computer com) {
		this.com = com;
	}
	
	
}

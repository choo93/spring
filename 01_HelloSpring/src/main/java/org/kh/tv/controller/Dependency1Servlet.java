package org.kh.tv.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.tv.model.vo.BeanFactory;
import org.kh.tv.model.vo.LgTV;
import org.kh.tv.model.vo.TV;
import org.kh.tv.model.vo.TVmgr;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Dependency1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Dependency1Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TV tv = (TV)BeanFactory.getBean(request.getParameter("beanName"));
		
		// xml 파일에 있는 Bean객체를 가져오기위한 작업
		// 1. xml 파일을 읽어 들여야 함
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("/applicationContext.xml");
		
		TV tv = cntx.getBean("tvMgr",TVmgr.class).getTv();		// 형변환을 TVmgr로 해준다는
		//TV tv = ((TVmgr)cntx.getBean("tvMgr")).getTv();
		// 또 다른 방식(기존의 익숙했던 방식)
		
		tv.powerOn();//전원 켬
		tv.volumeUp();	//소리를 올림
		tv.volumeDown();	// 소리를 내림
		tv.powerOff();	// 전원을 끔
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

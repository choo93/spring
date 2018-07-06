package org.kh.person.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.person.model.vo.Person;
import org.kh.person.model.vo.PersonMgr;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Dependency2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Dependency2Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("/applicationContext.xml");
		Person p = cntx.getBean("personMgr",PersonMgr.class).getPs();
		
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().println(
				"이름 : " + p.getName() + "<br>" +
				"나이 : " + p.getAge() + "<br>" +
				"주소 : " + p.getAddr()
				);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

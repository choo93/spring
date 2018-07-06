package org.kh.bean.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.bean.model.vo.TestData;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanTest1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BeanTest1Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("/applicationContext.xml");
		TestData td1 = cntx.getBean("data",TestData.class);
		
		td1.setData(td1.getData()+1);
		System.out.println(td1.getData());
		
		TestData td2 = cntx.getBean("data",TestData.class);
		
		td2.setData(td2.getData()+1);
		System.out.println(td2.getData());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

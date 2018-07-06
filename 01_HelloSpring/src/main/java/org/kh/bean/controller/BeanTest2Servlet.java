package org.kh.bean.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.bean.model.vo.CollectionBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanTest2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BeanTest2Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("/applicationContext.xml");
		List<String> list = cntx.getBean("listBean",CollectionBean.class).getNameList();
		
		for(String name : list) {
			System.out.println(name);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

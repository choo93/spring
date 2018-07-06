package org.kh.bean.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.bean.model.vo.MapBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanTest4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BeanTest4Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("/applicationContext.xml");
		Map<String, String> map = cntx.getBean("mapBean",MapBean.class).getAddressMap();
		
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println("이름 : " + key + " / 주소 : " + map.get(key));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

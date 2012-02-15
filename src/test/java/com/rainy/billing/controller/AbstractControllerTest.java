package com.rainy.billing.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rainy.billing.entity.User;

/**
 * Title: <br>
 * Description: <br>
 * Project: elgt2.0<br>
 * Company: Finalist IT Group <br>
 * Copyright: 2011 www.finalist.cn Inc. All rights reserved.<br>
 * 
 * @2011-11-30
 * @author rainy
 * @version 2.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "/spring/springContext-application.xml", "/spring/springContext-service.xml", "/spring/spring-servlet.xml" })
public abstract class AbstractControllerTest {

	private static Log log = LogFactory.getLog(AbstractControllerTest.class);
	
	public MockHttpServletRequest getRequest() {
		return new MockHttpServletRequest();
	}
	
	public MockHttpServletResponse getResponse() {
		return new MockHttpServletResponse();
	}
	
	public PrintWriter getWriter() throws UnsupportedEncodingException {
		return new MockHttpServletResponse().getWriter();
	}

	public AbstractControllerTest() {

		User user = new User();
		user.setUsername("test");
		user.setId(1L);
		user.setPassword("test");

		SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken(user.getUsername(),
						user.getPassword()));
	}

	public void print(Object obj) {
		log.info(obj);
	}

}

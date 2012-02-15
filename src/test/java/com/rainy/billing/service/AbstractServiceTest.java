package com.rainy.billing.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.rainy.billing.entity.User;

@ContextConfiguration(locations={"/spring/springContext-application.xml","/spring/springContext-service.xml"})
public abstract class AbstractServiceTest extends AbstractTransactionalJUnit4SpringContextTests  {
	
	private static Log log = LogFactory.getLog(AbstractServiceTest.class);
	
	public AbstractServiceTest(){
		User user = new User();
		user.setUsername("test");
		user.setId(1L);
		user.setPassword("test");
		
		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	}
	
	public void print(Object obj) {
		log.info(obj);
	}
}

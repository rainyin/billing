package com.rainy.billing.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rainy.billing.entity.User;
import com.rainy.billing.service.RightService;
import com.rainy.billing.service.UserService;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-29
 * @author rainy
 * @version 1.0
 */
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static Log log = LogFactory.getLog(UserDetailsServiceImpl.class);
	
	@Autowired
	private RightService rightService;
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		User user = null;
		log.info("username: " + username);
		user = loadByUsername(username);
		
		return user;
	}

	private User loadByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		User user = null;
		user = userService.getUserByUsername(username);
		if (user == null) {
			String message = "User " + username + "does not exist in system! ";
			log.info(message);
			throw new UsernameNotFoundException(message);
		} else {
			user.setRights(rightService.queryRightByUserId(user.getId()));
		}
		return user;
	}

}

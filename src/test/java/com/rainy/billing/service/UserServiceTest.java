package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.User;
import com.rainy.billing.model.UserVo;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-19
 * @author rainy
 * @version 1.0
 */
public class UserServiceTest extends AbstractServiceTest {
	
	@Autowired
	private UserService userService;
	
	private User createUser(){
		User user = new User();
		user.setName("test");
		
		userService.operateUser(user);
		return user;
	}
	
	@Test
	public void testGetUserById(){
		User user = userService.getUserById(createUser().getId());
		
		print("testGetUserById: user=" + user);
	}
	
	@Test
	public void testGetUserByUsername(){
		User user = userService.getUserByUsername("test");
		
		print("testGetUserByUsername: user=" + user);
	}
	
	@Test
	public void testCreateUser(){
		User user = createUser();
		
		print("testCreateUser: user=" + user);
	}
	
	@Test
	public void testUpdateUser(){
		User user = createUser();
		user.setTel("122121");
		userService.updateUser(user, "123");
		
		print("testUpdateUser: user=" + user);
	}
	
	@Test
	public void testDeleteUser(){
		User user = createUser();
		userService.deleteUser(user.getId());
		
		print("testDeleteUser: id=" + user.getId());
	}
	
	@Test
	public void testPageQueryUser(){
		UserVo vo = new UserVo();
		vo.setName(createUser().getName());
		List<User> list = userService.pageQueryUser(vo);
		
		print("testPageQueryUser: size=" + list.size());
	}
	
	@Test
	public void testAssociateRole(){
		userService.associateRole(1L, new Long[]{2L, 3L});
	}
	
}

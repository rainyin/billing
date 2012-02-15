package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.User;
import com.rainy.billing.model.UserVo;

/**
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
public interface UserService {
	
	User getUserById(Long id);
	
	User getUserByUsername(String username);
	
	void operateUser(User user);
	
	void updateUser(User user, String npassword);
	
	void deleteUser(Long... id);
	
	List<User> pageQueryUser(UserVo vo);
	
	Boolean usernameExist(String username, Long id);
	
	String allRoleToString(Long userId);
	
	void associateRole(Long userId, Long[] roleId);
	
	String allRoleToString();
	
	Boolean isInputPasswordRight(String opassword);
	
	void resetPassword(Long userId);

}

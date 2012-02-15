package com.rainy.billing.dao;

import java.util.Map;

import com.rainy.billing.entity.User;

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
public interface UserDao extends AbstractDao<User> {
	
	User getEntityByUsername(String username);
	
	Long countEntityByUsername(Map<String, Object> param);
	
}

package com.rainy.billing.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rainy.billing.dao.UserDao;
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
@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

	@Override
	public User getEntityByUsername(String username) {
		return (User) this.getSqlSession().selectOne(nameSpace + "getEntityByUsername", username);
	}

	@Override
	public Long countEntityByUsername(Map<String, Object> param) {
		return (Long) this.getSqlSession().selectOne(nameSpace + "countEntityByUsername", param);
	}

	
}

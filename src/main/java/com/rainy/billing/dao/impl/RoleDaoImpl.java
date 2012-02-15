package com.rainy.billing.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rainy.billing.dao.RoleDao;
import com.rainy.billing.entity.Role;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-10-30
 * @author rainy
 * @version 1.0
 */
@Repository
public class RoleDaoImpl extends AbstractDaoImpl<Role> implements RoleDao {

	@Override
	public void addRightToRole(Map<String, Object> param) {
		this.getSqlSession().insert(nameSpace + "addRightToRole", param);
	}

	@Override
	public void addRoleToUser(Map<String, Object> param) {
		this.getSqlSession().insert(nameSpace + "addRoleToUser", param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> queryEntityByUserId(Long userId) {
		return this.getSqlSession().selectList(nameSpace + "queryEntityByUserId", userId);
	}

	@Override
	public void removeRightOfRole(Long roleId) {
		this.getSqlSession().delete(nameSpace + "removeRightOfRole", roleId);
	}

	@Override
	public void removeRoleOfUser(Long userId) {
		this.getSqlSession().delete(nameSpace + "removeRoleOfUser", userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> allEntity() {
		return this.getSqlSession().selectList(nameSpace + "allEntity");
	}

}

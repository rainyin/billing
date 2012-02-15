package com.rainy.billing.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rainy.billing.dao.RightDao;
import com.rainy.billing.entity.Right;

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
public class RightDaoImpl extends AbstractDaoImpl<Right> implements RightDao {

	@Override
	public void addResourceToRight(Map<String, Object> param) {
		this.getSqlSession().insert(nameSpace + "addResourceToRight", param);
	}

	@Override
	public void deleteRightRoleRelation(Map<String, Long[]> param) {
		this.getSqlSession().delete(nameSpace + "deleteRightRoleRelation", param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Right> queryEntityByRoleId(Long roleId) {
		return this.getSqlSession().selectList(nameSpace + "queryEntityByRoleId", roleId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Right> queryEntityByUserId(Long userId) {
		return this.getSqlSession().selectList(nameSpace + "queryEntityByUserId", userId);
	}

	@Override
	public void removeResourceOfRight(Long rightId) {
		this.getSqlSession().insert(nameSpace + "removeResourceOfRight", rightId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Right> allEntity() {
		return this.getSqlSession().selectList(nameSpace + "allEntity");
	}

}

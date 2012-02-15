package com.rainy.billing.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rainy.billing.dao.ResourceDao;
import com.rainy.billing.entity.Resource;
import com.rainy.billing.enumeration.ResourceType;
import com.rainy.billing.model.ResourceRight;

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
public class ResourceDaoImpl extends AbstractDaoImpl<Resource> implements
		ResourceDao {

	@Override
	public void deleteResourceRightRelation(Map<String, Long[]> param) {
		this.getSqlSession().delete(nameSpace + "deleteResourceRightRelation", param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> queryEntityByRightId(Long rightId) {
		return this.getSqlSession().selectList(nameSpace + "queryEntityByRightId", rightId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResourceRight> queryResourceRight(ResourceType type) {
		return this.getSqlSession().selectList(nameSpace + "queryResourceRight", type);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> allEntity() {
		return this.getSqlSession().selectList(nameSpace + "allEntity");
	}

}

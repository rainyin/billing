package com.rainy.billing.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rainy.billing.dao.AreaDao;
import com.rainy.billing.entity.Area;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-26
 * @author rainy
 * @version 1.0
 */
@Repository
public class AreaDaoImpl extends AbstractDaoImpl<Area> implements AreaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Area> queryEntityOfSmsChannel(Map<String, Object> param) {
		return this.getSqlSession().selectList(nameSpace + "queryEntityOfSmsChannel", param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Area> queryEntityOfIvrChannel(Map<String, Object> param) {
		return this.getSqlSession().selectList(nameSpace + "queryEntityOfIvrChannel", param);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Area> queryEntityOfGpChannel(Map<String, Object> param) {
		return this.getSqlSession().selectList(nameSpace + "queryEntityOfGpChannel", param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Area> queryEntityOfParent(Long[] parentId) {
		return this.getSqlSession().selectList(nameSpace + "queryEntityOfParent", parentId);
	}

}

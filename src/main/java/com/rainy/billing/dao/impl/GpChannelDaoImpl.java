package com.rainy.billing.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rainy.billing.dao.GpChannelDao;
import com.rainy.billing.entity.GpChannel;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-23
 * @author rainy
 * @version 1.0
 */
@Repository
public class GpChannelDaoImpl extends AbstractDaoImpl<GpChannel> implements GpChannelDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<GpChannel> queryEntityOfProject(Map<String, Object> param) {
		return this.getSqlSession().selectList(nameSpace + "queryEntityOfProject", param);
	}
	
	@Override
	public void associateWithArea(Map<String, Object> param) {
		this.getSqlSession().insert(nameSpace + "associateWithArea", param);
	}
	
	@Override
	public void unassociateWithArea(Long GpChannelId) {
		this.getSqlSession().delete(nameSpace + "unassociateWithArea", GpChannelId);
	}

}

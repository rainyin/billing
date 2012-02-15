package com.rainy.billing.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rainy.billing.dao.SmsChannelDao;
import com.rainy.billing.entity.SmsChannel;

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
public class SmsChannelDaoImpl extends AbstractDaoImpl<SmsChannel> implements SmsChannelDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SmsChannel> queryEntityOfProject(Map<String, Object> param) {
		return this.getSqlSession().selectList(nameSpace + "queryEntityOfProject", param);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SmsChannel> queryEntityNotOfProject(Map<String, Object> param) {
		return this.getSqlSession().selectList(nameSpace + "queryEntityNotOfProject", param);
	}
	
	@Override
	public void associateWithArea(Map<String, Object> param) {
		this.getSqlSession().insert(nameSpace + "associateWithArea", param);
	}
	
	@Override
	public void unassociateWithArea(Long smsChannelId) {
		this.getSqlSession().delete(nameSpace + "unassociateWithArea", smsChannelId);
	}

}

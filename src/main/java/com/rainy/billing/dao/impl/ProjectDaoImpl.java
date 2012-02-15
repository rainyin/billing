package com.rainy.billing.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rainy.billing.dao.ProjectDao;
import com.rainy.billing.entity.GpChannel;
import com.rainy.billing.entity.IvrChannel;
import com.rainy.billing.entity.Project;
import com.rainy.billing.entity.SmsChannel;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-21
 * @author rainy
 * @version 1.0
 */
@Repository
public class ProjectDaoImpl extends AbstractDaoImpl<Project> implements ProjectDao {

	@Override
	public void associateWithSmsChannel(Map<String, Object> param) {
		this.getSqlSession().insert(nameSpace + "associateWithSmsChannel", param);
	}
	
	@Override
	public void deAssociateWithSmsChannel(Map<String, Object> param) {
		this.getSqlSession().insert(nameSpace + "deAssociateWithSmsChannel", param);
	}
	
	@Override
	public void updateAssociationWithSms(Map<String, Object> param) {
		this.getSqlSession().update(nameSpace + "updateAssociationWithSms", param);
	}
	
	@Override
	public void unassociateWithSmsChannel(Long projectId) {
		this.getSqlSession().delete(nameSpace + "unassociateWithSmsChannel", projectId);
	}

	@Override
	public void associateWithIvrChannel(Map<String, Object> param) {
		this.getSqlSession().insert(nameSpace + "associateWithIvrChannel", param);
	}

	@Override
	public void unassociateWithIvrChannel(Long projectId) {
		this.getSqlSession().delete(nameSpace + "unassociateWithIvrChannel", projectId);
	}
	
	@Override
	public void associateWithGpChannel(Map<String, Object> param) {
		this.getSqlSession().insert(nameSpace + "associateWithGpChannel", param);
	}

	@Override
	public void unassociateWithGpChannel(Long projectId) {
		this.getSqlSession().delete(nameSpace + "unassociateWithGpChannel", projectId);
	}

	@Override
	public Project getEntityWithChannelById(Long id) {
		return (Project) this.getSqlSession().selectOne(nameSpace + "getEntityWithChannelById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GpChannel> queryGpChannelOfProject(Map<String, Object> param) {
		return (List<GpChannel>)this.getSqlSession().selectList(nameSpace + "queryGpChannelOfProject", param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IvrChannel> queryIvrChannelOfProject(Map<String, Object> param) {
		return (List<IvrChannel>)this.getSqlSession().selectList(nameSpace + "queryIvrChannelOfProject", param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SmsChannel> querySmsChannelOfProject(Map<String, Object> param) {
		return (List<SmsChannel>)this.getSqlSession().selectList(nameSpace + "querySmsChannelOfProject", param);
	}

}

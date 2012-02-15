package com.rainy.billing.dao;

import java.util.List;
import java.util.Map;

import com.rainy.billing.entity.GpChannel;
import com.rainy.billing.entity.IvrChannel;
import com.rainy.billing.entity.Project;
import com.rainy.billing.entity.SmsChannel;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-21
 * @author rainy
 * @version 1.0
 */
public interface ProjectDao extends AbstractDao<Project> {

	void associateWithSmsChannel(Map<String, Object> param);
	
	void deAssociateWithSmsChannel(Map<String, Object> param);
	
	void updateAssociationWithSms(Map<String, Object> param);

	void unassociateWithSmsChannel(Long projectId);

	void associateWithIvrChannel(Map<String, Object> param);

	void unassociateWithIvrChannel(Long projectId);
	
	void associateWithGpChannel(Map<String, Object> param);

	void unassociateWithGpChannel(Long projectId);
	
	Project getEntityWithChannelById(Long id);
	
	List<SmsChannel> querySmsChannelOfProject(Map<String, Object> param);
	
	List<IvrChannel> queryIvrChannelOfProject(Map<String, Object> param);
	
	List<GpChannel> queryGpChannelOfProject(Map<String, Object> param);

}

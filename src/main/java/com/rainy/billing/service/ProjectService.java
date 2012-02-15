package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.Project;
import com.rainy.billing.entity.ProjectSmsChannel;
import com.rainy.billing.entity.SmsChannel;
import com.rainy.billing.model.ProjectVo;

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
public interface ProjectService {

	Project getProjectById(Long id);
	
	Project getProjectWithChannelById(Long id);
	
	void setSmsChannel(Project project, String areaCode, String carrierCode);
	
	void setIvrChannel(Project project, String areaCode, String carrierCode);
	
	void setGpChannel(Project project, String areaCode);

	void operateProject(Project project);

	void updateProject(Project project);

	void deleteProject(Long... id);

	List<Project> queryProjectByName(String name);

	List<Project> pageQueryProject(ProjectVo vo);
	
	String allCustomerToString();
	
	String allSmsChannelToString(Long projectId);
	
	String allIvrChannelToString(Long projectId);
	
	String allGpChannelToString(Long projectId);
	
	void associateSms(Long projectId, Long[] smsChannelId);
	
	void deAssociateSms(Long projectId, Long[] smsChannelId);
	
	void updateAssociationWithSms(ProjectSmsChannel projectSms);
	
	void associateSmsChannel(Long projectId, Long[] smsChannelId);
	
	void associateIvrChannel(Long projectId, Long[] ivrChannelId);
	
	void associateGpChannel(Long projectId, Long[] gpChannelId);

	List<SmsChannel> getAssociateSmsChannel(Long projectId, String businessName);

	List<SmsChannel> getAvailableSmsChannel(Long projectId, String businessName);

}

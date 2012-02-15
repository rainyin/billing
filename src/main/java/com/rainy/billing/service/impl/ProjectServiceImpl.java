package com.rainy.billing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.Constant;
import com.rainy.billing.dao.SmsChannelDao;
import com.rainy.billing.dao.CustomerDao;
import com.rainy.billing.dao.GpChannelDao;
import com.rainy.billing.dao.IvrChannelDao;
import com.rainy.billing.dao.ProjectDao;
import com.rainy.billing.entity.ProjectSmsChannel;
import com.rainy.billing.entity.SmsChannel;
import com.rainy.billing.entity.Customer;
import com.rainy.billing.entity.GpChannel;
import com.rainy.billing.entity.IvrChannel;
import com.rainy.billing.entity.Project;
import com.rainy.billing.enumeration.ActiveStatus;
import com.rainy.billing.model.ProjectVo;
import com.rainy.billing.service.CacheService;
import com.rainy.billing.service.ProjectService;
import com.rainy.billing.util.CarrierMatcherUtil;
import com.rainy.billing.util.SelectionUtil;

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
@Service
public class ProjectServiceImpl extends BaseService implements ProjectService {
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private SmsChannelDao smsChannelDao;
	
	@Autowired
	private IvrChannelDao ivrChannelDao;
	
	@Autowired
	private GpChannelDao gpChannelDao;
	
	@Autowired
	private CacheService cacheService;

	@Override
	public void deleteProject(Long... id) {
		if (id != null && id.length == 1) {
			projectDao.deleteEntityById(id[0]);
		} else if(id != null){
			projectDao.deleteEntityBatch(id);
		} else {
			log.warn("delete project by null id");
		}
		log.debug("delete project success: id = " + id);
		for(Long projectId : id) {
			cacheService.removeProject(projectId);
		}
	}

	@Override
	public Project getProjectById(Long id) {
		if (id != null) {
			return projectDao.getEntityById(id);
		}
		log.warn("get project by null id");
		return null;
	}

	@Override
	public List<Project> queryProjectByName(String name) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("name", name);
		
		return projectDao.queryEntity(param);
	}
	
	private void setCustName(Project project) {
		Customer cust = customerDao.getEntityById(project.getCustomerId());
		if(cust != null) {
			project.setCustomerName(cust.getName());
		}
	}

	@Override
	public void updateProject(Project project) {
		project.setOperatorId(getOperatorId());
		setCustName(project);
		projectDao.updateEntity(project);
		log.debug("update project success: id=" + project.getId());
		cacheService.removeProject(project.getId());
	}

	@Override
	public void operateProject(Project project) {
		if(project.getPager().isToUpdate()) {
			project.setOperatorId(getOperatorId());
			setCustName(project);
			projectDao.updateEntity(project);
			log.debug("update project success: id=" + project.getId());
			cacheService.removeProject(project.getId());
		} else if(project.getPager().isToCreate()){
			setCustName(project);
			project.setOperatorId(getOperatorId());
			projectDao.createEntity(project);
			log.debug("create project success: id=" + project.getId());
		} else {
			projectDao.deleteEntityById(project.getId());
			log.debug("delete project success: id=" + project.getId());
			cacheService.removeProject(project.getId());
		}
	}

	@Override
	public List<Project> pageQueryProject(ProjectVo vo) {
		return projectDao.pageQueryEntity(vo);
	}

	@Override
	public String allCustomerToString() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("status", ActiveStatus.ENABLED);
		
		List<Customer> all = customerDao.queryEntity(param);
		
		return SelectionUtil.createSelectOptions(all);
	}
	
	@Override
	public List<SmsChannel> getAssociateSmsChannel(Long projectId, String businessName) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("projectId", projectId);
		if(businessName != null) param.put("businessName", businessName);
		
		return smsChannelDao.queryEntityOfProject(param);
	}
	
	@Override
	public List<SmsChannel> getAvailableSmsChannel(Long projectId, String businessName) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("projectId", projectId);
		if(businessName != null) param.put("businessName", businessName);
		
		return smsChannelDao.queryEntityNotOfProject(param);
	}

	@Override
	public String allSmsChannelToString(Long projectId) {
		List<SmsChannel> selected = getAssociateSmsChannel(projectId, null);
		List<SmsChannel> all = smsChannelDao.queryEntity(new HashMap<String, Object>());
		
		return SelectionUtil.createMultiselectOptions(all, selected);
	}

	@Override
	public String allIvrChannelToString(Long projectId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("projectId", projectId);
		
		List<IvrChannel> selected = ivrChannelDao.queryEntityOfProject(param);
		param.clear();
		List<IvrChannel> all = ivrChannelDao.queryEntity(param);
		
		return SelectionUtil.createMultiselectOptions(all, selected);
	}
	
	@Override
	public String allGpChannelToString(Long projectId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("projectId", projectId);
		
		List<GpChannel> selected = gpChannelDao.queryEntityOfProject(param);
		param.clear();
		List<GpChannel> all = gpChannelDao.queryEntity(param);
		
		return SelectionUtil.createMultiselectOptions(all, selected);
	}
	
	@Override
	public void associateSms(Long projectId, Long[] smsChannelId) {
		if(smsChannelId != null && smsChannelId.length > 0){
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("projectId", projectId);
			param.put("operatorId", getOperatorId());
			param.put("smsChannelId", smsChannelId);
			param.put("sendTimes", 1);
			
			projectDao.associateWithSmsChannel(param);
			cacheService.removeProject(projectId);
		}
	}
	
	@Override
	public void deAssociateSms(Long projectId, Long[] smsChannelId) {
		if(smsChannelId != null && smsChannelId.length > 0){
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("projectId", projectId);
			param.put("operatorId", getOperatorId());
			param.put("smsChannelId", smsChannelId);
			
			projectDao.deAssociateWithSmsChannel(param);
			cacheService.removeProject(projectId);
		}
	}
	
	@Override
	public void updateAssociationWithSms(ProjectSmsChannel projectSms) {
		if(projectSms != null && projectSms.getProjectId() > Constant.INITIAL_ID){
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("projectId", projectSms.getProjectId());
			param.put("operatorId", getOperatorId());
			param.put("smsChannelId", projectSms.getSmsChannelId());
			param.put("sendTimes", projectSms.getSendTimes());
			
			projectDao.updateAssociationWithSms(param);
			cacheService.removeProject(projectSms.getProjectId());
		}
	}
	
	@Override
	public void associateSmsChannel(Long projectId, Long[] smsChannelId) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("projectId", projectId);
		param.put("operatorId", getOperatorId());
		param.put("smsChannelId", smsChannelId);
		
		projectDao.unassociateWithSmsChannel(projectId);
		if(smsChannelId != null && smsChannelId.length > 0){
			projectDao.associateWithSmsChannel(param);
		}
		cacheService.removeProject(projectId);
	}

	@Override
	public void associateIvrChannel(Long projectId, Long[] ivrChannelId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("projectId", projectId);
		param.put("operatorId", getOperatorId());
		param.put("ivrChannelId", ivrChannelId);
		
		projectDao.unassociateWithIvrChannel(projectId);
		if(ivrChannelId != null && ivrChannelId.length > 0){
			projectDao.associateWithIvrChannel(param);
		}
		cacheService.removeProject(projectId);
	}
	
	@Override
	public void associateGpChannel(Long projectId, Long[] gpChannelId) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("projectId", projectId);
		param.put("operatorId", getOperatorId());
		param.put("gpChannelId", gpChannelId);
		
		projectDao.unassociateWithGpChannel(projectId);
		if(gpChannelId != null && gpChannelId.length > 0){
			projectDao.associateWithGpChannel(param);
		}
		cacheService.removeProject(projectId);
	}

	@Override
	public Project getProjectWithChannelById(Long id) {
		if (id != null) {
			return projectDao.getEntityWithChannelById(id);
		}
		log.warn("get project by null id");
		return null;
	}

	@Override
	public void setGpChannel(Project project, String areaCode) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("projectId", project.getId());
		param.put("areaCode", areaCode);
		
		project.setGpChannels(projectDao.queryGpChannelOfProject(param));
	}

	@Override
	public void setIvrChannel(Project project, String areaCode, String carrierCode) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("projectId", project.getId());
		param.put("areaCode", areaCode);
		param.put("carrier", CarrierMatcherUtil.getKeyByValue(carrierCode));
		
		project.setIvrChannels(projectDao.queryIvrChannelOfProject(param));
	}

	@Override
	public void setSmsChannel(Project project, String areaCode,
			String carrierCode) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("projectId", project.getId());
		param.put("areaCode", areaCode);
		param.put("carrier", CarrierMatcherUtil.getKeyByValue(carrierCode));
		
		project.setSmsChannels(projectDao.querySmsChannelOfProject(param));
	}	
	
}

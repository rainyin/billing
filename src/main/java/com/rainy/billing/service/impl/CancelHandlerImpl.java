package com.rainy.billing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.Constant;
import com.rainy.billing.entity.Project;
import com.rainy.billing.entity.SmsChannel;
import com.rainy.billing.model.service.CancelRequest;
import com.rainy.billing.model.service.CancelResponse;
import com.rainy.billing.service.CacheService;
import com.rainy.billing.service.CancelHandler;
import com.rainy.billing.service.ProjectService;
import com.rainy.billing.util.StringUtil;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-12-9
 * @author rainy
 * @version 1.0
 */
@Service
public class CancelHandlerImpl implements CancelHandler {
	
	protected Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private CacheService cacheService;
	
	@Autowired
	private ProjectService projectService;

	@Override
	public String handle(CancelRequest cancelRequest) {
		CancelResponse response = new CancelResponse();
		
		Project project = cacheService.getProject(Long.valueOf(cancelRequest.getProjectid()));
		if(project != null) {
			response.setMaxfee(project.getMonthlyFee().toString());
			response.setBlacktime(project.getShieldCycle().toString());
			response.setHide(StringUtil.convertBoolean(project.getShieldSms()));
			
			List<String> smsKey = new ArrayList<String>();
			projectService.setSmsChannel(project, cancelRequest.getSc(), cancelRequest.getPlmn());
			projectService.setIvrChannel(project, cancelRequest.getSc(), cancelRequest.getPlmn());
			projectService.setGpChannel(project, cancelRequest.getSc());
			
			if(project.getSmsChannels() != null && project.getSmsChannels().size() > 0) {	
				for(SmsChannel smsChan : project.getSmsChannels()) {
					smsKey.add(smsChan.getShieldKey());
					smsKey.add(smsChan.getPort() + Constant.SMS_NUM_DELIMITER);
				}
			} else {
				log.info("not matched SMS channel for project: " + project.getId());
			}
			
			if(project.getIvrChannels() != null && project.getIvrChannels().size() > 0) {	
				smsKey.add(project.getIvrChannels().get(0).getSmsKey());
			} else {
				log.info("not matched IVR channel for project: " + project.getId());
			}
			
			if(project.getGpChannels() != null && project.getGpChannels().size() > 0) {	
				smsKey.add(project.getGpChannels().get(0).getCustShieldKey());
				smsKey.add(project.getGpChannels().get(0).getCancelInstruction());
				smsKey.add(project.getGpChannels().get(0).getInstructionTo() + Constant.SMS_NUM_DELIMITER);
				
				response.setCmd(project.getGpChannels().get(0).getCancelInstruction());
				response.setSpid(project.getGpChannels().get(0).getInstructionTo());	
			} else {
				log.info("not matched GP channel for project: " + project.getId());
			}
			
			StringBuilder smsKeyStr = new StringBuilder();
			for(String str : smsKey) {
				if(StringUtil.isNotBlank(str)) {
					if(smsKeyStr.length() > 0) smsKeyStr.append(Constant.SMS_KEY_DELIMITER);
					smsKeyStr.append(StringUtil.toUnicode(str));
				}
			}
			response.setSmskey(smsKeyStr.toString());
		}
		return response.toString();
	}

}

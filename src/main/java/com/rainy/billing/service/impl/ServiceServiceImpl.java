package com.rainy.billing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.dao.QuestionDao;
import com.rainy.billing.entity.Project;
import com.rainy.billing.entity.Question;
import com.rainy.billing.entity.Terminal;
import com.rainy.billing.model.service.CancelRequest;
import com.rainy.billing.model.service.ChanRequest;
import com.rainy.billing.model.service.McatRequest;
import com.rainy.billing.service.CacheService;
import com.rainy.billing.service.CancelHandler;
import com.rainy.billing.service.CatNumberService;
import com.rainy.billing.service.ChannelHandler;
import com.rainy.billing.service.SequenceService;
import com.rainy.billing.service.ServiceService;
import com.rainy.billing.service.TerminalService;
import com.rainy.billing.util.StringUtil;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-27
 * @author rainy
 * @version 1.0
 */
@Service
public class ServiceServiceImpl extends BaseService implements ServiceService {
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private ChannelHandler channelHandler;
	
	@Autowired
	private CancelHandler cancelHandler;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private TerminalService terminalService;
	
	@Autowired
	private CacheService cacheService;
	
	@Autowired
	private CatNumberService catNumberService;
	
	@Override
	public String handleChannelRequest(ChanRequest chanRequest) {
		String str = "projectid not exist";
		if(!chanRequest.isValid()) {
			log.error("parameters is invalid: " + chanRequest.toString());
			return "parameters is invalid" ;
		}
		log.info("request for getChannel: " + chanRequest.toString());
		str = channelHandler.handle(chanRequest);
		
		log.info("response for getChannel: " + str);
		return str;
	}
	
	@Override
	public String handleCancelRequest(CancelRequest cancelRequest) {
		String str = "projectid not exist";
		if(!cancelRequest.isValid()) {
			log.error("parameters is invalid: " + cancelRequest.toString());
			return "parameters is invalid" ;
		}
		log.info("request for cancel G+: " + cancelRequest.toString());
		str = cancelHandler.handle(cancelRequest);
		
		log.info("response for cancel G+: " + str);
		return str;
	}
	
	@Override
	public String handleSmsNumRequest() {
		log.info("request for getSmsNum: ");
		
		log.info("response for getSmsNum: ");
		return "";
	}
	@Override
	public String handleAskSmsRequest(String unicodeSms) {
		log.info("request for getAskSms: " + unicodeSms);
		String deunicodeSms = StringUtil.fromUnicode(unicodeSms);
		if(deunicodeSms == null || deunicodeSms.equals("")) {
			log.error("request for getAskSms with null sms");
			return "";
		}
		log.info("deunicode sms: " + deunicodeSms);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("content", deunicodeSms);
		List<Question> questions = questionDao.queryEntity(param);
		log.info("question to sms, size: " + questions.size());
		
		String result = "getasksms:";
		if(questions != null && questions.size() > 0) {
			result += StringUtil.toUnicode(questions.get(0).getAnswer());
		} else {
			questionDao.createEntity(new Question(deunicodeSms));
		}
		
		log.info("response for getAskSms: " + result);
		return result;
	}

	@Override
	public String handleUidRequest() {
		log.info("request for getUid: ");
		
		String sequence = sequenceService.retrieveUid();
		StringBuilder uid = new StringBuilder();
		
		uid.append("getimsiserialno:");
		uid.append(sequence);
 		
		log.info("response for getUid: " + uid);
		return uid.toString();
	}
	
	private void handleNumber4Terminal(Terminal ter, McatRequest mCatRequest, Project project) {
		if(ter == null) {
			ter = new Terminal(mCatRequest.getU(), mCatRequest.getImsi(), project.getId(), 
					project.getName(), mCatRequest.getPlmn(), mCatRequest.getSc(), catNumberService.getValidNumber(), mCatRequest.getVer());
			ter.setNumber(mCatRequest.getPhone());
			terminalService.createTerminal(ter);
		} else if(ter.getNumber() == null || !ter.getNumber().equals(mCatRequest.getPhone())) {
			ter.setNumber(mCatRequest.getPhone());
			terminalService.updateTerminal(ter);
		}
	}


	@Override
	public String handleMcatRequest(McatRequest mCatRequest) {
		log.info("request for mcat: " + mCatRequest);
		if(mCatRequest.isValid()) {
			Long projectId = Long.valueOf(mCatRequest.getP());
			Project project = cacheService.getProject(projectId);
			if(project != null) {
				if(mCatRequest.isUidValid()) {
					handleNumber4Terminal(terminalService.getTerminalByUid(mCatRequest.getU()), mCatRequest, project);
				} else {
					Terminal ter = terminalService.getTerminalByImsi(mCatRequest.getImsi());
					if(ter == null) mCatRequest.setU(sequenceService.retrieveUid());
					handleNumber4Terminal(ter, mCatRequest, project);
				}
			}
			
			return "ok";
		}
		
		return "parameter is not valid";
	}

}

package com.rainy.billing.model;

import java.util.ArrayList;
import java.util.List;

import com.rainy.billing.entity.Project;
import com.rainy.billing.model.service.ChanRequest;
import com.rainy.billing.model.service.ChanResponse;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-12-6
 * @author rainy
 * @version 1.0
 */
public class ChannelEvent {

	private ChanResponse chanResponse;
	private ChanRequest chanRequest;
	private List<String> smsKey = new ArrayList<String>();

	private Project project;

	public ChannelEvent(ChanRequest chanRequest) {
		this.chanRequest = chanRequest;
		this.chanResponse = new ChanResponse();
	}

	public ChanResponse getChanResponse() {
		return chanResponse;
	}

	public void setChanResponse(ChanResponse chanResponse) {
		this.chanResponse = chanResponse;
	}

	public ChanRequest getChanRequest() {
		return chanRequest;
	}

	public void setChanRequest(ChanRequest chanRequest) {
		this.chanRequest = chanRequest;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<String> getSmsKey() {
		return smsKey;
	}

	public void setSmsKey(List<String> smsKey) {
		this.smsKey = smsKey;
	}

}

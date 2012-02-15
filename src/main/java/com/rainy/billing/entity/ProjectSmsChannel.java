package com.rainy.billing.entity;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-12-25
 * @author rainy
 * @version 1.0
 */
public class ProjectSmsChannel {

	private Long projectId;
	private Long smsChannelId;
	private Integer sendTimes;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getSmsChannelId() {
		return smsChannelId;
	}

	public void setSmsChannelId(Long smsChannelId) {
		this.smsChannelId = smsChannelId;
	}

	public Integer getSendTimes() {
		return sendTimes;
	}

	public void setSendTimes(Integer sendTimes) {
		this.sendTimes = sendTimes;
	}

}

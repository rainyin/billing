package com.rainy.billing.model;

import java.util.ArrayList;
import java.util.List;

import com.rainy.billing.entity.Project;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-11-29
 * @author rainy
 * @version 1.0
 */
public class ProjectChannel {

	private String channelType;
	private String channelNames;
	
	public ProjectChannel() {	
	}
	
	public ProjectChannel(String channelType, String channelNames) {
		this.channelType = channelType;
		this.channelNames = channelNames;
	}
	
	public static List<ProjectChannel> generateList(Project project) {
		List<ProjectChannel> list = new ArrayList<ProjectChannel>();
		if(project != null) {
			if(project.getSmsChannels() != null && project.getSmsChannels().size() > 0) {
				list.add(new ProjectChannel("短信通道", project.smsChannelsToString()));
			}
			if(project.getIvrChannels() != null && project.getIvrChannels().size() > 0) {
				list.add(new ProjectChannel("IVR通道", project.ivrChannelsToString()));
			} 
			if(project.getGpChannels() != null && project.getGpChannels().size() > 0) {
				list.add(new ProjectChannel("G+通道", project.GpChannelsToString()));
			}
		}
		
		return list;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getChannelNames() {
		return channelNames;
	}

	public void setChannelNames(String channelNames) {
		this.channelNames = channelNames;
	}

}

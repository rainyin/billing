package com.rainy.billing.service.impl;

import com.rainy.billing.model.ChannelEvent;
import com.rainy.billing.model.service.ChanRequest;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-11-30
 * @author rainy
 * @version 1.0
 */
public abstract class AbstractChannelHandler {
	
	public String handle(ChanRequest chanRequest){
		ChannelEvent event = new ChannelEvent(chanRequest);
		preHandle(event);
		
		if(event.getProject() != null) {
			handleSmsChannel(event);
			handleGpChannel(event);
			handleIvrChannel(event);
		}
		
		return postHandle(event);
	}
	
	abstract void preHandle(ChannelEvent event);
	
	abstract void handleSmsChannel(ChannelEvent event);
	
	abstract void handleGpChannel(ChannelEvent event);
	
	abstract void handleIvrChannel(ChannelEvent event);
	
	abstract String postHandle(ChannelEvent event);


}

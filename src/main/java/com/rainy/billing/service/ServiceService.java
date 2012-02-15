package com.rainy.billing.service;

import com.rainy.billing.model.service.CancelRequest;
import com.rainy.billing.model.service.ChanRequest;
import com.rainy.billing.model.service.McatRequest;

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
public interface ServiceService {
	
	String handleChannelRequest(ChanRequest channelRequest);
	
	String handleCancelRequest(CancelRequest cancelRequest);
	
	String handleSmsNumRequest();
	
	String handleAskSmsRequest(String sms);
	
	String handleMcatRequest(McatRequest mCatRequest);
	
	String handleUidRequest();

}

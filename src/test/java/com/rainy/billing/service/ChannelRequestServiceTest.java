package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.ChannelRequest;
import com.rainy.billing.model.ChannelRequestVo;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-28
 * @author rainy
 * @version 1.0
 */
public class ChannelRequestServiceTest extends AbstractServiceTest {

	@Autowired
	private ChannelRequestService channelRequestService;

	@Test
	public void testCreateChannelRequest() {
		channelRequestService.createChannelRequest(new ChannelRequest());
	}

	@Test
	public void testPageQueryChannelRequest() {
		List<ChannelRequest> list = channelRequestService.pageQueryChannelRequest(new ChannelRequestVo());
		
		print("testPageQueryChannelRequest size: " + list.size());
	}

}

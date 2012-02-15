package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.ChannelProvider;
import com.rainy.billing.model.ChannelProviderVo;

/**
 * Title: <br>
 * Description: <br>
 * ChannelProvider: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-21
 * @author rainy
 * @version 1.0
 */
public interface ChannelProviderService {

	ChannelProvider getChannelProviderById(Long id);

	void operateChannelProvider(ChannelProvider channelProvider);

	void updateChannelProvider(ChannelProvider channelProvider);

	void deleteChannelProvider(Long... id);

	List<ChannelProvider> queryChannelProviderByName(String name);

	List<ChannelProvider> pageQueryChannelProvider(ChannelProviderVo vo);
	
	String allChannelProviderToString();

}

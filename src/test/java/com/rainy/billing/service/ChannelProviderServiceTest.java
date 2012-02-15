package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.ChannelProvider;
import com.rainy.billing.model.ChannelProviderVo;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-19
 * @author rainy
 * @version 1.0
 */
public class ChannelProviderServiceTest extends AbstractServiceTest {
	
	@Autowired
	private ChannelProviderService channelProviderService;
	
	private ChannelProvider createChannelProvider(){
		ChannelProvider channelProvider = new ChannelProvider();
		channelProvider.setName("test");
		
		channelProviderService.operateChannelProvider(channelProvider);
		return channelProvider;
	}
	
	@Test
	public void testGetChannelProviderById(){
		ChannelProvider channelProvider = channelProviderService.getChannelProviderById(createChannelProvider().getId());
		
		print("testGetChannelProviderById: channelProvider=" + channelProvider);
	}
	
	@Test
	public void testCreateChannelProvider(){
		ChannelProvider channelProvider = createChannelProvider();
		
		print("testCreateChannelProvider: channelProvider=" + channelProvider);
	}
	
	@Test
	public void testUpdateChannelProvider(){
		ChannelProvider channelProvider = createChannelProvider();
		channelProvider.setName("122121");
		channelProviderService.updateChannelProvider(channelProvider);
		
		print("testUpdateChannelProvider: channelProvider=" + channelProvider);
	}
	
	@Test
	public void testDeleteChannelProvider(){
		ChannelProvider channelProvider = createChannelProvider();
		channelProviderService.deleteChannelProvider(channelProvider.getId());
		
		print("testDeleteChannelProvider: id=" + channelProvider.getId());
	}
	
	@Test
	public void testQueryChannelProviderByName(){
		ChannelProvider channelProvider = createChannelProvider();
		List<ChannelProvider> list = channelProviderService.queryChannelProviderByName(channelProvider.getName());
		
		print("testQueryChannelProviderByName: size=" + list.size());
	}
	
	@Test
	public void testPageQueryChannelProvider(){
		ChannelProviderVo vo = new ChannelProviderVo();
		vo.setName(createChannelProvider().getName());
		List<ChannelProvider> list = channelProviderService.pageQueryChannelProvider(vo);
		
		print("testPageQueryChannelProvider: size=" + list.size());
	}
}

package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.IvrChannel;
import com.rainy.billing.model.IvrChannelVo;

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
public class IvrChannelServiceTest extends AbstractServiceTest {
	
	@Autowired
	private IvrChannelService ivrChannelService;
	
	private IvrChannel createIvrChannel(){
		IvrChannel ivrChannel = new IvrChannel();
		ivrChannel.setName("ivr_test");
		
		ivrChannelService.operateIvrChannel(ivrChannel);
		return ivrChannel;
	}
	
	@Test
	public void testGetIvrChannelById(){
		IvrChannel ivrChannel = ivrChannelService.getIvrChannelById(createIvrChannel().getId());
		
		print("testGetIvrChannelById: ivrChannel=" + ivrChannel);
	}
	
	@Test
	public void testCreateIvrChannel(){
		IvrChannel ivrChannel = createIvrChannel();
		
		print("testCreateIvrChannel: ivrChannel=" + ivrChannel);
	}
	
	@Test
	public void testUpdateIvrChannel(){
		IvrChannel ivrChannel = createIvrChannel();
		ivrChannel.setName("ivr_test_1");
		ivrChannelService.updateIvrChannel(ivrChannel);
		
		print("testUpdateIvrChannel: ivrChannel=" + ivrChannel);
	}
	
	@Test
	public void testDeleteIvrChannel(){
		IvrChannel ivrChannel = createIvrChannel();
		ivrChannelService.deleteIvrChannel(ivrChannel.getId());
		
		print("testDeleteIvrChannel: id=" + ivrChannel.getId());
	}
	
	@Test
	public void testQueryIvrChannelByName(){
		IvrChannel ivrChannel = createIvrChannel();
		List<IvrChannel> list = ivrChannelService.queryIvrChannelByName(ivrChannel.getName());
		
		print("testQueryIvrChannelByName: size=" + list.size());
	}
	
	@Test
	public void testPageQueryIvrChannel(){
		IvrChannelVo vo = new IvrChannelVo();
		vo.setName(createIvrChannel().getName());
		List<IvrChannel> list = ivrChannelService.pageQueryIvrChannel(vo);
		
		print("testPageQueryIvrChannel: size=" + list.size());
	}
}

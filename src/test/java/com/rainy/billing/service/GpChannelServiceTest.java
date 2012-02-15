package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.GpChannel;
import com.rainy.billing.model.GpChannelVo;

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
public class GpChannelServiceTest extends AbstractServiceTest {
	
	@Autowired
	private GpChannelService GpChannelService;
	
	private GpChannel createGpChannel(){
		GpChannel GpChannel = new GpChannel();
		GpChannel.setName("gp_test");
		
		GpChannelService.operateGpChannel(GpChannel);
		return GpChannel;
	}
	
	@Test
	public void testGetGpChannelById(){
		GpChannel GpChannel = GpChannelService.getGpChannelById(createGpChannel().getId());
		
		print("testGetGpChannelById: GpChannel=" + GpChannel);
	}
	
	@Test
	public void testCreateGpChannel(){
		GpChannel GpChannel = createGpChannel();
		
		print("testCreateGpChannel: GpChannel=" + GpChannel);
	}
	
	@Test
	public void testUpdateGpChannel(){
		GpChannel GpChannel = createGpChannel();
		GpChannel.setName("gp_test_1");
		GpChannelService.updateGpChannel(GpChannel);
		
		print("testUpdateGpChannel: GpChannel=" + GpChannel);
	}
	
	@Test
	public void testDeleteGpChannel(){
		GpChannel GpChannel = createGpChannel();
		GpChannelService.deleteGpChannel(GpChannel.getId());
		
		print("testDeleteGpChannel: id=" + GpChannel.getId());
	}
	
	@Test
	public void testQueryGpChannelByName(){
		GpChannel GpChannel = createGpChannel();
		List<GpChannel> list = GpChannelService.queryGpChannelByName(GpChannel.getName());
		
		print("testQueryGpChannelByName: size=" + list.size());
	}
	
	@Test
	public void testPageQueryGpChannel(){
		GpChannelVo vo = new GpChannelVo();
		vo.setName(createGpChannel().getName());
		List<GpChannel> list = GpChannelService.pageQueryGpChannel(vo);
		
		print("testPageQueryGpChannel: size=" + list.size());
	}
}

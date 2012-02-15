package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.SmsChannel;
import com.rainy.billing.enumeration.Carrier;
import com.rainy.billing.model.SmsChannelVo;

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
public class SmsChannelServiceTest extends AbstractServiceTest {
	
	@Autowired
	private SmsChannelService smsChannelService;
	
	private SmsChannel createSmsChannel(){
		SmsChannel smsChannel = new SmsChannel();
		smsChannel.setCarrier(Carrier.CMCC);
		
		smsChannelService.operateSmsChannel(smsChannel);
		return smsChannel;
	}
	
	@Test
	public void testGetSmsChannelById(){
		SmsChannel smsChannel = smsChannelService.getSmsChannelById(createSmsChannel().getId());
		
		print("testGetSmsChannelById: smsChannel=" + smsChannel);
	}
	
	@Test
	public void testCreateSmsChannel(){
		SmsChannel smsChannel = createSmsChannel();
		
		print("testCreateSmsChannel: smsChannel=" + smsChannel);
	}
	
	@Test
	public void testUpdateSmsChannel(){
		SmsChannel smsChannel = createSmsChannel();
		smsChannel.setCarrier(Carrier.CMCC);
		smsChannelService.updateSmsChannel(smsChannel);
		
		print("testUpdateSmsChannel: smsChannel=" + smsChannel);
	}
	
	@Test
	public void testDeleteSmsChannel(){
		SmsChannel smsChannel = createSmsChannel();
		smsChannelService.deleteSmsChannel(smsChannel.getId());
		
		print("testDeleteSmsChannel: id=" + smsChannel.getId());
	}
	
	@Test
	public void testQuerySmsChannelByCarrier(){
		SmsChannel smsChannel = createSmsChannel();
		List<SmsChannel> list = smsChannelService.querySmsChannelByCarrier(smsChannel.getCarrier());
		
		print("testQuerySmsChannelByCarrier: size=" + list.size());
	}
	
	@Test
	public void testPageQuerySmsChannel(){
		SmsChannelVo vo = new SmsChannelVo();
		vo.setCarrier(createSmsChannel().getCarrier());
		List<SmsChannel> list = smsChannelService.pageQuerySmsChannel(vo);
		
		print("testPageQuerySmsChannel: size=" + list.size());
	}
}

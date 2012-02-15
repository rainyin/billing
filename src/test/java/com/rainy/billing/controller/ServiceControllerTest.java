package com.rainy.billing.controller;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

import com.rainy.billing.model.service.CancelRequest;
import com.rainy.billing.model.service.ChanRequest;
import com.rainy.billing.model.service.McatRequest;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-12-7
 * @author rainy
 * @version 1.0
 */
public class ServiceControllerTest extends AbstractControllerTest {
	
	@Autowired
	private ServiceController serviceController;
	
	@Test
	public void testGetChannel() {
		ChanRequest channelRequest = new ChanRequest();
		
		channelRequest.setImsi("2121212");
		channelRequest.setProjectid("5000");
		channelRequest.setUid("201201040001000091");
		channelRequest.setVer("001");
		channelRequest.setPlmn("46000");
		channelRequest.setSc("0755");
		
		serviceController.getChannel(channelRequest, getResponse());
	}
	
	@Test
	public void testGetgjiacancel() {
		CancelRequest cancelRequest = new CancelRequest();
		cancelRequest.setImsi("2121212");
		cancelRequest.setProjectid("5000");
		cancelRequest.setVer("001");
		cancelRequest.setUid("001");
		cancelRequest.setPlmn("46000");
		cancelRequest.setSc("0755");
		
		serviceController.getgjiacancel(cancelRequest, getResponse());
	}
	
	@Test
	public void testGetUid() {
		try {
			serviceController.getUid(getWriter());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testgetAskSms() {
		try {
			MockHttpServletRequest request = getRequest();
			
			request.setContent(new String(" sms=你是谁").getBytes());
			
			serviceController.getAskSms(getResponse(), request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testM() {
		try {
			McatRequest mCatRequest = new McatRequest();
			
			mCatRequest.setSc("0755");
			mCatRequest.setFun("svn");
			mCatRequest.setP("5000");
			mCatRequest.setImsi("5000");
			mCatRequest.setPlmn("46000");
			mCatRequest.setPhone("13378659998");
			mCatRequest.setU("201112270001000241");
			mCatRequest.setVer("002");
			
			serviceController.mcat(mCatRequest, getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

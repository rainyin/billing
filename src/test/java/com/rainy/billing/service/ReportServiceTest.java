package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.model.report.ReportParameterVo;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-12-2
 * @author rainy
 * @version 1.0
 */
public class ReportServiceTest extends AbstractServiceTest {
	
	@Autowired
	private ReportService reportService;
	
	@Test
	public void testChannelReport() {
		String xml = reportService.smsChannelReport();
		print("xml: " + xml);
	}
	
	@Test
	public void testQueryTerminal() {
		ReportParameterVo vo = new ReportParameterVo();
		vo.setYear(2011);
		
		List<?> list = reportService.queryTerminal(vo).getDetails();
		print("testQueryTerminal size: " + list.size());
	}
	
	@Test
	public void testQueryTerminalByArea() {
		ReportParameterVo vo = new ReportParameterVo();
		vo.setYear(2011);
		
		List<?> list = reportService.queryTerminalByArea(vo).getDetails();
		print("testQueryTerminalByArea size: " + list.size());
	}
	
	@Test
	public void testQueryChannelRequest() {
		ReportParameterVo vo = new ReportParameterVo();
		vo.setYear(2011);
		
		List<?> list = reportService.queryChannelRequest(vo).getDetails();
		print("testQueryChannelRequest size: " + list.size());
	}

}

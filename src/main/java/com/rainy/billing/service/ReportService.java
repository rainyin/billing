package com.rainy.billing.service;

import com.rainy.billing.model.report.ReportData;
import com.rainy.billing.model.report.ReportParameterVo;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-12-2
 * @author rainy
 * @version 1.0
 */
public interface ReportService {

	String smsChannelReport();

	String ivrChannelReport();

	String gpChannelReport();
	
	ReportData queryTerminalByMonth(ReportParameterVo vo);
	
	ReportData queryTerminal(ReportParameterVo vo);
	
	ReportData queryTerminalByArea(ReportParameterVo vo);
	
	ReportData queryChannelRequest(ReportParameterVo vo);
	
	String terminalChart(ReportParameterVo vo);
	
	String terminalByAreaChart(ReportParameterVo vo);
	
	String channelRequestChart(ReportParameterVo vo);
	
	String projectToString(Long customerId);

}

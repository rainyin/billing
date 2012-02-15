package com.rainy.billing.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.model.report.ReportData;
import com.rainy.billing.model.report.ReportParameterVo;
import com.rainy.billing.service.ReportService;

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
@Controller
@RequestMapping("/report/")
public class ReportController extends BaseController {
	
	@Autowired
	private ReportService reportService;
	
	@RequestMapping(value = "channel")
	public void channel(Map<String, Object> model) {
	}
	
	@RequestMapping(value = "smsChannel")
	public void smsChannel(Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml;charset=GBK");
		String xml = reportService.smsChannelReport();
		try {
			response.getWriter().write(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "ivrChannel")
	public void ivrChannel(Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml;charset=GBK");
		String xml = reportService.ivrChannelReport();
		try {
			response.getWriter().write(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "gpChannel")
	public void gpChannel(Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml;charset=GBK");
		String xml = reportService.gpChannelReport();
		try {
			response.getWriter().write(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "projectToString")
	public void projectToString(Long customerId, Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml;charset=UTF-8");
		String xml = reportService.projectToString(customerId);
		
		try {
			response.getWriter().write(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "terminal")
	public void terminal() {
		
	}
	
	@RequestMapping(value = "terminalByArea")
	public void terminalByArea() {
	}
	
	@RequestMapping(value = "channelRequest")
	public void channelRequest() {

	}
	
	@RequestMapping(value = "terminalQuery")
	public String terminalQuery(Map<String, Object> model, ReportParameterVo vo) {
		ReportData data = reportService.queryTerminal(vo);
		
		model.put("data", data);
		return "/report/reportData";
	}
	
	@RequestMapping(value = "terminalByMonthQuery")
	public String terminalByMonthQuery(Map<String, Object> model, ReportParameterVo vo) {
		ReportData data = reportService.queryTerminalByMonth(vo);
		
		model.put("data", data);
		return "/report/reportData";
	}
	
	@RequestMapping(value = "terminalChart")
	public void terminalChart(Map<String, Object> model, ReportParameterVo vo, HttpServletResponse response) {
		response.setContentType("text/xml;charset=GBK");
		String xml = reportService.terminalChart(vo);
		try {
			response.getWriter().write(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "terminalByAreaQuery")
	public String terminalByAreaQuery(Map<String, Object> model, ReportParameterVo vo) {
		ReportData data = reportService.queryTerminalByArea(vo);
		
		model.put("data", data);
		return "/report/reportData";
	}
	
	@RequestMapping(value = "terminalByAreaChart")
	public void terminalByAreaChart(Map<String, Object> model, ReportParameterVo vo, HttpServletResponse response) {
		response.setContentType("text/xml;charset=GBK");
		String xml = reportService.terminalByAreaChart(vo);
		try {
			response.getWriter().write(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "channelRequestQuery")
	public String channelRequestQuery(Map<String, Object> model, ReportParameterVo vo) {
		ReportData data = reportService.queryChannelRequest(vo);
		model.put("data", data);
		
		return "/report/reportData";
	}
	
	@RequestMapping(value = "channelRequestChart")
	public void channelRequestChart(Map<String, Object> model, ReportParameterVo vo, HttpServletResponse response) {
		response.setContentType("text/xml;charset=GBK");
		String xml = reportService.channelRequestChart(vo);
		try {
			response.getWriter().write(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

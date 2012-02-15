package com.rainy.billing.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.entity.Area;
import com.rainy.billing.entity.SmsChannel;
import com.rainy.billing.model.SmsChannelVo;
import com.rainy.billing.pagination.PagerVo;
import com.rainy.billing.service.SmsChannelService;

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
@Controller
@RequestMapping("/smsChannel/")
public class SmsChannelController extends BaseController {
	
	@Autowired
	private SmsChannelService smsChannelService;
	
	@RequestMapping(value = "index")
	public void index(Map<String, Object> model) {
		
	}
	
	@RequestMapping(value = "list")
	public String list(SmsChannelVo vo, Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml");
		List<SmsChannel> list = smsChannelService.pageQuerySmsChannel(vo);
		PagerVo pagerVo = new PagerVo(vo, list);
		model.put("vo", pagerVo);
		
		return "pagination";
	}
	
	@RequestMapping(value = "queryArea")
	public String queryArea(Long nodeid, Long smsChannelId, Map<String, Object> model, HttpServletResponse response) {
		List<Area> list = smsChannelService.queryArea(nodeid, smsChannelId);
		model.put("list", list);
		
		response.setContentType("text/xml");
		return "/area/areaData";
	}
	
	@RequestMapping(value = "operate")
	public void operate(SmsChannel smsChannel, Map<String, Object> model, PrintWriter pw) {
		smsChannelService.operateSmsChannel(smsChannel);
		pw.write("operate success");
	}

	@RequestMapping(value = "associateArea")
	public void associateArea(Long smsChannelId, Long[] areaId, PrintWriter pw) {
		smsChannelService.associateArea(smsChannelId, areaId);
		pw.write("associateSmsChannel success");
	}
}

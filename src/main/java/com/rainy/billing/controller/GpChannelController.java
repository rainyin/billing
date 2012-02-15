package com.rainy.billing.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.entity.Area;
import com.rainy.billing.entity.GpChannel;
import com.rainy.billing.model.GpChannelVo;
import com.rainy.billing.pagination.PagerVo;
import com.rainy.billing.service.GpChannelService;

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
@RequestMapping("/gpChannel/")
public class GpChannelController extends BaseController {
	
	@Autowired
	private GpChannelService gpChannelService;
	
	@RequestMapping(value = "index")
	public void index(Map<String, Object> model) {
		
	}
	
	@RequestMapping(value = "list")
	public String list(GpChannelVo vo, Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml");
		List<GpChannel> list = gpChannelService.pageQueryGpChannel(vo);
		PagerVo pagerVo = new PagerVo(vo, list);
		model.put("vo", pagerVo);
		
		return "pagination";
	}
	
	@RequestMapping(value = "queryArea")
	public String queryArea(Long nodeid, Long gpChannelId, Map<String, Object> model, HttpServletResponse response) {
		List<Area> list = gpChannelService.queryArea(nodeid, gpChannelId);
		model.put("list", list);
		
		response.setContentType("text/xml");
		return "/area/areaData";
	}
	
	@RequestMapping(value = "operate")
	public void operate(GpChannel gpChannel, Map<String, Object> model, PrintWriter pw) {
		gpChannelService.operateGpChannel(gpChannel);
		pw.write("operate success");
	}

	@RequestMapping(value = "associateArea")
	public void associateArea(Long gpChannelId, Long[] areaId, PrintWriter pw) {
		gpChannelService.associateArea(gpChannelId, areaId);
		pw.write("associateGpChannel success");
	}
}

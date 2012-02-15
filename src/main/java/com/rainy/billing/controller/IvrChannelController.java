package com.rainy.billing.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.entity.Area;
import com.rainy.billing.entity.IvrChannel;
import com.rainy.billing.model.IvrChannelVo;
import com.rainy.billing.pagination.PagerVo;
import com.rainy.billing.service.IvrChannelService;

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
@RequestMapping("/ivrChannel/")
public class IvrChannelController extends BaseController {
	
	@Autowired
	private IvrChannelService ivrChannelService;
	
	@RequestMapping(value = "index")
	public void index(Map<String, Object> model) {
		
	}
	
	@RequestMapping(value = "list")
	public String list(IvrChannelVo vo, Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml");
		List<IvrChannel> list = ivrChannelService.pageQueryIvrChannel(vo);
		PagerVo pagerVo = new PagerVo(vo, list);
		model.put("vo", pagerVo);
		
		return "pagination";
	}
	
	@RequestMapping(value = "queryArea")
	public String queryArea(Long nodeid, Long ivrChannelId, Map<String, Object> model, HttpServletResponse response) {
		List<Area> list = ivrChannelService.queryArea(nodeid, ivrChannelId);
		model.put("list", list);
		
		response.setContentType("text/xml");
		return "/area/areaData";
	}
	
	@RequestMapping(value = "operate")
	public void operate(IvrChannel ivrChannel, Map<String, Object> model, PrintWriter pw) {
		ivrChannelService.operateIvrChannel(ivrChannel);
		pw.write("operate success");
	}

	@RequestMapping(value = "associateArea")
	public void associateArea(Long ivrChannelId, Long[] areaId, PrintWriter pw) {
		ivrChannelService.associateArea(ivrChannelId, areaId);
		pw.write("associateIvrChannel success");
	}
}

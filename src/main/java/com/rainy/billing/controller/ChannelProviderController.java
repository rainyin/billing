package com.rainy.billing.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.entity.ChannelProvider;
import com.rainy.billing.model.ChannelProviderVo;
import com.rainy.billing.pagination.PagerVo;
import com.rainy.billing.service.ChannelProviderService;

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
@RequestMapping("/channelProvider/")
public class ChannelProviderController extends BaseController {
	
	@Autowired
	private ChannelProviderService channelProviderService;
	
	@RequestMapping(value = "index")
	public void index(Map<String, Object> model) {
		
	}
	
	@RequestMapping(value = "list")
	public String list(ChannelProviderVo vo, Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml");
		List<ChannelProvider> list = channelProviderService.pageQueryChannelProvider(vo);
		PagerVo pagerVo = new PagerVo(vo, list);
		model.put("vo", pagerVo);
		
		return "pagination";

	}
	
	@RequestMapping(value = "operate")
	public void operate(ChannelProvider channelProvider, Map<String, Object> model, PrintWriter pw) {
		channelProviderService.operateChannelProvider(channelProvider);
		pw.write("operate success");
	}
	
	@RequestMapping(value = "allChannelProvider")
	public void allChannelProvider(PrintWriter pw) {
		pw.write(channelProviderService.allChannelProviderToString());
	}

}

package com.rainy.billing.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.entity.ChannelRequest;
import com.rainy.billing.model.ChannelRequestVo;
import com.rainy.billing.pagination.PagerVo;
import com.rainy.billing.service.ChannelRequestService;

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
@RequestMapping("/channelRequest/")
public class ChannelRequestController extends BaseController {
	
	@Autowired
	private ChannelRequestService channelRequestService;
	
	@RequestMapping(value = "index")
	public void index(Map<String, Object> model) {
		
	}
	
	@RequestMapping(value = "list")
	public String list(ChannelRequestVo vo, Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml");
		List<ChannelRequest> list = channelRequestService.pageQueryChannelRequest(vo);
		PagerVo pagerVo = new PagerVo(vo, list);
		model.put("vo", pagerVo);
		
		return "pagination";
	}

}

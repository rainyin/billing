package com.rainy.billing.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.entity.Terminal;
import com.rainy.billing.model.TerminalVo;
import com.rainy.billing.pagination.PagerVo;
import com.rainy.billing.service.TerminalService;

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
@RequestMapping("/terminal/")
public class TerminalController extends BaseController {
	
	@Autowired
	private TerminalService terminalService;
	
	@RequestMapping(value = "index")
	public void index(Map<String, Object> model) {
		
	}
	
	@RequestMapping(value = "list")
	public String list(TerminalVo vo, Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml");
		List<Terminal> list = terminalService.pageQueryTerminal(vo);
		PagerVo pagerVo = new PagerVo(vo, list);
		model.put("vo", pagerVo);
		
		return "pagination";
	}

}

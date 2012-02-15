package com.rainy.billing.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.entity.Resource;
import com.rainy.billing.model.ResourceVo;
import com.rainy.billing.pagination.PagerVo;
import com.rainy.billing.service.ResourceService;

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
@RequestMapping("/security/resource/")
public class ResourceController extends BaseController {
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping(value = "index")
	public void index(Map<String, Object> model) {
		
	}
	
	@RequestMapping(value = "list")
	public String list(ResourceVo vo, Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml");
		List<Resource> list = resourceService.pageQueryResource(vo);
		PagerVo pagerVo = new PagerVo(vo, list);
		model.put("vo", pagerVo);
		
		return "pagination";
	}
	
	@RequestMapping(value = "operate")
	public void operate(Resource resource, Map<String, Object> model, PrintWriter pw) {
		resourceService.operateResource(resource);
		pw.write("operate success");
	}

}

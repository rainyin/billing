package com.rainy.billing.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.entity.Right;
import com.rainy.billing.model.RightVo;
import com.rainy.billing.pagination.PagerVo;
import com.rainy.billing.service.RightService;

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
@RequestMapping("/security/right/")
public class RightController extends BaseController {
	
	@Autowired
	private RightService rightService;
	
	@RequestMapping(value = "index")
	public void index(Map<String, Object> model) {
		
	}
	
	@RequestMapping(value = "list")
	public String list(RightVo vo, Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml");
		List<Right> list = rightService.pageQueryRight(vo);
		PagerVo pagerVo = new PagerVo(vo, list);
		model.put("vo", pagerVo);
		
		return "pagination";
	}
	
	@RequestMapping(value = "operate")
	public void operate(Right right, Map<String, Object> model, PrintWriter pw) {
		rightService.operateRight(right);
		pw.write("operate success");
	}
	
	@RequestMapping(value = "allResource")
	public void allResource(Long rightId, PrintWriter pw) {
		pw.write(rightService.allResourceToString(rightId));
	}
	
	@RequestMapping(value = "associateResource")
	public void associateResource(Long rightId, Long[] resourceId, PrintWriter pw) {
		rightService.associateResource(rightId, resourceId);
		pw.write("associateResource success");
	}

}

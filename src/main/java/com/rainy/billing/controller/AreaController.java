package com.rainy.billing.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.entity.Area;
import com.rainy.billing.model.AreaVo;
import com.rainy.billing.service.AreaService;

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
@RequestMapping("/area/")
public class AreaController extends BaseController {
	
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value = "index")
	public void index(Map<String, Object> model) {
		
	}
	
	@RequestMapping(value = "list")
	public String list(AreaVo vo, Map<String, Object> model, HttpServletResponse response) {
		List<Area> list = areaService.queryArea(vo);
		model.put("list", list);

		response.setContentType("text/xml");
		return "/area/data";
	}
	
	@RequestMapping(value = "operate")
	public void operate(Area area, Map<String, Object> model, PrintWriter pw) {
		areaService.operateArea(area);
		pw.write("operate success");
	}

}

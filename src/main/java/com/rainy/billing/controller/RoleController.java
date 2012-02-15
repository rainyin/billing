package com.rainy.billing.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.entity.Role;
import com.rainy.billing.model.RoleVo;
import com.rainy.billing.pagination.PagerVo;
import com.rainy.billing.service.RoleService;

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
@RequestMapping("/security/role/")
public class RoleController extends BaseController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "index")
	public void index(Map<String, Object> model) {
		
	}
	
	@RequestMapping(value = "list")
	public String list(RoleVo vo, Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml");
		List<Role> list = roleService.pageQueryRole(vo);
		PagerVo pagerVo = new PagerVo(vo, list);
		model.put("vo", pagerVo);
		
		return "pagination";
	}
	
	@RequestMapping(value = "operate")
	public void operate(Role role, Map<String, Object> model, PrintWriter pw) {
		roleService.operateRole(role);
		pw.write("operate success");
	}
		
	@RequestMapping(value = "allRight")
	public void allRight(Long roleId, PrintWriter pw) {
		pw.write(roleService.allRightToString(roleId));
	}
	
	@RequestMapping(value = "associateRight")
	public void associateRight(Long roleId, Long[] rightId, PrintWriter pw) {
		roleService.associateRight(roleId, rightId);
		pw.write("associateRight success");
	}

}

package com.rainy.billing.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.entity.User;
import com.rainy.billing.model.UserVo;
import com.rainy.billing.pagination.PagerVo;
import com.rainy.billing.security.SecurityContext;
import com.rainy.billing.service.UserService;

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
@RequestMapping("/user/")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "index")
	public void index(Map<String, Object> model) {
		
	}
	
	@RequestMapping(value = "edit")
	public void edit(Map<String, Object> model) {
		model.put("user", SecurityContext.getCurrentUser());
	}
	
	@RequestMapping(value = "list")
	public String list(UserVo vo, Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml");
		List<User> list = userService.pageQueryUser(vo);
		PagerVo pagerVo = new PagerVo(vo, list);
		model.put("vo", pagerVo);
		
		return "pagination";
	}
	
	@RequestMapping(value = "operate")
	public void operate(User user, Map<String, Object> model, PrintWriter pw) {
		if(userService.usernameExist(user.getUsername(), user.getId())){
			pw.write("{exist:true}");
			return;
		}
		userService.operateUser(user);
		pw.write("{operate:\"success\"}");
	}
	
	@RequestMapping(value = "checkUsername")
	public void checkUsername(String username, Long id, Map<String, Object> model, PrintWriter pw) {
		Boolean exist = userService.usernameExist(username, id);
		if(exist) {
			pw.write("{\"exist\":true}");
		} else {
			pw.write("{\"exist\":false}");
		}
	}
	
	@RequestMapping(value = "allRole")
	public void allRole(PrintWriter pw) {
		pw.write(userService.allRoleToString());
	}
	
	@RequestMapping(value = "update")
	public void update(User user, String npassword, String opassword, PrintWriter pw) {
		if(userService.isInputPasswordRight(opassword)) {
			userService.updateUser(user, npassword);
			pw.write("{\"success\":true}");
		} else {
			pw.write("{\"success\":false, \"msg\": \"旧密码输入错误\"}");
		}
	}
	
	@RequestMapping(value = "resetPassword")
	public void resetPassword(Long userId, PrintWriter pw) {
		userService.resetPassword(userId);
		pw.write("{\"success\":true}");
	}

	@RequestMapping(value = "availableRole")
	public void availableRole(Long userId, PrintWriter pw) {
		pw.write(userService.allRoleToString(userId));
	}
	
	@RequestMapping(value = "associateRole")
	public void associateRole(Long userId, Long[] roleId, PrintWriter pw) {
		userService.associateRole(userId, roleId);
		pw.write("associateRole success");
	}
	
}

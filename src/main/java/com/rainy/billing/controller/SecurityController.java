package com.rainy.billing.controller;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.security.SecurityContext;
import com.rainy.billing.util.CookieUtil;
import com.rainy.billing.util.MenuUtil;
import com.rainy.billing.util.VerifyCodeUtil;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-28
 * @author rainy
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/security/")
public class SecurityController {
	
	private static Log log = LogFactory.getLog(SecurityController.class);
	
	@RequestMapping(value = "checkVerifyCode")
    public void checkVerifyCode(HttpServletRequest request,String username, String securityCode, Map<String,Object> model, PrintWriter pw) {
		HttpSession session=request.getSession(true);
		String code = String.valueOf(session.getAttribute("rand"));
		if(!code.equalsIgnoreCase(securityCode)){
			pw.write("{\"success\":false,\"msg\":\"验证码输入不正确\"}");
			return;
		} 
		pw.write("{\"success\":true,\"msg\":\"帐户正确\"}");
    }
	
	@RequestMapping(value = "login")
    public String login(HttpServletRequest request, Map<String,Object> model) {
		String password = CookieUtil.getPassword(request);
		Object username = request.getSession().getAttribute("SPRING_SECURITY_DECODE_USERNAME");
		if(username == null || username.toString().equals("")){
			username = CookieUtil.getUsername(request);
		}
		Boolean rememberMe = CookieUtil.getRememberMe(request);
		String error = request.getParameter("error");
		
		model.put("password", password);
		model.put("error", error);
		model.put("username", username);
		model.put("rememberMe", rememberMe);
		
		return "/security/loginForm";
    }
	
	@RequestMapping(value = "verifyCode")
    public void verifyCode(HttpServletRequest request,HttpServletResponse response,PrintWriter pw)throws IOException {
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		
		int width=80, height=20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graph = image.getGraphics();
		
		String code = VerifyCodeUtil.drawCode(graph, width, height);
		HttpSession session=request.getSession(true);
		session.setAttribute("rand", code);
		graph.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
    }
	
	@RequestMapping(value = "loginSuccess")
    public void loginSuccess(Map<String,Object> model) {
		model.put("user", SecurityContext.getCurrentUser());
		if(SecurityContext.getCurrentUser() != null) {
			model.put("menus", MenuUtil.getMenuFromRight(SecurityContext.getCurrentUser().getRights()));
		}
		log.debug("登录成功");
    }
	
	@RequestMapping(value = "logout")
    public String logout(Map<String,Object> model) {
		log.debug("注销成功");
        return "redirect:/j_spring_security_logout";
    }
	
	@RequestMapping(value = "denied")
    public void denied(Map<String,Object> model) {
		log.debug("没有权限");
    }

}

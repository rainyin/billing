package com.rainy.billing.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.model.service.CancelRequest;
import com.rainy.billing.model.service.ChanRequest;
import com.rainy.billing.model.service.McatRequest;
import com.rainy.billing.service.ServiceService;
import com.rainy.billing.util.StringUtil;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-27
 * @author rainy
 * @version 1.0
 */
@Controller
@RequestMapping("/server/")
public class ServiceController extends BaseController {
	
	@Autowired
	private ServiceService serviceService;
	
	/**
	 * 手机端通道请求
	 * @param chanRequest
	 * @param pw
	 */
	@RequestMapping("getprovider")
	public void getChannel(ChanRequest chanRequest, HttpServletResponse response){
		long aa = System.currentTimeMillis();
		response.setContentType("text/html;charset=utf-8");
		String result = serviceService.handleChannelRequest(chanRequest);
		
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		log.info("time cost========" + (System.currentTimeMillis() - aa)/1000.000F);
	}
	
	/**
	 * G+ 退订协议
	 * @param sms
	 * @param pw
	 */
	@RequestMapping("getgjiacancel")
	public void getgjiacancel(CancelRequest cancelRequest, HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		String result = serviceService.handleCancelRequest(cancelRequest);
		
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 短信猫数据请求
	 * @param pw
	 */
	@RequestMapping("getsmsnum")
	public void getSmsNum(HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		String result = serviceService.handleSmsNumRequest();
		
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 返回流水号
	 * @param sms
	 * @param pw
	 */
	@RequestMapping("getimsiserialno")
	public void getUid(PrintWriter pw){
		String result = serviceService.handleUidRequest();
		
		pw.write(result);
	}
	
	/**
	 * 智能答题服务
	 * @param sms
	 * @param pw
	 */
	@RequestMapping("getasksms")
	public void getAskSms(HttpServletResponse response, HttpServletRequest request){
		String content = StringUtil.getContentFromIns(request);
		log.info("request for getasksms, content: " + content);
		String sms = StringUtil.getParameter(content, "=");
		response.setContentType("text/html;charset=utf-8");
		String result = serviceService.handleAskSmsRequest(sms);
		
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 短信猫同步
	 * @param sms
	 * @param pw
	 */
	@RequestMapping("mcat")
	public void mcat(McatRequest mCatRequest, HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		String result = serviceService.handleMcatRequest(mCatRequest);
		
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

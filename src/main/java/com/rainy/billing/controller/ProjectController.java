package com.rainy.billing.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.entity.Project;
import com.rainy.billing.entity.ProjectSmsChannel;
import com.rainy.billing.entity.SmsChannel;
import com.rainy.billing.model.ProjectChannel;
import com.rainy.billing.model.ProjectVo;
import com.rainy.billing.pagination.PagerVo;
import com.rainy.billing.service.ProjectService;

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
@RequestMapping("/project/")
public class ProjectController extends BaseController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "index")
	public void index(Map<String, Object> model) {
		
	}
	
	@RequestMapping(value = "assoSmsChannel")
	public void assoSmsChannel(Map<String, Object> model) {
		
	}
	
	@RequestMapping(value = "getAssociateSmsChannel")
	public String getAssociateSmsChannel(Long projectId, String businessName, Map<String, Object> model) {
		List<SmsChannel> list = projectService.getAssociateSmsChannel(projectId, businessName);
		model.put("list", list);
		
		return "/project/smsChannel";
	}
	
	@RequestMapping(value = "getAvaibleSmsChannel")
	public String getAvaibleSmsChannel(Long projectId, String businessName, Map<String, Object> model) {
		List<SmsChannel> list = projectService.getAvailableSmsChannel(projectId, businessName);
		model.put("list", list);
		
		return "/project/smsChannel";
	}
	
	@RequestMapping(value = "list")
	public String list(ProjectVo vo, Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml");
		List<Project> list = projectService.pageQueryProject(vo);
		PagerVo pagerVo = new PagerVo(vo, list);
		model.put("vo", pagerVo);
		
		return "pagination";
	}
	
	@RequestMapping(value = "operate")
	public void operate(Project project, Map<String, Object> model, PrintWriter pw) {
		projectService.operateProject(project);
		pw.write("operate success");
	}
	
	@RequestMapping(value = "allCustomer")
	public void allCustomer(PrintWriter pw) {
		pw.write(projectService.allCustomerToString());
	}
	
	@RequestMapping(value = "channelOfProject")
	public String channelOfProject(Long id, Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml");
		List<ProjectChannel> list = ProjectChannel.generateList(projectService.getProjectWithChannelById(id));
		model.put("list", list);
		
		return "/project/channelOfProject";
	}
	
	@RequestMapping(value = "allSmsChannel")
	public void allSmsChannel(Long projectId, PrintWriter pw) {
		pw.write(projectService.allSmsChannelToString(projectId));
	}
	
	@RequestMapping(value = "allIvrChannel")
	public void allIvrChannel(Long projectId, PrintWriter pw) {
		pw.write(projectService.allIvrChannelToString(projectId));
	}
	
	@RequestMapping(value = "allGpChannel")
	public void allGpChannel(Long projectId, PrintWriter pw) {
		pw.write(projectService.allGpChannelToString(projectId));
	}
	
	@RequestMapping(value = "associateSmsChannel")
	public void associateSmsChannel(Long projectId, Long[] smsChannelId, PrintWriter pw) {
		projectService.associateSmsChannel(projectId, smsChannelId);
		pw.write("associateChannel success");
	}
	
	@RequestMapping(value = "associateSms")
	public void associateSms(Long projectId, Long[] smsChannelId, PrintWriter pw) {
		projectService.associateSms(projectId, smsChannelId);
		pw.write("associateChannel success");
	}
	
	@RequestMapping(value = "deAssociateSms")
	public void deAssociateSms(Long projectId, Long[] smsChannelId, PrintWriter pw) {
		projectService.deAssociateSms(projectId, smsChannelId);
		pw.write("associateChannel success");
	}
	
	@RequestMapping(value = "updateSendTimes")
	public void updateSendTimes(ProjectSmsChannel projectSms, PrintWriter pw) {
		projectService.updateAssociationWithSms(projectSms);
		pw.write("update sendTimes success");
	}
	
	@RequestMapping(value = "associateIvrChannel")
	public void associateIvrChannel(Long projectId, Long[] ivrChannelId, PrintWriter pw) {
		projectService.associateIvrChannel(projectId, ivrChannelId);
		pw.write("associateIvrChannel success");
	}
	
	@RequestMapping(value = "associateGpChannel")
	public void associateGpChannel(Long projectId, Long[] gpChannelId, PrintWriter pw) {
		projectService.associateGpChannel(projectId, gpChannelId);
		pw.write("associateGpChannel success");
	}

}

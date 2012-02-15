package com.rainy.billing.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rainy.billing.entity.Question;
import com.rainy.billing.model.QuestionVo;
import com.rainy.billing.pagination.PagerVo;
import com.rainy.billing.service.QuestionService;

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
@RequestMapping("/question/")
public class QuestionController extends BaseController {
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "index")
	public void index(Map<String, Object> model) {
		
	}
	
	@RequestMapping(value = "list")
	public String list(QuestionVo vo, Map<String, Object> model, HttpServletResponse response) {
		response.setContentType("text/xml");
		List<Question> list = questionService.pageQueryQuestion(vo);
		PagerVo pagerVo = new PagerVo(vo, list);
		model.put("vo", pagerVo);
		
		return "pagination";
	}
	
	@RequestMapping(value = "operate")
	public void operate(Question question, Map<String, Object> model, PrintWriter pw) {
		questionService.operateQuestion(question);
		pw.write("operate success");
	}

}

package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.Question;
import com.rainy.billing.model.QuestionVo;

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
public class QuestionServiceTest extends AbstractServiceTest {
	
	@Autowired
	private QuestionService questionService;
	
	private Question createQuestion(){
		Question question = new Question();
		question.setContent("test");
		question.setAnswer("test");
		
		questionService.operateQuestion(question);
		return question;
	}
	
	@Test
	public void testGetQuestionById(){
		Question question = questionService.getQuestionById(createQuestion().getId());
		
		print("testGetQuestionById: question=" + question);
	}
	
	@Test
	public void testCreateQuestion(){
		Question question = createQuestion();
		
		print("testCreateQuestion: question=" + question);
	}
	
	@Test
	public void testUpdateQuestion(){
		Question question = createQuestion();
		question.setContent("122121");
		questionService.updateQuestion(question);
		
		print("testUpdateQuestion: question=" + question);
	}
	
	@Test
	public void testDeleteQuestion(){
		Question question = createQuestion();
		questionService.deleteQuestion(question.getId());
		
		print("testDeleteQuestion: id=" + question.getId());
	}
	
	@Test
	public void testPageQueryQuestion(){
		QuestionVo vo = new QuestionVo();
		vo.setContent(createQuestion().getContent());
		List<Question> list = questionService.pageQueryQuestion(vo);
		
		print("testPageQueryQuestion: size=" + list.size());
	}
}

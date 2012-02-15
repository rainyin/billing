package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.Question;
import com.rainy.billing.model.QuestionVo;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-23
 * @author rainy
 * @version 1.0
 */
public interface QuestionService {
	
    Question getQuestionById(Long id);
	
	void operateQuestion(Question question);
	
	void updateQuestion(Question question);
	
	void deleteQuestion(Long... id);
	
	List<Question> pageQueryQuestion(QuestionVo vo);

}

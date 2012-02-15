package com.rainy.billing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.dao.QuestionDao;
import com.rainy.billing.entity.Question;
import com.rainy.billing.model.QuestionVo;
import com.rainy.billing.service.QuestionService;

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
@Service
public class QuestionServiceImpl extends BaseService implements QuestionService {

	@Autowired
	private QuestionDao questionDao;

	@Override
	public void deleteQuestion(Long... id) {
		if (id != null && id.length == 1) {
			questionDao.deleteEntityById(id[0]);
		} else if(id != null){
			questionDao.deleteEntityBatch(id);
		} else {
			log.warn("delete question by null id");
		}
		log.debug("delete question success: id = " + id);
	}

	@Override
	public Question getQuestionById(Long id) {
		if (id != null) {
			return questionDao.getEntityById(id);
		}
		log.warn("get question by null id");
		return null;
	}

	@Override
	public void updateQuestion(Question question) {
		questionDao.updateEntity(question);
		log.debug("update question success: id=" + question.getId());
	}

	@Override
	public void operateQuestion(Question question) {
		if(question.getPager().isToUpdate()) {
			questionDao.updateEntity(question);
			log.debug("update question success: id=" + question.getId());
		} else if(question.getPager().isToCreate()){
			questionDao.createEntity(question);
			log.debug("create question success: id=" + question.getId());
		} else {
			questionDao.deleteEntityById(question.getId());
			log.debug("delete question success: id=" + question.getId());
		}
	}

	@Override
	public List<Question> pageQueryQuestion(QuestionVo vo) {
		return questionDao.pageQueryEntity(vo);
	}
}

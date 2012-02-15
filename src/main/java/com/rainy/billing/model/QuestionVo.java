package com.rainy.billing.model;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-23
 * @author rainy
 * @version 1.0
 */
public class QuestionVo extends BaseVo {

	private String content;
	private String answer;

	private static final String[] orderColumns = { "id", "content", "answer",
			"createdAt" };

	@Override
	public String[] getOrderColumns() {
		return orderColumns;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}

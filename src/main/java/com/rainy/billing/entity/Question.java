package com.rainy.billing.entity;

import com.rainy.billing.pagination.Pageable;
import com.rainy.billing.pagination.RowData;
import com.rainy.billing.util.PaginationUtil;

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
@SuppressWarnings("serial")
public class Question extends BaseEntity implements Pageable {

	private String content;
	private String answer;
	
	public Question() {
	}
	
	public Question(String content) {
		this.content = content;
	}

	@Override
	public RowData toRow() {
		RowData row = new RowData();

		row.setId(this.getId().toString());
		row.setCell(PaginationUtil.createCell(getId(), content, answer,
				getCreatedAtString()));

		return row;
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

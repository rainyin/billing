package com.rainy.billing.entity;

import java.io.Serializable;
import java.util.Date;

import com.rainy.billing.Constant;
import com.rainy.billing.pagination.Pager;
import com.rainy.billing.util.DateUtil;

/**
 * 
 * Title: <br>
 * Description: 所有entity基类，通用字段定义 Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-18
 * @author rainy
 * @version 1.0
 */
@SuppressWarnings("serial")
public class BaseEntity implements Serializable {
	
	private Long id = Constant.INITIAL_ID;
	private Date createdAt;
	private Date updatedAt;
	private Long operatorId = Constant.INITIAL_ID;
	
	private Pager pager;

	BaseEntity(){
		pager = new Pager();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if(id == null) return;
		this.id = id;
	}
	
	public Boolean isInDB(){
		if(id.longValue() == Constant.INITIAL_ID.longValue()) return false;
		return true;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	
	public String getCreatedAtString() {
		return DateUtil.formatDateTime(createdAt);
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public String getUpdatedAtString() {
		return DateUtil.formatDateTime(updatedAt);
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	

	public Pager getPager() {
		return pager;
	}

	public void setOper(String oper) {
		this.pager.setOper(oper);
	}

}

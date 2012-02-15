package com.rainy.billing.model.report;

import java.util.Calendar;

import com.rainy.billing.model.BaseVo;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-12-12
 * @author rainy
 * @version 1.0
 */
public class ReportParameterVo extends BaseVo {

	private static final String[] orderColumns = { "yearMonth", "date", "count" };

	private Integer year;
	private Integer month = Calendar.getInstance().get(Calendar.MONTH) + 1;
	private Long projectId;

	@Override
	public String[] getOrderColumns() {
		return orderColumns;
	}

	public Integer getYear() {
		return year;
	}
	
	public Integer getYearNotNull() {
		return year == null ? Calendar.getInstance().get(Calendar.YEAR) : year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}
	
	public Integer getMonthNotNull() {
		return month == null ? Calendar.getInstance().get(Calendar.MONTH) + 1 : month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

}

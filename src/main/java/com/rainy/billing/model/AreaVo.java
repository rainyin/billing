package com.rainy.billing.model;

import com.rainy.billing.Constant;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-26
 * @author rainy
 * @version 1.0
 */
public class AreaVo extends BaseVo {

	private static final String[] orderColumns = { "id", "name", "cm_code",
			"cu_code" };

	private String name;
	private String cmCode;
	private String cuCode;
	private Long parentId = Constant.INITIAL_ID;

	@Override
	public String[] getOrderColumns() {
		return orderColumns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public void setNodeid(Long nodeid) {
		this.parentId = nodeid;
	}

	public String getCmCode() {
		return cmCode;
	}

	public void setCmCode(String cmCode) {
		this.cmCode = cmCode;
	}

	public String getCuCode() {
		return cuCode;
	}

	public void setCuCode(String cuCode) {
		this.cuCode = cuCode;
	}

}

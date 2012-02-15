package com.rainy.billing.model;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-10-30
 * @author rainy
 * @version 1.0
 */
public class RoleVo extends BaseVo {

	private static final String[] orderColumns = { "id", "name", "memo" };

	private String name; // 角色名称
	private String memo; // 角色描述

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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}

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
public class ResourceVo extends BaseVo {

	private static final String[] orderColumns = { "id", "name", "value" };

	private String name; // 资源名称
	private String value; // 资源路径 多为url方式

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

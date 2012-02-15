package com.rainy.billing.enumeration;

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
public enum AreaLevel {
	
	ONE("ONE"), TWO("TWO"), THREE("THREE");

	private String value;

	private AreaLevel(String value) {
		this.value = value;
	}

	public String getValue() {
		return name();
	}

	@Override
	public String toString() {
		return value;
	}

	public String getInfo() {
		switch (this) {
		case ONE:
			return "一级";
		case TWO:
			return "二级";
		case THREE:
			return "三级";
		default:
			return "";
		}
	}
}

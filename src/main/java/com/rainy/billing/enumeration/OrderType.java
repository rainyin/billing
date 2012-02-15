package com.rainy.billing.enumeration;

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
public enum OrderType {

	MONTHLY("MONTHLY"), ONDEMAND("ONDEMAND");

	private String value;

	private OrderType(String value) {
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
		case MONTHLY:
			return "包月";
		case ONDEMAND:
			return "点播";
		default:
			return "";
		}
	}

}

package com.rainy.billing.enumeration;

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
public enum MatchType {
	
	PRECISE("PRECISE"), FUZZY("FUZZY");

	private String value;

	private MatchType(String value) {
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
		case PRECISE:
			return "精确匹配";
		case FUZZY:
			return "模糊匹配";
		default:
			return "";
		}
	}
	
	public String getVal() {
		switch (this) {
		case PRECISE:
			return "0";
		case FUZZY:
			return "1";
		default:
			return "";
		}
	}

}

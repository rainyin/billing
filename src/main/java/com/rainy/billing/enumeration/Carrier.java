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
public enum Carrier {
	
	CMCC("CMCC"), CUCC("CUCC"), CTC("CTC");

	private String value;

	private Carrier(String value) {
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
		case CMCC:
			return "中国移动";
		case CUCC:
			return "中国联通";
		case CTC:
			return "中国电信";
		default:
			return "";
		}
	}
}

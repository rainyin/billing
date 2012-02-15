package com.rainy.billing.enumeration;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-21
 * @author rainy
 * @version 1.0
 */
public enum ProjectStatus {
	
	FORMAL("FORMAL"),TEST("TEST");
	
	private String value;
	
	private ProjectStatus(String value) {
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
        case FORMAL:
        	return "商用";
        case TEST:
        	return "测试";
        default:
            return "";
        }
	}

}

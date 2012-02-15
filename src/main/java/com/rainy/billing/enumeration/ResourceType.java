package com.rainy.billing.enumeration;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-30
 * @author rainy
 * @version 1.0
 */
public enum ResourceType {
	
    URL("URL"),       //URL地址
    METHOD("METHOD"), //方法
    MENU("MENU");     //菜单

    private String value;

    private ResourceType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}

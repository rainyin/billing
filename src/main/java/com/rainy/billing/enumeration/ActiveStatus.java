package com.rainy.billing.enumeration;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-29
 * @author rainy
 * @version 1.0
 */
public enum ActiveStatus {
	
    ENABLED("ENABLED"), // 有效
    DISABLED("DISABLED"); // 无效

    private String value;

    private ActiveStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
    
    public String getInfo() {
        switch(this) {
        case ENABLED: return "已启用"; 
        case DISABLED: return "已停用";
        }
        return "";
    }
}

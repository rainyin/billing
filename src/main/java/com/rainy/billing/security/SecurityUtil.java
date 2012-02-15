package com.rainy.billing.security;

import com.rainy.billing.entity.User;

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
public class SecurityUtil {

	public static Boolean isGrantedRight(String... rights) {
		User user = SecurityContext.getCurrentUser();
		if(user == null) return false;


		return false;
	}

	public static Boolean isGrantedRole(String... roles) {
		User user = SecurityContext.getCurrentUser();
		if(user == null) return false;


		return false;
	}

	public static Boolean isCorporationAdmin() {
		User user = SecurityContext.getCurrentUser();
		if(user == null) return false;

		return false;
	}

	public static Boolean isSuperAdmin() {
		User user = SecurityContext.getCurrentUser();
		if(user == null) return false;
		
		return false;
	}

}

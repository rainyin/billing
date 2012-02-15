package com.rainy.billing.util;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * Title: <br>
 * Description: <br>
 * Project:  elgt2.0<br>
 * Company: Finalist IT Group <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-9-23
 * @author rainy
 * @version 2.0
 */
public class EncryptionUtil {
	
	public static String encrypePassword(String username, String password) {
		Md5PasswordEncoder passEncoder = new Md5PasswordEncoder();
		return passEncoder.encodePassword(password, username);
	}

}

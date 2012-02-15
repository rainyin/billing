package com.rainy.billing;

import java.util.regex.Pattern;

import org.springframework.security.web.util.RegexUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

import com.rainy.billing.util.EncryptionUtil;
import com.rainy.billing.util.StringUtil;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-10-31
 * @author rainy
 * @version 1.0
 */
public class Test {
	
	public static void main(String[] args) {
		UrlMatcher urlMatcher = new RegexUrlPathMatcher();
		String resURL = "/customer/.*";
		String url = "/customer/list.do";
		
		Pattern pattern = Pattern.compile(resURL, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        if (urlMatcher.pathMatchesUrl(pattern, url)) {
        	System.out.println("match true");
        }
        System.out.println("match false");
        
        String pass = EncryptionUtil.encrypePassword("admin", Constant.INITIAL_PASSWD);
        System.out.println("pass==========" + pass);
        
        String unicodeStr = StringUtil.toUnicode("!=%下行屏蔽2@|回复任意~啊|回复是否~是|业务@|定制@|退订@|10666655555@");
        
        System.out.println("unicode========" + unicodeStr);
        
        System.out.println("deunicode========" + StringUtil.fromUnicode(unicodeStr));
        
        
        
	}
	
	

}

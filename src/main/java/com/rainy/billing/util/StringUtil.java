package com.rainy.billing.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-11-21
 * @author rainy
 * @version 1.0
 */
public class StringUtil {
	
	public static String getContentFromIns(HttpServletRequest request) {
		StringBuilder content = new StringBuilder();
		String tmp;
		BufferedReader ins = null;
		
		try {
			ins = new BufferedReader(new InputStreamReader(request.getInputStream()));
			
			while((tmp = ins.readLine()) != null){
				content.append(tmp);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ins.close();
			} catch(Exception ee) {
				ee.printStackTrace();
			}
		}
		
		return content.toString().trim();
	}
	
	public static String getParameter(String content, String delimiter) {
		if(content != null && delimiter != null && content.indexOf(delimiter) >= 0) {
			String[] data = content.split(delimiter);
			if(data.length > 1) {
				return data[1];
			}
		}
		return null;
	}

	public static String convertBoolean(Boolean value) {
		if (value)
			return "1";
		return "0";
	}

	public static String addZero(String str, int fixLength) {
		StringBuilder newStr = new StringBuilder();
		for (int i = 0; i < fixLength - str.length(); i++) {
			newStr.append("0");
		}

		newStr.append(str);
		return newStr.toString();
	}
	
	private static Boolean isToTranform(byte a, byte b) {
		if(a != 0 || b==61 || b==38 || b==37) return true;
		return false;
	}

	private static String toHexString(int ch) {
		StringBuilder tmp = new StringBuilder();
		String str = Integer.toHexString(ch & 0xff);
		for (int j = str.length(); j < 2; j++) {
			tmp.append("0");
		}
		tmp.append(str);

		return tmp.toString();
	}
	
	private static boolean isNotAscii(byte a, byte b) {
		if(a != 0) {
            return true;
        }
		return false;
	}

	public static String toUnicode(String s) {
		if(!isNotBlank(s)) {
			return "";
		}
		try {
			StringBuffer out = new StringBuffer("");
			byte[] bytes = s.getBytes("unicode");
			for (int i = 2; i < bytes.length - 1; i += 2) {	
				if(isToTranform(bytes[i], bytes[i + 1])) {
					out.append("%");
					if(isNotAscii(bytes[i], bytes[i + 1])) {
						out.append("u");
						out.append(toHexString(bytes[i]));
					} 
					out.append(toHexString(bytes[i + 1]));
				} else {
					out.append((char)bytes[i + 1]);
				}
			}
			return out.toString().toLowerCase();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String fromUnicode(String unicodeStr) {
		if(unicodeStr == null || unicodeStr.length() == 0) return null;
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < unicodeStr.length() ;) {
			char ch1 = unicodeStr.charAt(i);
			char ch2 = 'A';
			if(i < unicodeStr.length() - 1) {
				ch2 = unicodeStr.charAt(i + 1);
			}
			if(ch1 == '%' && ch2 != 'u' && ch2 != 'U') {
				char c = (char) Integer.parseInt(unicodeStr.substring(i + 1, i + 3), 16);
				sb.append(c);
				i += 3;
				continue;
			} 
			if(ch1 == '%' && ch2 == 'u') {
				char c = (char) Integer.parseInt(unicodeStr.substring(i + 2, i + 6), 16);
				sb.append(c);
				i += 6;
				continue;
			}
			sb.append(ch1);
			i += 1;
		}

		return sb.toString();
	}
	
	public static Boolean isNotBlank(String str) {
		if(str != null && str.trim().length() > 0) return true;
		return false;
	}
	
	public static String fullMonth(int month) {
		String m = String.valueOf(month);
		if(m.length() == 1) return 0 + m;
		return m;
	}

}

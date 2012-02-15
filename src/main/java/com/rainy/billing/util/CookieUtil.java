package com.rainy.billing.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class CookieUtil {

    public static void saveUserInfoToCookie(String username, String password, Boolean remember, HttpServletResponse response) {
        Cookie usernameCookie = new Cookie("username",username);
        Cookie passwordCookie = new Cookie("password",Base64Util.encode(encryptAndDeEncrypt(password)));
        Cookie rememberCookie = new Cookie("remember",remember?"true":"false");
        int time = 2*7*24*60;       //默认保存两周
        usernameCookie.setMaxAge(time);
        rememberCookie.setMaxAge(time);
        if (!remember) {
            time = 0;
        } 
        passwordCookie.setMaxAge(time);
        
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);
        response.addCookie(rememberCookie);
    }
    
    /**
     * 做一些简单的亦或加密
     * @param value
     * @return
     */
    private static String encryptAndDeEncrypt(String value) {
        byte[] chars = value.getBytes();
        for (int i =0 ; i< chars.length;i++) {
            chars[i] = (byte)(chars[i]^0x12345);
        }
        String result = new String(chars);
        return result;      
    }
    
    public static String getPassword(HttpServletRequest request) {
    	String password = getValue(request, "password");
    	if(!password.equals("")){
    		return encryptAndDeEncrypt(Base64Util.decode(password));
    	}
    	return password;
    }
    
    public static String getUsername(HttpServletRequest request) {
    	return getValue(request, "username");
    }
    
    public static Boolean getRememberMe(HttpServletRequest request) {
    	String remember = getValue(request, "remember");
    	return Boolean.valueOf(remember);
    }
    
    private static String getValue(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) return "";
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(name) && StringUtils.isNotBlank(cookie.getValue())) {
                String value = cookie.getValue();
                return value;
            }
        }
        return "";
    }
}

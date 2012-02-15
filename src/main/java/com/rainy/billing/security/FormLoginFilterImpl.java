package com.rainy.billing.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.TextEscapeUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.rainy.billing.util.Base64Util;
import com.rainy.billing.util.CookieUtil;

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
public class FormLoginFilterImpl extends UsernamePasswordAuthenticationFilter {

    private static final String SPRING_SECURITY_DECODE_USERNAME = "SPRING_SECURITY_DECODE_USERNAME";
    private String authenticationFailureUrl;
    private String defaultTargetUrl;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String failureUrl = authenticationFailureUrl;
        String successUrl = defaultTargetUrl;
        
        super.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler(failureUrl));
        super.setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler(successUrl));
        
        String username = Base64Util.decode(ServletRequestUtils.getStringParameter(request, "j_username", "").trim());
        request.getSession().setAttribute(SPRING_SECURITY_DECODE_USERNAME, username);
        
        String password = Base64Util.decode(ServletRequestUtils.getStringParameter(request, "j_password",""));
        boolean remembeMe = ServletRequestUtils.getBooleanParameter(request, "_spring_security_remember_me",false);
        
        Authentication result = doAuthentication(request, username, password);
        if (result.isAuthenticated()) {
            CookieUtil.saveUserInfoToCookie(username, password, remembeMe, response);
        }
        
        return result;
    }
    
    public Authentication doAuthentication(HttpServletRequest request, String username, String password){
    	if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        HttpSession session = request.getSession(false);

        if (session != null || getAllowSessionCreation()) {
            request.getSession().setAttribute(SPRING_SECURITY_LAST_USERNAME_KEY, TextEscapeUtils.escapeEntities(username));
        }

        super.setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
    
    public String getAuthenticationFailureUrl() {
        return authenticationFailureUrl;
    }

    public void setAuthenticationFailureUrl(String authenticationFailureUrl) {
        this.authenticationFailureUrl = authenticationFailureUrl;
    }

	public String getDefaultTargetUrl() {
		return defaultTargetUrl;
	}

	public void setDefaultTargetUrl(String defaultTargetUrl) {
		this.defaultTargetUrl = defaultTargetUrl;
	}

}

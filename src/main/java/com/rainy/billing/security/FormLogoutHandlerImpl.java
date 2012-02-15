/**
 * 
 */
package com.rainy.billing.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

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
public class FormLogoutHandlerImpl extends SecurityContextLogoutHandler {

    @Override
    public boolean isInvalidateHttpSession() {
        return true;
    }

    @Override
    public void setInvalidateHttpSession(boolean invalidateHttpSession) {
        super.setInvalidateHttpSession(true);
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        request.getSession().invalidate();
    }
    
}

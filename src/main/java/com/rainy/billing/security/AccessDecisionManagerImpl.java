package com.rainy.billing.security;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

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
public class AccessDecisionManagerImpl implements AccessDecisionManager {

    private static Log log = LogFactory.getLog(AccessDecisionManagerImpl.class);
    
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) throws AccessDeniedException, InsufficientAuthenticationException {
    	User user = SecurityContext.getCurrentUser();
        if (user == null) {
            String message = "The user is not logged in!";
            log.info(message);
            throw new AccessDeniedException(message);
        }
        if (attributes == null) {
            return;
        }
        for (ConfigAttribute attribute : attributes) {
            String right = ((SecurityConfig) attribute).getAttribute();
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (right.equals(ga.getAuthority())) {
                    return;
                }
            }
        }
        String message = "User " + user.getUsername() + " no right to access!";
        log.info(message);
        throw new AccessDeniedException(message);
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}

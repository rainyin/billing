package com.rainy.billing.security;

import org.springframework.security.core.context.SecurityContextHolder;

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
public class SecurityContext {
    
    public static User getCurrentUser() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof User) {
            return (User) obj;
        } 
        return null;
    }
}

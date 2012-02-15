package com.rainy.billing.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.RegexUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

import com.rainy.billing.model.ResourceRight;
import com.rainy.billing.service.ResourceService;
import com.rainy.billing.util.DateUtil;

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
public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource, InitializingBean {
	
	private static Log log = LogFactory.getLog(FilterInvocationSecurityMetadataSourceImpl.class);
	
	@Autowired
	private ResourceService resourceService;

	private UrlMatcher urlMatcher = new RegexUrlPathMatcher();

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
    private static Date cacheDate = null;

    public FilterInvocationSecurityMetadataSourceImpl() {
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        loadResourceDefine();
        String url = removeParameterOfUrl(((FilterInvocation) object).getRequestUrl());
        log.info("url: " + url);
        for (String resURL : resourceMap.keySet()) {
            Pattern pattern = Pattern.compile(resURL, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
            if (urlMatcher.pathMatchesUrl(pattern, url)) {
            	return resourceMap.get(resURL);
            }
        }
        return null;
    }
    
    private String removeParameterOfUrl(String url){
    	String[] urls = url.split("\\?");
    	return urls[0];
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }

    private void loadResourceDefine() {
        if (resourceMap == null) {
            resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        } else {
            if (cacheDate != null) {
                if (DateUtil.betweenMinute(cacheDate, 30)){
                    return;
                }
            }
        }
        List<ResourceRight> resourceRights = resourceService.queryResourceRight();
        for (ResourceRight rr : resourceRights) {
            Collection<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();
            attributes.add(new SecurityConfig(rr.getRightName())); 
            Collection<ConfigAttribute> ca = resourceMap.get(rr.getResourceUrl());
            if (ca != null) {
                attributes.addAll(ca);
            } 
            resourceMap.put(rr.getResourceUrl(), attributes);
        }
        
        for(String key : resourceMap.keySet()) {
        	log.info("res======" + key);
        }
        
        cacheDate = new Date();
    }
}

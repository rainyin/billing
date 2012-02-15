package com.rainy.billing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.Constant;
import com.rainy.billing.dao.AreaDao;
import com.rainy.billing.entity.Area;
import com.rainy.billing.entity.User;
import com.rainy.billing.security.SecurityContext;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-18
 * @author rainy
 * @version 1.0
 */
public class BaseService {
	
	protected Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private AreaDao areaDao;
	
	public void updateUser(User updatedUser) {
		if(SecurityContext.getCurrentUser() != null && updatedUser != null) {
			SecurityContext.getCurrentUser().setName(updatedUser.getName());
			SecurityContext.getCurrentUser().setAddress(updatedUser.getAddress());
			SecurityContext.getCurrentUser().setEmail(updatedUser.getEmail());
			SecurityContext.getCurrentUser().setTel(updatedUser.getTel());
			SecurityContext.getCurrentUser().setMemo(updatedUser.getMemo());
			SecurityContext.getCurrentUser().setPassword(updatedUser.getPassword());
		}
	}
	
	public Long getOperatorId() {
		if(SecurityContext.getCurrentUser() != null) {
			return SecurityContext.getCurrentUser().getId();
		}
		
		return Constant.INITIAL_ID;
	}
	
	public Long[] fillChildArea(Long[] parents) {
		if(parents == null || parents.length == 0) return null;
		
		List<Long> all = new ArrayList<Long>();
		
		for(Long parent : parents) {
			all.add(parent);
		}
		List<Area> children = areaDao.queryEntityOfParent(parents);
		for(Area area : children) {
			all.add(area.getId());
		}
		
		return all.toArray(new Long[]{});
	}
	
}

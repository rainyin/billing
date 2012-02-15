package com.rainy.billing.dao;

import java.util.List;
import java.util.Map;

import com.rainy.billing.entity.Role;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-10-30
 * @author rainy
 * @version 1.0
 */
public interface RoleDao extends AbstractDao<Role> {

	void addRightToRole(Map<String, Object> param);

	void removeRightOfRole(Long roleId);
	
	List<Role> queryEntityByUserId(Long userId);
	
	List<Role> allEntity();
	
	void addRoleToUser(Map<String, Object> param);
	
	void removeRoleOfUser(Long userId);

}

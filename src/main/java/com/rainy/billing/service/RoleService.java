package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.Role;
import com.rainy.billing.model.RoleVo;

/**
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
public interface RoleService {
	
	void operateRole(Role role);
	
	List<Role> pageQueryRole(RoleVo vo);
	
	void addRightToRole(Long roleId, Long[] rightId);
	
	List<Role> queryRoleByUserId(Long userId);
	
	String allRightToString(Long roleId);
	
	void associateRight(Long roleId, Long[] rightId);

}

package com.rainy.billing.dao;

import java.util.List;
import java.util.Map;

import com.rainy.billing.entity.Right;

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
public interface RightDao extends AbstractDao<Right> {
	
	List<Right> queryEntityByRoleId(Long roleId);
	
	List<Right> queryEntityByUserId(Long userId);
	
	List<Right> allEntity();
	
	void addResourceToRight(Map<String, Object> param);
	
	void removeResourceOfRight(Long rightId);
	
	void deleteRightRoleRelation(Map<String, Long[]> param);

}

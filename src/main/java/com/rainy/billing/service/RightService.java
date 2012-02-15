package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.Right;
import com.rainy.billing.model.RightVo;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-10-30
 * @author rainy
 * @version 1.0
 */
public interface RightService {

	void operateRight(Right right);

	List<Right> pageQueryRight(RightVo vo);

	List<Right> queryRightByRoleId(Long roleId);

	List<Right> queryRightByUserId(Long userId);

	void addResourceToRight(Long rightId, Long[] resourceId);

	void deleteRightRoleRelation(Long[] rightId, Long[] roleId);
	
	String allResourceToString(Long rightId);
	
	void associateResource(Long rightId, Long[] resourceId);

}

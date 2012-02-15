package com.rainy.billing.dao;

import java.util.List;
import java.util.Map;

import com.rainy.billing.entity.Area;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-26
 * @author rainy
 * @version 1.0
 */
public interface AreaDao extends AbstractDao<Area> {
	
	List<Area> queryEntityOfSmsChannel(Map<String, Object> param);
	
	List<Area> queryEntityOfParent(Long[] parentId);
	
	List<Area> queryEntityOfIvrChannel(Map<String, Object> param);
	
	List<Area> queryEntityOfGpChannel(Map<String, Object> param);

}

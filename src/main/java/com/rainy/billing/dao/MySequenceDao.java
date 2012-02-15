package com.rainy.billing.dao;

import java.util.Map;

import com.rainy.billing.entity.MySequence;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-28
 * @author rainy
 * @version 1.0
 */
public interface MySequenceDao extends AbstractDao<MySequence> {
	
	Long getSequence(Map<String, Object> param);
	
	MySequence getEntityByName(String name);

}

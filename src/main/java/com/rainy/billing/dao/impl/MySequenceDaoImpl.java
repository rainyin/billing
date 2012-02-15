package com.rainy.billing.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rainy.billing.dao.MySequenceDao;
import com.rainy.billing.entity.MySequence;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-28
 * @author rainy
 * @version 1.0
 */
@Repository
public class MySequenceDaoImpl extends AbstractDaoImpl<MySequence> implements
		MySequenceDao {

	@Override
	public Long getSequence(Map<String, Object> param) {
		return (Long) this.getSqlSession().selectOne(nameSpace + "getSequence", param);
	}
	@Override
	public MySequence getEntityByName(String name) {
		return (MySequence) this.getSqlSession().selectOne(nameSpace + "getEntityByName", name);
	}

}

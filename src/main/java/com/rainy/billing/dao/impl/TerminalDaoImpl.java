package com.rainy.billing.dao.impl;

import org.springframework.stereotype.Repository;

import com.rainy.billing.dao.TerminalDao;
import com.rainy.billing.entity.Terminal;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-19
 * @author rainy
 * @version 1.0
 */
@Repository
public class TerminalDaoImpl extends AbstractDaoImpl<Terminal> implements TerminalDao {
	
	@Override
	public Terminal getEntityByUid(String uid) {
		return (Terminal) this.getSqlSession().selectOne(nameSpace + "getEntityByUid", uid);
	}
	
	@Override
	public Terminal getEntityByImsi(String imsi) {
		return (Terminal) this.getSqlSession().selectOne(nameSpace + "getEntityByImsi", imsi);
	}
	
	@Override
	public void updateEntityUpdatedAt(Long id) {
		this.getSqlSession().update(nameSpace + "updateEntityUpdatedAt", id);
	}
	
}

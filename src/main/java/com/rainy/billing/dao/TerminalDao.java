package com.rainy.billing.dao;

import com.rainy.billing.entity.Terminal;

public interface TerminalDao extends AbstractDao<Terminal> {
	
	Terminal getEntityByUid(String uid);
	
	void updateEntityUpdatedAt(Long id);
	
	Terminal getEntityByImsi(String imsi);

}

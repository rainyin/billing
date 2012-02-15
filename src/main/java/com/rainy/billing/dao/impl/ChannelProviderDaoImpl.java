package com.rainy.billing.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rainy.billing.dao.ChannelProviderDao;
import com.rainy.billing.entity.ChannelProvider;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-23
 * @author rainy
 * @version 1.0
 */
@Repository
public class ChannelProviderDaoImpl extends AbstractDaoImpl<ChannelProvider> implements
		ChannelProviderDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ChannelProvider> allEntity() {
		return this.getSqlSession().selectList(nameSpace + "allEntity");
	}


	

}

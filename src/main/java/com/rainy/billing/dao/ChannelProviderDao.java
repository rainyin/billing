package com.rainy.billing.dao;

import java.util.List;

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
public interface ChannelProviderDao extends AbstractDao<ChannelProvider> {
	
	List<ChannelProvider> allEntity();

}

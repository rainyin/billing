package com.rainy.billing.dao;

import java.util.List;
import java.util.Map;

import com.rainy.billing.entity.IvrChannel;

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
public interface IvrChannelDao extends AbstractDao<IvrChannel> {
	
	List<IvrChannel> queryEntityOfProject(Map<String, Object> param);
	
	void associateWithArea(Map<String, Object> param);
	
	void unassociateWithArea(Long ivrChannelId);

}

package com.rainy.billing.dao;

import java.util.List;
import java.util.Map;

import com.rainy.billing.entity.Resource;
import com.rainy.billing.enumeration.ResourceType;
import com.rainy.billing.model.ResourceRight;

/**
 * Title: <br>
 * Description: <br>
 * Project:  elgt2.0<br>
 * Company: Finalist IT Group <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-8-30
 * @author rainy
 * @version 2.0
 */
public interface ResourceDao extends AbstractDao<Resource> {
	
    List<ResourceRight> queryResourceRight(final ResourceType type) ;
    
    List<Resource> queryEntityByRightId(Long rightId);
    
    List<Resource> allEntity();
    
    void deleteResourceRightRelation(Map<String, Long[]>  param);
    
}

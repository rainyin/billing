package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.Resource;
import com.rainy.billing.model.ResourceRight;
import com.rainy.billing.model.ResourceVo;

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
public interface ResourceService {

	void operateResource(Resource resource);

	List<Resource> pageQueryResource(ResourceVo vo);

	List<ResourceRight> queryResourceRight();

	List<Resource> queryResourceByRightId(Long rightId);

	void deleteResourceRightRelation(Long[] resourceId, Long[] rightId);
}

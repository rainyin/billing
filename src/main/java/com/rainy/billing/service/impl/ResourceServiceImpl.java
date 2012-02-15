package com.rainy.billing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.dao.ResourceDao;
import com.rainy.billing.entity.Resource;
import com.rainy.billing.enumeration.ResourceType;
import com.rainy.billing.model.ResourceRight;
import com.rainy.billing.model.ResourceVo;
import com.rainy.billing.service.ResourceService;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-10-30
 * @author rainy
 * @version 1.0
 */
@Service
public class ResourceServiceImpl extends BaseService implements ResourceService {
	
	@Autowired
	private ResourceDao resourceDao;

	@Override
	public void deleteResourceRightRelation(Long[] resourceId, Long[] rightId) {
		Map<String, Long[]> param = new HashMap<String, Long[]>();
		if(resourceId != null && resourceId.length > 0) {
			param.put("resourceId", resourceId);
		}
		if(rightId != null && rightId.length > 0) {
			param.put("rightId", rightId);
		}
		resourceDao.deleteResourceRightRelation(param);
	}

	@Override
	public void operateResource(Resource resource) {
		if(resource.getPager().isToUpdate()) {
			resourceDao.updateEntity(resource);
			log.debug("update resource success: id=" + resource.getId());
		} else if(resource.getPager().isToCreate()){
			resourceDao.createEntity(resource);
			log.debug("create resource success: id=" + resource.getId());
		} else {
			Map<String, Long[]> param = new HashMap<String, Long[]>();
			param.put("resourceId", new Long[]{resource.getId()});
			resourceDao.deleteResourceRightRelation(param);
			
			resourceDao.deleteEntityById(resource.getId());
			log.debug("delete resource success: id=" + resource.getId());
		}
	}

	@Override
	public List<Resource> pageQueryResource(ResourceVo vo) {
		return resourceDao.pageQueryEntity(vo);
	}

	@Override
	public List<Resource> queryResourceByRightId(Long rightId) {
		return resourceDao.queryEntityByRightId(rightId);
	}

	@Override
	public List<ResourceRight> queryResourceRight() {
		return resourceDao.queryResourceRight(ResourceType.URL);
	}

}

package com.rainy.billing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.dao.ResourceDao;
import com.rainy.billing.dao.RightDao;
import com.rainy.billing.entity.Resource;
import com.rainy.billing.entity.Right;
import com.rainy.billing.model.RightVo;
import com.rainy.billing.service.RightService;
import com.rainy.billing.util.SelectionUtil;

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
public class RightServiceImpl extends BaseService implements RightService {
	
	@Autowired
	private RightDao rightDao;
	
	@Autowired
	private ResourceDao resourceDao;

	@Override
	public void addResourceToRight(Long rightId, Long[] resourceId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("rightId", rightId);
		param.put("resourceId", resourceId);
		param.put("operatorId", getOperatorId());
		
		rightDao.removeResourceOfRight(rightId);
		rightDao.addResourceToRight(param);
	}
	@Override
	public void deleteRightRoleRelation(Long[] rightId, Long[] roleId) {
		Map<String, Long[]> param = new HashMap<String, Long[]>();
		if(rightId != null && rightId.length > 0) {
			param.put("rightId", rightId);
		}
		if(roleId != null && roleId.length > 0) {
			param.put("roleId", roleId);
		}
		rightDao.deleteRightRoleRelation(param);
	}

	@Override
	public void operateRight(Right right) {
		if(right.getPager().isToUpdate()) {
			right.setOperatorId(getOperatorId());
			rightDao.updateEntity(right);
			log.debug("update right success: id=" + right.getId());
		} else if(right.getPager().isToCreate()){
			right.setOperatorId(getOperatorId());
			rightDao.createEntity(right);
			log.debug("create right success: id=" + right.getId());
		} else {
			Map<String, Long[]> param = new HashMap<String, Long[]>();
			param.put("rightId", new Long[]{right.getId()});
			resourceDao.deleteResourceRightRelation(param);
			
			param.clear();
			param.put("rightId", new Long[]{right.getId()});
			rightDao.deleteRightRoleRelation(param);
			
			rightDao.deleteEntityById(right.getId());
			log.debug("delete right success: id=" + right.getId());
		}
	}

	@Override
	public List<Right> pageQueryRight(RightVo vo) {
		return rightDao.pageQueryEntity(vo);
	}

	@Override
	public List<Right> queryRightByRoleId(Long roleId) {
		return rightDao.queryEntityByRoleId(roleId);
	}

	@Override
	public List<Right> queryRightByUserId(Long userId) {
		return rightDao.queryEntityByUserId(userId);
	}

	@Override
	public String allResourceToString(Long rightId) {
		List<Resource> all = resourceDao.allEntity();
		List<Resource> selected = resourceDao.queryEntityByRightId(rightId);
		
		return SelectionUtil.createMultiselectOptions(all, selected);
	}

	@Override
	public void associateResource(Long rightId, Long[] resourceId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("rightId", rightId);
		param.put("resourceId", resourceId);
		param.put("operatorid", getOperatorId());
		
		rightDao.removeResourceOfRight(rightId);
		rightDao.addResourceToRight(param);
	}

}

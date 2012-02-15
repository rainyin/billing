package com.rainy.billing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.dao.RightDao;
import com.rainy.billing.dao.RoleDao;
import com.rainy.billing.entity.Right;
import com.rainy.billing.entity.Role;
import com.rainy.billing.model.RoleVo;
import com.rainy.billing.service.RoleService;
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
public class RoleServiceImpl extends BaseService implements RoleService {
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private RightDao rightDao;

	@Override
	public void addRightToRole(Long roleId, Long[] rightId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		param.put("rightId", rightId);
		param.put("operatorid", getOperatorId());
		
		roleDao.removeRightOfRole(roleId);
		roleDao.addRightToRole(param);
	}

	@Override
	public void operateRole(Role role) {
		if(role.getPager().isToUpdate()) {
			role.setOperatorId(getOperatorId());
			roleDao.updateEntity(role);
			log.debug("update role success: id=" + role.getId());
		} else if(role.getPager().isToCreate()){
			role.setOperatorId(getOperatorId());
			roleDao.createEntity(role);
			log.debug("create role success: id=" + role.getId());
		} else {
			Map<String, Long[]> param = new HashMap<String, Long[]>();
			param.put("roleId", new Long[]{role.getId()});
			rightDao.deleteRightRoleRelation(param);	
			
			roleDao.deleteEntityById(role.getId());
			log.debug("delete role success: id=" + role.getId());
		}
	}

	@Override
	public List<Role> pageQueryRole(RoleVo vo) {
		return roleDao.pageQueryEntity(vo);
	}

	@Override
	public List<Role> queryRoleByUserId(Long userId) {
		return roleDao.queryEntityByUserId(userId);
	}

	@Override
	public String allRightToString(Long roleId) {
		List<Right> all = rightDao.allEntity();
		List<Right> selected = rightDao.queryEntityByRoleId(roleId);
		
		return SelectionUtil.createMultiselectOptions(all, selected);
	}

	@Override
	public void associateRight(Long roleId, Long[] rightId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		param.put("rightId", rightId);
		param.put("operatorid", getOperatorId());
		
		roleDao.removeRightOfRole(roleId);
		roleDao.addRightToRole(param);
	}


}

package com.rainy.billing.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.Constant;
import com.rainy.billing.dao.RoleDao;
import com.rainy.billing.dao.UserDao;
import com.rainy.billing.entity.Role;
import com.rainy.billing.entity.User;
import com.rainy.billing.model.UserVo;
import com.rainy.billing.security.SecurityContext;
import com.rainy.billing.service.UserService;
import com.rainy.billing.util.EncryptionUtil;
import com.rainy.billing.util.SelectionUtil;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-29
 * @author rainy
 * @version 1.0
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public void deleteUser(Long... id) {
		if (id != null && id.length == 1) {
			userDao.deleteEntityById(id[0]);
		} else if(id != null){
			userDao.deleteEntityBatch(id);
		} else {
			log.warn("delete user by null id");
		}
		log.debug("delete user success: id = " + id);
	}

	@Override
	public User getUserById(Long id) {
		if (id != null) {
			return userDao.getEntityById(id);
		}
		log.warn("get user by null id");
		return null;
	}

	@Override
	public void updateUser(User user, String npassword) {
		user.setOperatorId(getOperatorId());
		if(npassword != null) {
			log.info("new password: " + npassword + " username: " + user.getUsername());
			user.setPassword(EncryptionUtil.encrypePassword(user.getUsername(), npassword));
		}
		user.setUsername(null);// 不更新登录名
		userDao.updateEntity(user);
		super.updateUser(user);
		log.debug("update user success: id=" + user.getId());
	}

	@Override
	public void operateUser(User user) {
		if(user.getPager().isToUpdate()) {
			user.setOperatorId(getOperatorId());
			user.setPassword(EncryptionUtil.encrypePassword(user.getUsername(), Constant.INITIAL_PASSWD));
			userDao.updateEntity(user);
			log.debug("update user success: id=" + user.getId());
			associateRole(user.getId(), new Long[]{user.getRoleId()});
		} else if(user.getPager().isToCreate()){
			user.setOperatorId(getOperatorId());
			user.setPassword(EncryptionUtil.encrypePassword(user.getUsername(), Constant.INITIAL_PASSWD));
			userDao.createEntity(user);
			log.debug("create user success: id=" + user.getId());
			associateRole(user.getId(), new Long[]{user.getRoleId()});
		} else {
			userDao.deleteEntityById(user.getId());
			log.debug("delete user success: id=" + user.getId());
		}
	}

	@Override
	public List<User> pageQueryUser(UserVo vo) {
		List<User> users = userDao.pageQueryEntity(vo);
		
		List<User> invisible = new ArrayList<User>();
		for(User user : users) {
			if((SecurityContext.getCurrentUser() != null && user.getId().equals(SecurityContext.getCurrentUser().getId()))
					|| "admin".equals(user.getUsername())) {
				invisible.add(user);
			}
		}
		users.removeAll(invisible);
		
		return users;
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getEntityByUsername(username);
	}

	@Override
	public Boolean usernameExist(String username, Long id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("username", username);
		if(id != null && id != Constant.INITIAL_ID) {
			param.put("id", id);
		}
		Long count = userDao.countEntityByUsername(param);
		
		return count > 0;
	}
	
	@Override
	public String allRoleToString(Long rightId) {
		List<Role> allRoles = roleDao.allEntity();
		List<Role> assoRoles = roleDao.queryEntityByUserId(rightId);
		
		return SelectionUtil.createMultiselectOptions(allRoles, assoRoles);
	}

	@Override
	public void associateRole(Long userId, Long[] roleId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userid", userId);
		param.put("roleId", roleId);
		param.put("operatorid", getOperatorId());
		
		roleDao.removeRoleOfUser(userId);
		roleDao.addRoleToUser(param);
	}

	@Override
	public String allRoleToString() {
		List<Role> all = roleDao.allEntity();
		
		return SelectionUtil.createSelectOptions(all);
	}


	@Override
	public void resetPassword(Long userId) {
		User user = userDao.getEntityById(userId);
		user.setOperatorId(getOperatorId());
		user.setPassword(EncryptionUtil.encrypePassword(user.getUsername(), Constant.INITIAL_PASSWD));
		userDao.updateEntity(user);
	}

	@Override
	public Boolean isInputPasswordRight(String opassword) {
		User user = SecurityContext.getCurrentUser();
		if(user != null) {
			String inputPass = EncryptionUtil.encrypePassword(user.getUsername(), opassword);
			if(user.getPassword().equals(inputPass)) return true;
		}
		return false;
	}

}

package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.Role;
import com.rainy.billing.model.RoleVo;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-19
 * @author rainy
 * @version 1.0
 */
public class RoleServiceTest extends AbstractServiceTest {
	
	@Autowired
	private RoleService roleService;
	
	private Role createRole(){
		Role role = new Role();
		role.setName("test");
		
		roleService.operateRole(role);
		return role;
	}
	
	@Test
	public void testCreateRole(){
		Role role = createRole();
		
		print("testCreateRole: role=" + role);
	}
	
	@Test
	public void testPageQueryRole(){
		RoleVo vo = new RoleVo();
		vo.setName(createRole().getName());
		List<Role> list = roleService.pageQueryRole(vo);
		
		print("testPageQueryRole: size=" + list.size());
	}
	
	@Test
	public void testAddRightToRole(){
		roleService.addRightToRole(1L, new Long[]{1L, 2L});
	}
	
	@Test
	public void testQueryRoleByUserId(){
		List<Role> list = roleService.queryRoleByUserId(1L);
		
		print("testQueryRoleByUserId size=" + list.size());
	}
	
	@Test
	public void testAssociateRight(){
		roleService.associateRight(1L, new Long[]{2L, 3L});
	}
}

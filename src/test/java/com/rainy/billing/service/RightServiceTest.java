package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.Right;
import com.rainy.billing.model.RightVo;

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
public class RightServiceTest extends AbstractServiceTest {
	
	@Autowired
	private RightService rightService;
	
	private Right createRight(){
		Right right = new Right();
		right.setName("test");
		
		rightService.operateRight(right);
		return right;
	}
	
	
	@Test
	public void testCreateRight(){
		Right right = createRight();
		
		print("testCreateRight: right=" + right);
	}

	
	@Test
	public void testPageQueryRight(){
		RightVo vo = new RightVo();
		vo.setName(createRight().getName());
		List<Right> list = rightService.pageQueryRight(vo);
		
		print("testPageQueryRight: size=" + list.size());
	}
	
	@Test
	public void testAddResourceToRight(){
		rightService.addResourceToRight(1L, new Long[]{1L, 2L});
	}
	
	@Test
	public void testDeleteRightRoleRelation(){
		rightService.deleteRightRoleRelation(new Long[]{1L, 2L}, null);
	}
	
	@Test
	public void testQueryRightByRoleId(){
		List<Right> list = rightService.queryRightByRoleId(1L);
		
		print("testQueryRightByRoleId size=" + list.size());
	}
	
	@Test
	public void testQueryRightByUserId(){
		List<Right> list = rightService.queryRightByUserId(1L);
		
		print("testQueryRightByUserId size=" + list.size());
	}
}

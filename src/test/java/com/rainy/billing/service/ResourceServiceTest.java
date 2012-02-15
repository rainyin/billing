package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.Resource;
import com.rainy.billing.model.ResourceRight;
import com.rainy.billing.model.ResourceVo;

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
public class ResourceServiceTest extends AbstractServiceTest {
	
	@Autowired
	private ResourceService resourceService;
	
	private Resource createResource(){
		Resource resource = new Resource();
		resource.setName("test");
		
		resourceService.operateResource(resource);
		return resource;
	}
	
	@Test
	public void testCreateResource(){
		Resource resource = createResource();
		
		print("testCreateResource: resource=" + resource);
	}
	
	@Test
	public void testPageQueryResource(){
		ResourceVo vo = new ResourceVo();
		vo.setName(createResource().getName());
		List<Resource> list = resourceService.pageQueryResource(vo);
		
		print("testPageQueryResource: size=" + list.size());
	}
	
	@Test
	public void testDeleteResourceRightRelation(){
		resourceService.deleteResourceRightRelation(new Long[]{1L, 2L}, null);
	}
	
	@Test
	public void testQueryResourceByRightId(){
		List<Resource> list = resourceService.queryResourceByRightId(1L);
		
		print("testQueryResourceByRightId size=" + list.size());
	}
	
	@Test
	public void testQueryResourceRight(){
		List<ResourceRight> list = resourceService.queryResourceRight();
		
		print("testQueryResourceRight size=" + list.size());
	}
}

package com.rainy.billing.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-12-1
 * @author rainy
 * @version 1.0
 */
public class CacheServiceTest extends AbstractServiceTest {
	
	@Autowired
	private CacheService cacheService;
	
	@Test
	public void testGetProject() {
		cacheService.getProject(10000L);
		cacheService.getProject(10000L);
		cacheService.getProject(10000L);
		
		cacheService.getProject(10003L);
	}

}

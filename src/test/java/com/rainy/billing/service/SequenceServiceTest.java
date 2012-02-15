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
 * @2011-12-8
 * @author rainy
 * @version 1.0
 */
public class SequenceServiceTest extends AbstractServiceTest {
	
	@Autowired
	private SequenceService sequenceService;
	
	@Test
	public void testGetJid() {
		print("jid: " + sequenceService.retrieveJid());
	}
	
	@Test
	public void testGetUid() {
		for(int i = 0 ; i < 33 ; i++) {
			print("uid: " + sequenceService.retrieveUid());
		}
	}

}

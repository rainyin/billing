package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.Blacklist;
import com.rainy.billing.model.BlacklistVo;

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
public class BlacklistServiceTest extends AbstractServiceTest {
	
	@Autowired
	private BlacklistService blacklistService;
	
	private Blacklist createBlacklist(){
		Blacklist blacklist = new Blacklist();
		blacklist.setPhoneNumber("test");
		
		blacklistService.operateBlacklist(blacklist);
		return blacklist;
	}
	
	@Test
	public void testGetBlacklistById(){
		Blacklist blacklist = blacklistService.getBlacklistById(createBlacklist().getId());
		
		print("testGetBlacklistById: blacklist=" + blacklist);
	}
	
	@Test
	public void testCreateBlacklist(){
		Blacklist blacklist = createBlacklist();
		
		print("testCreateBlacklist: blacklist=" + blacklist);
	}
	
	@Test
	public void testUpdateBlacklist(){
		Blacklist blacklist = createBlacklist();
		blacklist.setPhoneNumber("122121");
		blacklistService.updateBlacklist(blacklist);
		
		print("testUpdateBlacklist: blacklist=" + blacklist);
	}
	
	@Test
	public void testDeleteBlacklist(){
		Blacklist blacklist = createBlacklist();
		blacklistService.deleteBlacklist(blacklist.getId());
		
		print("testDeleteBlacklist: id=" + blacklist.getId());
	}
	
	@Test
	public void testQueryBlacklistByName(){
		Blacklist blacklist = createBlacklist();
		List<Blacklist> list = blacklistService.queryBlacklistByPhoneNumber(blacklist.getPhoneNumber());
		
		print("testQueryBlacklistByName: size=" + list.size());
	}
	
	@Test
	public void testPageQueryBlacklist(){
		BlacklistVo vo = new BlacklistVo();
		vo.setPhoneNumber(createBlacklist().getPhoneNumber());
		List<Blacklist> list = blacklistService.pageQueryBlacklist(vo);
		
		print("testPageQueryBlacklist: size=" + list.size());
	}
}

package com.rainy.billing.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.Terminal;

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
public class TerminalServiceTest extends AbstractServiceTest {
	
	@Autowired
	private TerminalService terminalService;
	
	private Terminal createTerminal(){
		Terminal terminal = new Terminal();
		terminal.setAreaCode("1111");
		terminal.setUid("111");
		
		terminalService.createTerminal(terminal);
		return terminal;
	}
	
	@Test
	public void testGetTerminalById(){
		Terminal terminal = terminalService.getTerminalById(createTerminal().getId());
		
		print("testGetTerminalById: terminal=" + terminal);
	}
	
	@Test
	public void testCreateTerminal(){
		Terminal terminal = createTerminal();
		
		print("testCreateTerminal: terminal=" + terminal);
	}
	
	@Test
	public void testUpdateTerminal(){
		Terminal terminal = createTerminal();
		terminal.setAreaCode("1221");
		terminalService.updateTerminal(terminal);
		
		print("testUpdateTerminal: terminal=" + terminal);
	}
	
	@Test
	public void testDeleteTerminal(){
		Terminal terminal = createTerminal();
		terminalService.deleteTerminal(terminal.getId());
		
		print("testDeleteTerminal: id=" + terminal.getId());
	}
	
	@Test
	public void testQueryTerminalByUid(){
		Terminal terminal = terminalService.getTerminalByUid(createTerminal().getUid().toString());
		
		print("testQueryTerminalByName: =" + terminal);
	}
}

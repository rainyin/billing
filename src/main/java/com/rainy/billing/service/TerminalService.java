package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.Terminal;
import com.rainy.billing.model.TerminalVo;

public interface TerminalService {
	
	Terminal getTerminalById(Long id);
	
	void updateTerminal(Terminal terminal);
	
	void updateTerminalUpdatedAt(Terminal terminal);
	
	void createTerminal(Terminal terminal);
	
	void deleteTerminal(Long... id);
	
	Terminal getTerminalByUid(String uid);
	
	Terminal getTerminalByImsi(String imsi);
	
	List<Terminal> pageQueryTerminal(TerminalVo vo);

}

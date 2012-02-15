package com.rainy.billing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.dao.TerminalDao;
import com.rainy.billing.entity.Terminal;
import com.rainy.billing.model.TerminalVo;
import com.rainy.billing.service.TerminalService;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-19
 * @author rainy
 * @version 1.0
 */
@Service
public class TerminalServiceImpl extends BaseService implements TerminalService {

	@Autowired
	private TerminalDao terminalDao;

	@Override
	public void deleteTerminal(Long... id) {
		if (id != null && id.length == 1) {
			terminalDao.deleteEntityById(id[0]);
		} else if(id != null){
			terminalDao.deleteEntityBatch(id);
		} else {
			log.warn("delete terminal by null id");
		}
		log.debug("delete terminal success: id = " + id);
	}

	@Override
	public Terminal getTerminalById(Long id) {
		if (id != null) {
			return terminalDao.getEntityById(id);
		}
		log.warn("get terminal by null id");
		return null;
	}

	@Override
	public Terminal getTerminalByUid(String uid) {		
		return terminalDao.getEntityByUid(uid);
	}
	
	@Override
	public Terminal getTerminalByImsi(String imsi) {		
		return terminalDao.getEntityByImsi(imsi);
	}

	@Override
	public void updateTerminal(Terminal terminal) {
		terminalDao.updateEntity(terminal);
		log.debug("update terminal success: id=" + terminal.getId());
	}

	@Override
	public void createTerminal(Terminal terminal) {
		if(terminalDao.getEntityByImsi(terminal.getImsi()) == null) {
			terminalDao.createEntity(terminal);
			log.debug("create terminal success: id=" + terminal.getId());
		} else {
			log.error("terminal with imsi :" + terminal.getImsi() + " request with invalid uid more than one time");
		}
	}

	@Override
	public List<Terminal> pageQueryTerminal(TerminalVo vo) {
		return terminalDao.pageQueryEntity(vo);
	}

	@Override
	public void updateTerminalUpdatedAt(Terminal terminal) {
		terminalDao.updateEntityUpdatedAt(terminal.getId());
	}

}

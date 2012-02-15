package com.rainy.billing.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.dao.BlacklistDao;
import com.rainy.billing.entity.Blacklist;
import com.rainy.billing.model.BlacklistVo;
import com.rainy.billing.service.BlacklistService;

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
public class BlacklistServiceImpl extends BaseService implements BlacklistService {

	@Autowired
	private BlacklistDao blacklistDao;

	@Override
	public void deleteBlacklist(Long... id) {
		if (id != null && id.length == 1) {
			blacklistDao.deleteEntityById(id[0]);
		} else if(id != null){
			blacklistDao.deleteEntityBatch(id);
		} else {
			log.warn("delete blacklist by null id");
		}
		log.debug("delete blacklist success: id = " + id);
	}

	@Override
	public Blacklist getBlacklistById(Long id) {
		if (id != null) {
			return blacklistDao.getEntityById(id);
		}
		log.warn("get blacklist by null id");
		return null;
	}

	@Override
	public List<Blacklist> queryBlacklistByPhoneNumber(String phoneNumber) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("phoneNumber", phoneNumber);
		
		return blacklistDao.queryEntity(param);
	}

	@Override
	public void updateBlacklist(Blacklist blacklist) {
		blacklistDao.updateEntity(blacklist);
		log.debug("update blacklist success: id=" + blacklist.getId());
	}

	@Override
	public void operateBlacklist(Blacklist blacklist) {
		if(blacklist.getPager().isToUpdate()) {
			blacklistDao.updateEntity(blacklist);
			log.debug("update blacklist success: id=" + blacklist.getId());
		} else if(blacklist.getPager().isToCreate()){
			blacklistDao.createEntity(blacklist);
			log.debug("create blacklist success: id=" + blacklist.getId());
		} else {
			blacklistDao.deleteEntityById(blacklist.getId());
			log.debug("delete blacklist success: id=" + blacklist.getId());
		}
	}

	@Override
	public List<Blacklist> pageQueryBlacklist(BlacklistVo vo) {
		return blacklistDao.pageQueryEntity(vo);
	}
}

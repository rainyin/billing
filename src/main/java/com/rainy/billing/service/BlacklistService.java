package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.Blacklist;
import com.rainy.billing.model.BlacklistVo;

public interface BlacklistService {
	
	Blacklist getBlacklistById(Long id);
	
	void operateBlacklist(Blacklist blacklist);
	
	void updateBlacklist(Blacklist blacklist);
	
	void deleteBlacklist(Long... id);
	
	List<Blacklist> queryBlacklistByPhoneNumber(String phoneNumber);
	
	List<Blacklist> pageQueryBlacklist(BlacklistVo vo);

}

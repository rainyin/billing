package com.rainy.billing.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.dao.CatNumberDao;
import com.rainy.billing.entity.CatNumber;
import com.rainy.billing.enumeration.ActiveStatus;
import com.rainy.billing.model.CatNumberVo;
import com.rainy.billing.service.CatNumberService;

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
public class CatNumberServiceImpl extends BaseService implements CatNumberService {
	
	private Object mutex = new Object();
	private static List<String> numbers = new ArrayList<String>();

	@Autowired
	private CatNumberDao catNumberDao;
	
	@Override
	public Boolean isNumberValid(String number) {
		synchronized(mutex) {
			for(String num : numbers) {
				if(num.equals(number)) {
					return true;
				}
			}
			return false;
		}
	}
	
	@Override
	public String getValidNumber() {
		synchronized(mutex) {
			if(numbers.size() > 0) {
				int index = (int) (System.currentTimeMillis() % numbers.size());
				return numbers.get(index);
			}
			return "";
		}
	}
	
	@PostConstruct
	private void loadAllNumber() {
		log.info("load all cat number:");
		synchronized(mutex) {
			numbers.clear();
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("status", ActiveStatus.ENABLED);
			
			List<CatNumber> catList = catNumberDao.queryEntity(param);
			for(CatNumber cat : catList) {
				numbers.add(cat.getNumber());
			}
		}
	}
	
	@Override
	public void deleteCatNumber(Long... id) {
		if (id != null && id.length == 1) {
			catNumberDao.deleteEntityById(id[0]);
		} else if(id != null){
			catNumberDao.deleteEntityBatch(id);
		} else {
			log.warn("delete catNumber by null id");
		}
		log.debug("delete catNumber success: id = " + id);
		loadAllNumber();
	}

	@Override
	public CatNumber getCatNumberById(Long id) {
		if (id != null) {
			return catNumberDao.getEntityById(id);
		}
		log.warn("get catNumber by null id");
		return null;
	}

	@Override
	public List<CatNumber> queryCatNumberByNumber(String number) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("number", number);
		
		return catNumberDao.queryEntity(param);
	}
	
	@Override
	public List<CatNumber> queryCatNumberByStatus(ActiveStatus status) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("status", status);
		
		return catNumberDao.queryEntity(param);
	}

	@Override
	public void updateCatNumber(CatNumber catNumber) {
		catNumberDao.updateEntity(catNumber);
		log.debug("update catNumber success: id=" + catNumber.getId());
		loadAllNumber();
	}

	@Override
	public void operateCatNumber(CatNumber catNumber) {
		if(catNumber.getPager().isToUpdate()) {
			catNumberDao.updateEntity(catNumber);
			log.debug("update catNumber success: id=" + catNumber.getId());
			loadAllNumber();
		} else if(catNumber.getPager().isToCreate()){
			catNumberDao.createEntity(catNumber);
			log.debug("create catNumber success: id=" + catNumber.getId());
			loadAllNumber();
		} else {
			catNumberDao.deleteEntityById(catNumber.getId());
			log.debug("delete catNumber success: id=" + catNumber.getId());
			loadAllNumber();
		}
	}

	@Override
	public List<CatNumber> pageQueryCatNumber(CatNumberVo vo) {
		return catNumberDao.pageQueryEntity(vo);
	}
}

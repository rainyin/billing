package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.CatNumber;
import com.rainy.billing.enumeration.ActiveStatus;
import com.rainy.billing.model.CatNumberVo;

public interface CatNumberService {
	
	CatNumber getCatNumberById(Long id);
	
	void operateCatNumber(CatNumber catNumber);
	
	void updateCatNumber(CatNumber catNumber);
	
	void deleteCatNumber(Long... id);
	
	List<CatNumber> queryCatNumberByNumber(String number);
	
	List<CatNumber> queryCatNumberByStatus(ActiveStatus status);
	
	List<CatNumber> pageQueryCatNumber(CatNumberVo vo);
	
	Boolean isNumberValid(String number);
	
	String getValidNumber();

}

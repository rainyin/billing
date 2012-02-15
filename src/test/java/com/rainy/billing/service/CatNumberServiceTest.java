package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.CatNumber;
import com.rainy.billing.model.CatNumberVo;

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
public class CatNumberServiceTest extends AbstractServiceTest {
	
	@Autowired
	private CatNumberService catNumberService;
	
	private CatNumber createCatNumber(){
		CatNumber catNumber = new CatNumber();
		catNumber.setNumber("test");
		
		catNumberService.operateCatNumber(catNumber);
		return catNumber;
	}
	
	@Test
	public void testGetCatNumberById(){
		CatNumber catNumber = catNumberService.getCatNumberById(createCatNumber().getId());
		
		print("testGetCatNumberById: catNumber=" + catNumber);
	}
	
	@Test
	public void testCreateCatNumber(){
		CatNumber catNumber = createCatNumber();
		
		print("testCreateCatNumber: catNumber=" + catNumber);
	}
	
	@Test
	public void testUpdateCatNumber(){
		CatNumber catNumber = createCatNumber();
		catNumber.setNumber("122121");
		catNumberService.updateCatNumber(catNumber);
		
		print("testUpdateCatNumber: catNumber=" + catNumber);
	}
	
	@Test
	public void testDeleteCatNumber(){
		CatNumber catNumber = createCatNumber();
		catNumberService.deleteCatNumber(catNumber.getId());
		
		print("testDeleteCatNumber: id=" + catNumber.getId());
	}
	
	@Test
	public void testQueryCatNumberByName(){
		CatNumber catNumber = createCatNumber();
		List<CatNumber> list = catNumberService.queryCatNumberByNumber(catNumber.getNumber());
		
		print("testQueryCatNumberByName: size=" + list.size());
	}
	
	@Test
	public void testPageQueryCatNumber(){
		CatNumberVo vo = new CatNumberVo();
		vo.setNumber(createCatNumber().getNumber());
		List<CatNumber> list = catNumberService.pageQueryCatNumber(vo);
		
		print("testPageQueryCatNumber: size=" + list.size());
	}
}

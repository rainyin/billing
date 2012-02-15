package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.Area;
import com.rainy.billing.model.AreaVo;

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
public class AreaServiceTest extends AbstractServiceTest {
	
	@Autowired
	private AreaService areaService;
	
	private Area createArea(){
		Area area = new Area();
		area.setName("test");
		
		areaService.operateArea(area);
		return area;
	}
	
	@Test
	public void testGetAreaById(){
		Area area = areaService.getAreaById(createArea().getId());
		
		print("testGetAreaById: area=" + area);
	}
	
	@Test
	public void testCreateArea(){
		Area area = createArea();
		
		print("testCreateArea: area=" + area);
	}
	
	@Test
	public void testUpdateArea(){
		Area area = createArea();
		area.setName("122121");
		areaService.updateArea(area);
		
		print("testUpdateArea: area=" + area);
	}
	
	@Test
	public void testDeleteArea(){
		Area area = createArea();
		areaService.deleteArea(area.getId());
		
		print("testDeleteArea: id=" + area.getId());
	}
	
	@Test
	public void testQueryArea(){
		List<Area> list = areaService.queryArea(new AreaVo());
		
		print("testQueryAreaByName: size=" + list.size());
	}

}

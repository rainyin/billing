package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.Area;
import com.rainy.billing.model.AreaVo;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-26
 * @author rainy
 * @version 1.0
 */
public interface AreaService {

	Area getAreaById(Long id);

	void operateArea(Area area);

	void updateArea(Area area);

	void deleteArea(Long... id);

	List<Area> queryArea(AreaVo vo);

}

package com.rainy.billing.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.Constant;
import com.rainy.billing.dao.AreaDao;
import com.rainy.billing.entity.Area;
import com.rainy.billing.enumeration.AreaLevel;
import com.rainy.billing.model.AreaVo;
import com.rainy.billing.service.AreaService;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-26
 * @author rainy
 * @version 1.0
 */
@Service
public class AreaServiceImpl extends BaseService implements AreaService {
	
	@Autowired
	private AreaDao areaDao;

	@Override
	public void deleteArea(Long... id) {
		if (id != null && id.length == 1) {
			areaDao.deleteEntityById(id[0]);
		} else if(id != null){
			areaDao.deleteEntityBatch(id);
		} else {
			log.warn("delete area by null id");
		}
		log.debug("delete area success: id = " + id);
	}

	@Override
	public Area getAreaById(Long id) {
		if (id != null) {
			return areaDao.getEntityById(id);
		}
		log.warn("get area by null id");
		return null;
	}

	@Override
	public List<Area> queryArea(AreaVo vo) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		if(vo.getParentId() == null) {
			vo.setParentId(Constant.INITIAL_ID);
		}
		param.put("parentId", vo.getParentId());
		param.put("name", vo.getName());
		
		log.info("parentId===========" + vo.getParentId());
		
		return areaDao.queryEntity(param);
	}

	@Override
	public void updateArea(Area area) {
		area.setOperatorId(getOperatorId());
		areaDao.updateEntity(area);
		log.debug("update area success: id=" + area.getId());
	}

	@Override
	public void operateArea(Area area) {
		if(area.getPager().isToUpdate()) {
			area.setOperatorId(getOperatorId());
			areaDao.updateEntity(area);
			log.debug("update area success: id=" + area.getId());
		} else if(area.getPager().isToCreate()){
			area.setOperatorId(getOperatorId());
			areaDao.createEntity(area);
			if(area.is1stLevel()) {
				area.setParentId(Constant.INITIAL_ID);
				area.setAreaLink(area.getParentId().toString() + Constant.AREA_DELIMITER + area.getId().toString());
			} else {
				log.info("not 1st level");
				area.setAreaLink(area.getAreaLink() + Constant.AREA_DELIMITER + area.getId());
				log.info("area link:::" + area.getAreaLink());
				area.setLevel(AreaLevel.TWO);
				if(area.getAreaLink().split(Constant.AREA_DELIMITER).length > 3) {
					area.setLevel(AreaLevel.THREE);
				}
			}
			
			areaDao.updateEntity(area);
			log.debug("create area success: id=" + area.getId());
		} else {
			areaDao.deleteEntityById(area.getId());
			log.debug("delete area success: id=" + area.getId());
		}
	}
}

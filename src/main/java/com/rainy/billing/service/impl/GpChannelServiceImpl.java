package com.rainy.billing.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.Constant;
import com.rainy.billing.dao.AreaDao;
import com.rainy.billing.dao.ChannelProviderDao;
import com.rainy.billing.dao.GpChannelDao;
import com.rainy.billing.entity.Area;
import com.rainy.billing.entity.ChannelProvider;
import com.rainy.billing.entity.GpChannel;
import com.rainy.billing.model.GpChannelVo;
import com.rainy.billing.service.GpChannelService;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-23
 * @author rainy
 * @version 1.0
 */
@Service
public class GpChannelServiceImpl extends BaseService implements GpChannelService {

	@Autowired
	private GpChannelDao gpChannelDao;
	
	@Autowired
	private ChannelProviderDao channelProviderDao;
	
	@Autowired
	private AreaDao areaDao;

	@Override
	public void deleteGpChannel(Long... id) {
		if (id != null && id.length == 1) {
			gpChannelDao.deleteEntityById(id[0]);
		} else if(id != null){
			gpChannelDao.deleteEntityBatch(id);
		} else {
			log.warn("delete gpChannel by null id");
		}
		log.debug("delete gpChannel success: id = " + id);
	}

	@Override
	public GpChannel getGpChannelById(Long id) {
		if (id != null) {
			return gpChannelDao.getEntityById(id);
		}
		log.warn("get gpChannel by null id");
		return null;
	}

	@Override
	public List<GpChannel> queryGpChannelByName(String name) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("name", name);
		
		return gpChannelDao.queryEntity(param);
	}

	@Override
	public void updateGpChannel(GpChannel gpChannel) {
		gpChannel.setOperatorId(getOperatorId());
		gpChannelDao.updateEntity(gpChannel);
		log.debug("update gpChannel success: id=" + gpChannel.getId());
	}

	@Override
	public void operateGpChannel(GpChannel gpChannel) {
		if(gpChannel.getPager().isToUpdate()) {
			gpChannel.setOperatorId(getOperatorId());
			ChannelProvider cp = channelProviderDao.getEntityById(gpChannel.getChannelProviderId());
			if(cp != null) {
				gpChannel.setChannelProviderName(cp.getName());
			}
			gpChannelDao.updateEntity(gpChannel);
			log.debug("update gpChannel success: id=" + gpChannel.getId());
		} else if(gpChannel.getPager().isToCreate()){
			gpChannel.setOperatorId(getOperatorId());
			ChannelProvider cp = channelProviderDao.getEntityById(gpChannel.getChannelProviderId());
			if(cp != null) {
				gpChannel.setChannelProviderName(cp.getName());
			}
			gpChannelDao.createEntity(gpChannel);
			log.debug("create gpChannel success: id=" + gpChannel.getId());
		} else {
			gpChannelDao.deleteEntityById(gpChannel.getId());
			log.debug("delete gpChannel success: id=" + gpChannel.getId());
		}
	}

	@Override
	public List<GpChannel> pageQueryGpChannel(GpChannelVo vo) {
		return gpChannelDao.pageQueryEntity(vo);
	}

	@Override
	public List<Area> queryArea(Long parentId, Long gpChannelId) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("parentId", parentId);
		if(parentId == null) param.put("parentId", Constant.INITIAL_ID);
		
		List<Area> list = areaDao.queryEntity(param);
		
		param.clear();
		param.put("gpChannelId", gpChannelId);
		List<Area> assoList = areaDao.queryEntityOfGpChannel(param);
		
		for(Area area : list) {
			for(Area assoArea : assoList) {
				if(area.getId().longValue() == assoArea.getId()) {
					area.setAssociated(true);
				}
			}
		}
		
		return list;
	}

	@Override
	public void associateArea(Long channelId, Long[] areaId) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("gpChannelId", channelId);
		param.put("operatorId", getOperatorId());
		param.put("areaId", fillChildArea(areaId));
		
		gpChannelDao.unassociateWithArea(channelId);
		if(areaId != null && areaId.length > 0){
			gpChannelDao.associateWithArea(param);
		}
	}

}

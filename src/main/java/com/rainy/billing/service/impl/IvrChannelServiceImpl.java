package com.rainy.billing.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.Constant;
import com.rainy.billing.dao.AreaDao;
import com.rainy.billing.dao.ChannelProviderDao;
import com.rainy.billing.dao.IvrChannelDao;
import com.rainy.billing.entity.Area;
import com.rainy.billing.entity.ChannelProvider;
import com.rainy.billing.entity.IvrChannel;
import com.rainy.billing.model.IvrChannelVo;
import com.rainy.billing.service.IvrChannelService;

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
public class IvrChannelServiceImpl extends BaseService implements IvrChannelService {

	@Autowired
	private IvrChannelDao ivrChannelDao;
	
	@Autowired
	private ChannelProviderDao channelProviderDao;
	
	@Autowired
	private AreaDao areaDao;

	@Override
	public void deleteIvrChannel(Long... id) {
		if (id != null && id.length == 1) {
			ivrChannelDao.deleteEntityById(id[0]);
		} else if(id != null){
			ivrChannelDao.deleteEntityBatch(id);
		} else {
			log.warn("delete ivrChannel by null id");
		}
		log.debug("delete ivrChannel success: id = " + id);
	}

	@Override
	public IvrChannel getIvrChannelById(Long id) {
		if (id != null) {
			return ivrChannelDao.getEntityById(id);
		}
		log.warn("get ivrChannel by null id");
		return null;
	}

	@Override
	public List<IvrChannel> queryIvrChannelByName(String name) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("name", name);
		
		return ivrChannelDao.queryEntity(param);
	}

	@Override
	public void updateIvrChannel(IvrChannel ivrChannel) {
		ivrChannel.setOperatorId(getOperatorId());
		ivrChannelDao.updateEntity(ivrChannel);
		log.debug("update ivrChannel success: id=" + ivrChannel.getId());
	}

	@Override
	public void operateIvrChannel(IvrChannel ivrChannel) {
		if(ivrChannel.getPager().isToUpdate()) {
			ivrChannel.setOperatorId(getOperatorId());
			ChannelProvider cp = channelProviderDao.getEntityById(ivrChannel.getChannelProviderId());
			if(cp != null) {
				ivrChannel.setChannelProviderName(cp.getName());
			}
			ivrChannelDao.updateEntity(ivrChannel);
			log.debug("update ivrChannel success: id=" + ivrChannel.getId());
		} else if(ivrChannel.getPager().isToCreate()){
			ivrChannel.setOperatorId(getOperatorId());
			ChannelProvider cp = channelProviderDao.getEntityById(ivrChannel.getChannelProviderId());
			if(cp != null) {
				ivrChannel.setChannelProviderName(cp.getName());
			}
			ivrChannelDao.createEntity(ivrChannel);
			log.debug("create ivrChannel success: id=" + ivrChannel.getId());
		} else {
			ivrChannelDao.deleteEntityById(ivrChannel.getId());
			log.debug("delete ivrChannel success: id=" + ivrChannel.getId());
		}
	}

	@Override
	public List<IvrChannel> pageQueryIvrChannel(IvrChannelVo vo) {
		return ivrChannelDao.pageQueryEntity(vo);
	}

	@Override
	public List<Area> queryArea(Long parentId, Long ivrChannelId) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("parentId", parentId);
		if(parentId == null) param.put("parentId", Constant.INITIAL_ID);
		
		List<Area> list = areaDao.queryEntity(param);
		
		param.clear();
		param.put("ivrChannelId", ivrChannelId);
		List<Area> assoList = areaDao.queryEntityOfIvrChannel(param);
		
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
		param.put("ivrChannelId", channelId);
		param.put("operatorId", getOperatorId());
		param.put("areaId", fillChildArea(areaId));
		
		ivrChannelDao.unassociateWithArea(channelId);
		if(areaId != null && areaId.length > 0){
			ivrChannelDao.associateWithArea(param);
		}
	}

}

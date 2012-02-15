package com.rainy.billing.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.Constant;
import com.rainy.billing.dao.AreaDao;
import com.rainy.billing.dao.ChannelProviderDao;
import com.rainy.billing.dao.SmsChannelDao;
import com.rainy.billing.entity.Area;
import com.rainy.billing.entity.ChannelProvider;
import com.rainy.billing.entity.SmsChannel;
import com.rainy.billing.enumeration.Carrier;
import com.rainy.billing.model.SmsChannelVo;
import com.rainy.billing.service.SmsChannelService;

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
public class SmsChannelServiceImpl extends BaseService implements SmsChannelService {

	@Autowired
	private SmsChannelDao smsChannelDao;
	
	@Autowired
	private ChannelProviderDao channelProviderDao;
	
	@Autowired
	private AreaDao areaDao;

	@Override
	public void deleteSmsChannel(Long... id) {
		if (id != null && id.length == 1) {
			smsChannelDao.deleteEntityById(id[0]);
		} else if(id != null){
			smsChannelDao.deleteEntityBatch(id);
		} else {
			log.warn("delete smsChannel by null id");
		}
		log.debug("delete smsChannel success: id = " + id);
	}

	@Override
	public SmsChannel getSmsChannelById(Long id) {
		if (id != null) {
			return smsChannelDao.getEntityById(id);
		}
		log.warn("get smsChannel by null id");
		return null;
	}

	@Override
	public List<SmsChannel> querySmsChannelByCarrier(Carrier carrier) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("carrier", carrier);
		
		return smsChannelDao.queryEntity(param);
	}

	@Override
	public void updateSmsChannel(SmsChannel smsChannel) {
		smsChannel.setOperatorId(getOperatorId());
		smsChannelDao.updateEntity(smsChannel);
		log.debug("update smsChannel success: id=" + smsChannel.getId());
	}

	@Override
	public void operateSmsChannel(SmsChannel smsChannel) {
		if(smsChannel.getPager().isToUpdate()) {
			smsChannel.setOperatorId(getOperatorId());
			ChannelProvider cp = channelProviderDao.getEntityById(smsChannel.getChannelProviderId());
			if(cp != null) {
				smsChannel.setChannelProviderName(cp.getName());
			}
			smsChannelDao.updateEntity(smsChannel);
			log.debug("update smsChannel success: id=" + smsChannel.getId());
		} else if(smsChannel.getPager().isToCreate()){
			smsChannel.setOperatorId(getOperatorId());
			ChannelProvider cp = channelProviderDao.getEntityById(smsChannel.getChannelProviderId());
			if(cp != null) {
				smsChannel.setChannelProviderName(cp.getName());
			}
			smsChannelDao.createEntity(smsChannel);
			log.debug("create smsChannel success: id=" + smsChannel.getId());
		} else {
			smsChannelDao.deleteEntityById(smsChannel.getId());
			log.debug("delete smsChannel success: id=" + smsChannel.getId());
		}
	}

	@Override
	public List<SmsChannel> pageQuerySmsChannel(SmsChannelVo vo) {
		return smsChannelDao.pageQueryEntity(vo);
	}

	@Override
	public List<Area> queryArea(Long parentId, Long channelId) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("parentId", parentId);
		if(parentId == null) param.put("parentId", Constant.INITIAL_ID);
		
		List<Area> list = areaDao.queryEntity(param);
		
		param.clear();
		param.put("smsChannelId", channelId);
		List<Area> assoList = areaDao.queryEntityOfSmsChannel(param);
		
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
	public void associateArea(Long smsChannelId, Long[] areaId) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("smsChannelId", smsChannelId);
		param.put("operatorId", getOperatorId());
		param.put("areaId", fillChildArea(areaId));
		
		smsChannelDao.unassociateWithArea(smsChannelId);
		if(areaId != null && areaId.length > 0){
			smsChannelDao.associateWithArea(param);
		}
	}

}

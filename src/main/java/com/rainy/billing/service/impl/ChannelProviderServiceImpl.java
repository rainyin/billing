package com.rainy.billing.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.dao.ChannelProviderDao;
import com.rainy.billing.entity.ChannelProvider;
import com.rainy.billing.model.ChannelProviderVo;
import com.rainy.billing.service.ChannelProviderService;

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
public class ChannelProviderServiceImpl extends BaseService implements
		ChannelProviderService {
	@Autowired
	private ChannelProviderDao channelProviderDao;

	@Override
	public void deleteChannelProvider(Long... id) {
		if (id != null && id.length == 1) {
			channelProviderDao.deleteEntityById(id[0]);
		} else if(id != null){
			channelProviderDao.deleteEntityBatch(id);
		} else {
			log.warn("delete channelProvider by null id");
		}
		log.debug("delete channelProvider success: id = " + id);
	}

	@Override
	public ChannelProvider getChannelProviderById(Long id) {
		if (id != null) {
			return channelProviderDao.getEntityById(id);
		}
		log.warn("get channelProvider by null id");
		return null;
	}

	@Override
	public List<ChannelProvider> queryChannelProviderByName(String name) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("name", name);
		
		return channelProviderDao.queryEntity(param);
	}

	@Override
	public void updateChannelProvider(ChannelProvider channelProvider) {
		channelProviderDao.updateEntity(channelProvider);
		log.debug("update channelProvider success: id=" + channelProvider.getId());
	}

	@Override
	public void operateChannelProvider(ChannelProvider channelProvider) {
		if(channelProvider.getPager().isToUpdate()) {
			channelProviderDao.updateEntity(channelProvider);
			log.debug("update channelProvider success: id=" + channelProvider.getId());
		} else if(channelProvider.getPager().isToCreate()){
			channelProviderDao.createEntity(channelProvider);
			log.debug("create channelProvider success: id=" + channelProvider.getId());
		} else {
			channelProviderDao.deleteEntityById(channelProvider.getId());
			log.debug("delete channelProvider success: id=" + channelProvider.getId());
		}
	}

	@Override
	public List<ChannelProvider> pageQueryChannelProvider(ChannelProviderVo vo) {
		return channelProviderDao.pageQueryEntity(vo);
	}
	
	@Override
	public String allChannelProviderToString() {
		StringBuilder str = new StringBuilder();
		List<ChannelProvider> list = channelProviderDao.queryEntity(null);
		str.append("<select>");
		str.append("<option value=''>请选择</option>");
		for(ChannelProvider provider : list) {
			str.append("<option");
			str.append(" value='");
			str.append(provider.getId() + "'>");
			str.append(provider.getName());
			str.append("</option>");
		}
		str.append("</select>");
		
		return str.toString();
	}
}

package com.rainy.billing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.dao.ChannelRequestDao;
import com.rainy.billing.entity.ChannelRequest;
import com.rainy.billing.model.ChannelRequestVo;
import com.rainy.billing.service.ChannelRequestService;
/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-28
 * @author rainy
 * @version 1.0
 */
@Service
public class ChannelRequestServiceImpl extends BaseService implements ChannelRequestService {
	
	@Autowired
	private ChannelRequestDao channelRequestDao;

	@Override
	public void createChannelRequest(ChannelRequest request) {
		log.info("create channel request:");
		channelRequestDao.createEntity(request);
	}

	@Override
	public List<ChannelRequest> pageQueryChannelRequest(ChannelRequestVo vo) {
		return channelRequestDao.pageQueryEntity(vo);
	}

}

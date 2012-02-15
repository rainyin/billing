package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.ChannelRequest;
import com.rainy.billing.model.ChannelRequestVo;

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
public interface ChannelRequestService {
	
	void createChannelRequest(ChannelRequest request);
	
	List<ChannelRequest> pageQueryChannelRequest(ChannelRequestVo vo);

}

package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.Area;
import com.rainy.billing.entity.SmsChannel;
import com.rainy.billing.enumeration.Carrier;
import com.rainy.billing.model.SmsChannelVo;

/**
 * Title: <br>
 * Description: <br>
 * ChannelProvider: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-21
 * @author rainy
 * @version 1.0
 */
public interface SmsChannelService {

	SmsChannel getSmsChannelById(Long id);

	void operateSmsChannel(SmsChannel smsChannel);

	void updateSmsChannel(SmsChannel smsChannel);

	void deleteSmsChannel(Long... id);

	List<SmsChannel> querySmsChannelByCarrier(Carrier carrier);

	List<SmsChannel> pageQuerySmsChannel(SmsChannelVo vo);
	
	List<Area> queryArea(Long parentId, Long smsChannelId);
	
	void associateArea(Long smsChannelId, Long[] areaId);

}

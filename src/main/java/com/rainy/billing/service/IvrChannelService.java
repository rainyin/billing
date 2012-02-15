package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.Area;
import com.rainy.billing.entity.IvrChannel;
import com.rainy.billing.model.IvrChannelVo;

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
public interface IvrChannelService {

	IvrChannel getIvrChannelById(Long id);

	void operateIvrChannel(IvrChannel ivrChannel);

	void updateIvrChannel(IvrChannel ivrChannel);

	void deleteIvrChannel(Long... id);

	List<IvrChannel> queryIvrChannelByName(String name);

	List<IvrChannel> pageQueryIvrChannel(IvrChannelVo vo);
	
	List<Area> queryArea(Long parentId, Long ivrChannelId);
	
	void associateArea(Long ivrChannelId, Long[] areaId);

}

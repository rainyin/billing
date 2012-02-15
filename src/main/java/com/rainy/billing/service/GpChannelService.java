package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.Area;
import com.rainy.billing.entity.GpChannel;
import com.rainy.billing.model.GpChannelVo;

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
public interface GpChannelService {

	GpChannel getGpChannelById(Long id);

	void operateGpChannel(GpChannel GpChannel);

	void updateGpChannel(GpChannel GpChannel);

	void deleteGpChannel(Long... id);

	List<GpChannel> queryGpChannelByName(String name);

	List<GpChannel> pageQueryGpChannel(GpChannelVo vo);
	
	List<Area> queryArea(Long parentId, Long GpChannelId);
	
	void associateArea(Long GpChannelId, Long[] areaId);

}

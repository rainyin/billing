package com.rainy.billing.dao;

import java.util.List;
import java.util.Map;

import com.rainy.billing.entity.GpChannel;
import com.rainy.billing.entity.IvrChannel;
import com.rainy.billing.entity.SmsChannel;
import com.rainy.billing.model.report.ReportVo;
import com.rainy.billing.model.report.TerminalByAreaVo;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-12-2
 * @author rainy
 * @version 1.0
 */
public interface ReportDao {
	
	Long allAreaCount();
	
	List<SmsChannel> querySmsChannel();
	
	List<IvrChannel> queryIvrChannel();
	
	List<GpChannel> queryGpChannel();
	
	List<ReportVo> queryTerminal(Map<String, Object> param);
	
	List<ReportVo> queryTerminalByMonth(Map<String, Object> param);
	
	List<TerminalByAreaVo> queryTerminalByArea(Map<String, Object> param);
	
	List<ReportVo> queryChannelRequest(Map<String, Object> param);

}

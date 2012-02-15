package com.rainy.billing.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.Constant;
import com.rainy.billing.dao.AreaDao;
import com.rainy.billing.dao.ProjectDao;
import com.rainy.billing.dao.ReportDao;
import com.rainy.billing.entity.Area;
import com.rainy.billing.entity.GpChannel;
import com.rainy.billing.entity.IvrChannel;
import com.rainy.billing.entity.Project;
import com.rainy.billing.entity.SmsChannel;
import com.rainy.billing.model.report.ChannelReport;
import com.rainy.billing.model.report.ReportData;
import com.rainy.billing.model.report.ReportParameterVo;
import com.rainy.billing.model.report.ReportVo;
import com.rainy.billing.model.report.TerminalByAreaVo;
import com.rainy.billing.service.ReportService;
import com.rainy.billing.util.DateUtil;
import com.rainy.billing.util.SelectionUtil;
import com.rainy.billing.util.VelocityUtil;

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
@Service
public class ReportServiceImpl extends BaseService implements ReportService {
	
	@Autowired
	private VelocityUtil velocityUtil;
	
	@Autowired
	private ReportDao reportDao;
	
	@Autowired
	private AreaDao areaDao;
	
	@Autowired
	private ProjectDao projectDao;

	@Override
	public String smsChannelReport() {
		Long allArea = reportDao.allAreaCount();
		log.info("allArea: " + allArea);
		
		List<SmsChannel> list = reportDao.querySmsChannel();
		List<ChannelReport> channelReports = new ArrayList<ChannelReport>();
		int color = 0;
		for(SmsChannel smsChannel : list) {
			int coverage = Math.round((smsChannel.getAreas().size() * 100 / allArea));
			channelReports.add(new ChannelReport(smsChannel.getBusinessName(), coverage, ++color));
		}
		
		return velocityUtil.generateChartData("report/channel.vm", channelReports);
	}

	@Override
	public String gpChannelReport() {
		Long allArea = reportDao.allAreaCount();
		log.info("allArea: " + allArea);
		
		List<GpChannel> list = reportDao.queryGpChannel();
		List<ChannelReport> channelReports = new ArrayList<ChannelReport>();
		int color = 0;
		for(GpChannel gpChannel : list) {
			int coverage = Math.round((gpChannel.getAreas().size() * 100 / allArea));
			channelReports.add(new ChannelReport(gpChannel.getName(), coverage, ++color));
		}
		return velocityUtil.generateChartData("report/channel.vm", channelReports);
	}

	@Override
	public String ivrChannelReport() {
		Long allArea = reportDao.allAreaCount();
		log.info("allArea: " + allArea);
		
		List<IvrChannel> list = reportDao.queryIvrChannel();
		List<ChannelReport> channelReports = new ArrayList<ChannelReport>();
		int color = 0;
		for(IvrChannel ivrChannel : list) {
			int coverage = Math.round((ivrChannel.getAreas().size() * 100 / allArea));
			channelReports.add(new ChannelReport(ivrChannel.getName(), coverage, ++color));
		}
		
		return velocityUtil.generateChartData("report/channel.vm", channelReports);
	}

	@Override
	public ReportData queryTerminal(ReportParameterVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("projectId", vo.getProjectId());
		param.put("year", vo.getYear());
		param.put("orderBy", vo.getOrderBy());
		param.put("direction", vo.getDirection());
		
		
		return ReportData.createFromReportVo(reportDao.queryTerminal(param), 1);
	}
	
	private Map<Long, String> getAreaMap() {
		Map<Long, String> map = new HashMap<Long, String>();
		
		List<Area> areaList = areaDao.queryEntityOfParent(new Long[]{Constant.INITIAL_ID});
		for(Area area : areaList) {
			map.put(area.getId(), area.getName());
		}
		
		return map;
	}

	@Override
	public ReportData queryTerminalByArea(ReportParameterVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("projectId", vo.getProjectId());
		param.put("startDate", DateUtil.getDateStr(vo.getYearNotNull(), vo.getMonthNotNull()));
		param.put("endDate", DateUtil.getDateStr(vo.getYearNotNull(), vo.getMonthNotNull() + 1));
		
		List<TerminalByAreaVo> list = reportDao.queryTerminalByArea(param);
		Map<Long, String> areaMap = getAreaMap();
		
		Map<Long, ReportVo> result = new HashMap<Long, ReportVo>();
		ReportVo tmp = null;
		Long tmpId = null;
		for(TerminalByAreaVo tvo : list) {
			tmpId = tvo.getParentId();
			if(tvo.getParentId().equals(Constant.INITIAL_ID)) {
				tmpId = tvo.getId();
			}
			tmp = result.get(tmpId);
			if(tmp == null) {
				tmp = new ReportVo();
				tmp.setAreaName(areaMap.get(tmpId));
				tmp.setCount(tvo.getCount());
				result.put(tmpId, tmp);
				
			} else {
				tmp.setCount(tmp.getCount() + tvo.getCount());
			}
		}
		
		return ReportData.createFromReportVo(result.values(), 2);
	}

	@Override
	public ReportData queryChannelRequest(ReportParameterVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("projectId", vo.getProjectId());
		param.put("startDate", DateUtil.getDateStr(vo.getYearNotNull(), vo.getMonthNotNull()));
		param.put("endDate", DateUtil.getDateStr(vo.getYearNotNull(), vo.getMonthNotNull() + 1));
		param.put("orderBy", vo.getOrderBy());
		param.put("direction", vo.getDirection());
		
		return ReportData.createFromReportVo(reportDao.queryChannelRequest(param), 3);
	}

	@Override
	public String projectToString(Long customerId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("customerId", customerId);
		
		List<Project> list = projectDao.queryEntity(param);
		return SelectionUtil.createSelectOptions(list);
	}

	@Override
	public String channelRequestChart(ReportParameterVo vo) {
		ReportData data = queryChannelRequest(vo);
		data.setCaption("访问统计");
		data.setxAxis("日期");
		
		return velocityUtil.generateChartData("report/common.vm", data);
	}

	@Override
	public String terminalByAreaChart(ReportParameterVo vo) {
		ReportData data = queryTerminalByArea(vo);
		data.setCaption("归属地统计");
		data.setxAxis("省份");
		
		return velocityUtil.generateChartData("report/common.vm", data);
	}

	@Override
	public String terminalChart(ReportParameterVo vo) {
		ReportData data = queryTerminal(vo);
		data.setCaption("注册用户统计");
		data.setxAxis("月份");
		
		return velocityUtil.generateChartData("report/common.vm", data);
	}
	@Override
	public ReportData queryTerminalByMonth(ReportParameterVo vo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("projectId", vo.getProjectId());
		param.put("startDate", DateUtil.getDateStr(vo.getYearNotNull(), vo.getMonthNotNull()));
		param.put("endDate", DateUtil.getDateStr(vo.getYearNotNull(), vo.getMonthNotNull() + 1));
		param.put("orderBy", vo.getOrderBy());
		param.put("direction", vo.getDirection());
		
		return ReportData.createFromReportVo(reportDao.queryTerminalByMonth(param), 3);
	}
	
}

package com.rainy.billing.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.rainy.billing.dao.ReportDao;
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
@Repository
public class ReportDaoImpl extends SqlSessionDaoSupport implements ReportDao {
	
	public String nameSpace = this.getClass().getName() + ".";

	@Override
	public Long allAreaCount() {
		return (Long)this.getSqlSession().selectOne(nameSpace + "allAreaCount");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GpChannel> queryGpChannel() {
		return (List<GpChannel>)this.getSqlSession().selectList(nameSpace + "queryGpChannel");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IvrChannel> queryIvrChannel() {
		return (List<IvrChannel>)this.getSqlSession().selectList(nameSpace + "queryIvrChannel");
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<SmsChannel> querySmsChannel() {
		return (List<SmsChannel>)this.getSqlSession().selectList(nameSpace + "querySmsChannel");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReportVo> queryTerminal(Map<String, Object> param) {
		return (List<ReportVo>)this.getSqlSession().selectList(nameSpace + "queryTerminal", param);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReportVo> queryTerminalByMonth(Map<String, Object> param) {
		return (List<ReportVo>)this.getSqlSession().selectList(nameSpace + "queryTerminalByMonth", param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TerminalByAreaVo> queryTerminalByArea(
			Map<String, Object> param) {
		return (List<TerminalByAreaVo>)this.getSqlSession().selectList(nameSpace + "queryTerminalByArea", param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReportVo> queryChannelRequest(
			Map<String, Object> param) {
		return (List<ReportVo>)this.getSqlSession().selectList(nameSpace + "queryChannelRequest", param);
	}

}

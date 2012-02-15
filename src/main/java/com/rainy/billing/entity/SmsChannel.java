package com.rainy.billing.entity;

import java.util.List;

import com.rainy.billing.Constant;
import com.rainy.billing.enumeration.Carrier;
import com.rainy.billing.enumeration.MatchType;
import com.rainy.billing.enumeration.OrderType;
import com.rainy.billing.model.Selectable;
import com.rainy.billing.pagination.Pageable;
import com.rainy.billing.pagination.RowData;
import com.rainy.billing.util.PaginationUtil;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-23
 * @author rainy
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SmsChannel extends BaseEntity implements Pageable, Selectable {

	private String channelProviderName;
	private Long channelProviderId = Constant.INITIAL_ID;;
	private String instruction;
	private String port;
	private String businessName;
	private Integer feeStandard = 0;
	private Carrier carrier = Carrier.CMCC;
	private MatchType matchType = MatchType.FUZZY;
	private OrderType orderType = OrderType.MONTHLY;
	private Integer sendTimes = 0;
	private Integer shieldCycle = 0;
	private String shieldKey;
	private String memo;
	
	private List<Area> areas;

	@Override
	public RowData toRow() {
		RowData row = new RowData();

		row.setId(this.getId().toString());
		row.setCell(PaginationUtil.createCell(getId(), channelProviderId.toString(), channelProviderName,
				instruction, port, businessName, feeStandard.toString(),
				carrier.getInfo(), matchType.getInfo(), orderType.getInfo(),
				shieldCycle.toString(), shieldKey, memo, getCreatedAtString()));

		return row;
	}

	public String getChannelProviderName() {
		return channelProviderName;
	}

	public void setChannelProviderName(String channelProviderName) {
		this.channelProviderName = channelProviderName;
	}

	public Long getChannelProviderId() {
		return channelProviderId;
	}

	public void setChannelProviderId(Long channelProviderId) {
		this.channelProviderId = channelProviderId;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public Integer getFeeStandard() {
		return feeStandard;
	}

	public void setFeeStandard(Integer feeStandard) {
		this.feeStandard = feeStandard;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public MatchType getMatchType() {
		return matchType;
	}

	public void setMatchType(MatchType matchType) {
		this.matchType = matchType;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public Integer getSendTimes() {
		return sendTimes;
	}

	public void setSendTimes(Integer sendTimes) {
		this.sendTimes = sendTimes;
	}

	public Integer getShieldCycle() {
		return shieldCycle;
	}

	public void setShieldCycle(Integer shieldCycle) {
		this.shieldCycle = shieldCycle;
	}

	public String getShieldKey() {
		return shieldKey;
	}

	public void setShieldKey(String shieldKey) {
		this.shieldKey = shieldKey;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	@Override
	public Object getOptionName() {
		return businessName;
	}

	@Override
	public Object getOptionValue() {
		return getId();
	}
	
}

package com.rainy.billing.model;

import com.rainy.billing.enumeration.Carrier;
import com.rainy.billing.enumeration.MatchType;
import com.rainy.billing.enumeration.OrderType;

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
public class SmsChannelVo extends BaseVo {

	private String channelProviderName;
	private Long channelProviderId;
	private String instruction;
	private String port;
	private String businessName;
	private Integer feeStandard;
	private Carrier carrier;
	private MatchType matchType;
	private OrderType orderType;
	private Integer sendTimes;
	private Integer shieldCycle;
	private String shieldKey;
	private String memo;

	private static final String[] orderColumns = { "id",
			"channel_provider_name", "instruction", "port", "bussiness_name",
			"fee_standard", "carrier", "match_type", "order_type",
			"send_times", "shield_cycle", "shield_key", "memo" };

	@Override
	public String[] getOrderColumns() {
		return orderColumns;
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

}

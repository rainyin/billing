package com.rainy.billing.model;

import com.rainy.billing.enumeration.Carrier;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-11-19
 * @author rainy
 * @version 1.0
 */
public class IvrChannelVo extends BaseVo {

	private String channelProviderName;
	private Long channelProviderId;
	private String name;
	private Carrier carrier;
	private String dialNumber;
	private Integer callDuration;
	private Integer price;
	private String keyOrder;
	private String smsKey;
	private String delay;
	private String memo;

	private static final String[] orderColumns = { "id",
			"channel_provider_name", "name", "carrier", "dial_number",
			"call_duration", "price", "key_order", "sms_key", "delay", "memo" };

	@Override
	public String[] getOrderColumns() {
		return orderColumns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDialNumber() {
		return dialNumber;
	}

	public void setDialNumber(String dialNumber) {
		this.dialNumber = dialNumber;
	}

	public Integer getCallDuration() {
		return callDuration;
	}

	public void setCallDuration(Integer callDuration) {
		this.callDuration = callDuration;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getKeyOrder() {
		return keyOrder;
	}

	public void setKeyOrder(String keyOrder) {
		this.keyOrder = keyOrder;
	}

	public String getSmsKey() {
		return smsKey;
	}

	public void setSmsKey(String smsKey) {
		this.smsKey = smsKey;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public String getDelay() {
		return delay;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

}

package com.rainy.billing.entity;

import java.util.List;

import com.rainy.billing.Constant;
import com.rainy.billing.enumeration.Carrier;
import com.rainy.billing.model.Selectable;
import com.rainy.billing.pagination.Pageable;
import com.rainy.billing.pagination.RowData;
import com.rainy.billing.util.PaginationUtil;

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
@SuppressWarnings("serial")
public class IvrChannel extends BaseEntity implements Pageable, Selectable {

	private String channelProviderName;
	private Long channelProviderId = Constant.INITIAL_ID;;
	private String name;
	private Carrier carrier = Carrier.CMCC;
	private String dialNumber;
	private Integer callDuration = 0;
	private Integer price = 0;
	private Integer delay = 0;
	private String keyOrder;
	private String smsKey;
	private String memo;

	private List<Area> areas;

	@Override
	public RowData toRow() {
		RowData row = new RowData();

		row.setId(this.getId().toString());
		row.setCell(PaginationUtil.createCell(getId(), channelProviderId
				.toString(), channelProviderName, name, carrier.getInfo(), dialNumber,
				callDuration.toString(), price.toString(), keyOrder, smsKey,
				delay.toString(), memo, getCreatedAtString()));

		return row;
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

	@Override
	public Object getOptionName() {
		return name;
	}

	@Override
	public Object getOptionValue() {
		return getId();
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

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public Integer getDelay() {
		return delay;
	}

	public void setDelay(Integer delay) {
		this.delay = delay;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

}

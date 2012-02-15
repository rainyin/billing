package com.rainy.billing.entity;

import java.util.List;

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
public class ChannelProvider extends BaseEntity implements Pageable {

	private String name;
	private String tel;
	private String address;
	private String serviceCode;
	private String cutPercent;
	private String memo;
	
	private List<SmsChannel> smsChannels;

	@Override
	public RowData toRow() {
		RowData row = new RowData();

		row.setId(this.getId().toString());
		row.setCell(PaginationUtil.createCell(getId(), name, tel, address, serviceCode, cutPercent, memo, getCreatedAtString()));

		return row;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getCutPercent() {
		return cutPercent;
	}

	public void setCutPercent(String cutPercent) {
		this.cutPercent = cutPercent;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public List<SmsChannel> getSmsChannels() {
		return smsChannels;
	}

	public void setSmsChannels(List<SmsChannel> smsChannels) {
		this.smsChannels = smsChannels;
	}

}

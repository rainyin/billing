package com.rainy.billing.model;

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
public class ChannelProviderVo extends BaseVo {

	private String name;
	private String tel;
	private String address;
	private String serviceCode;
	private String cutPercent;
	private String memo;

	private static final String[] orderColumns = { "id", "name", "tel",
			"address", "service_code", "cut_percent", "memo" };

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

}

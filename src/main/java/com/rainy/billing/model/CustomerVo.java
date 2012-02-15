package com.rainy.billing.model;

import com.rainy.billing.enumeration.ActiveStatus;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-19
 * @author rainy
 * @version 1.0
 */
public class CustomerVo extends BaseVo {

	private static final String[] orderColumns = {"id", "name", "tel", "address", "status", "memo"};

	private String name;
	private String tel;
	private String address;
	private ActiveStatus status;
	private String memo;

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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public ActiveStatus getStatus() {
		return status;
	}

	public void setStatus(ActiveStatus status) {
		this.status = status;
	}
	
}

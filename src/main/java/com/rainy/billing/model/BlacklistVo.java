package com.rainy.billing.model;

import com.rainy.billing.model.BaseVo;

/**
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-11-16
 * @author rainy
 * @version 1.0
 */
public class BlacklistVo extends BaseVo {

	private static final String[] orderColumns = { "id", "phone_number", "memo" };
	private String phoneNumber;
	private String memo;
	
	@Override
	public String[] getOrderColumns() {
		return orderColumns;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	

}

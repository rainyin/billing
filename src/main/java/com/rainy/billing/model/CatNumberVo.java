package com.rainy.billing.model;

import com.rainy.billing.enumeration.ActiveStatus;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-12-7
 * @author rainy
 * @version 1.0
 */
public class CatNumberVo extends BaseVo {

	private static final String[] orderColumns = { "id", "number", "status", "memo" };

	private String number;
	private ActiveStatus status;
	private String memo;

	@Override
	public String[] getOrderColumns() {
		return orderColumns;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public ActiveStatus getStatus() {
		return status;
	}

	public void setStatus(ActiveStatus status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}

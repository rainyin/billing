package com.rainy.billing.entity;

import com.rainy.billing.enumeration.ActiveStatus;
import com.rainy.billing.pagination.Pageable;
import com.rainy.billing.pagination.RowData;
import com.rainy.billing.util.PaginationUtil;

/**
 * Title: <br>
 * Description: 短信猫上可用的手机号 Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-12-7
 * @author rainy
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CatNumber extends BaseEntity implements Pageable {

	private String number;
	private ActiveStatus status = ActiveStatus.ENABLED;
	private String memo;
	
	@Override
	public RowData toRow() {
		RowData row = new RowData();

		row.setId(this.getId().toString());
		row.setCell(PaginationUtil.createCell(getId(), number, status.getInfo(), memo, getCreatedAtString()));

		return row;
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

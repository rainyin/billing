package com.rainy.billing.entity;

import com.rainy.billing.enumeration.ActiveStatus;
import com.rainy.billing.model.Selectable;
import com.rainy.billing.pagination.Pageable;
import com.rainy.billing.pagination.RowData;
import com.rainy.billing.util.PaginationUtil;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-18
 * @author rainy
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Customer extends BaseEntity implements Pageable, Selectable {

	private String name;
	private String tel;
	private String address;
	private String memo;
	private ActiveStatus status = ActiveStatus.ENABLED;
	
	@Override
	public RowData toRow() {
		RowData row = new RowData();

		row.setId(this.getId().toString());
		row.setCell(PaginationUtil.createCell(getId(), name, tel, address, status.getInfo(), memo, getCreatedAtString()));

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

	public ActiveStatus getStatus() {
		return status;
	}

	public void setStatus(ActiveStatus status) {
		this.status = status;
	}

}

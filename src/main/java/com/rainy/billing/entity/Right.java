package com.rainy.billing.entity;

import java.util.HashSet;
import java.util.Set;

import com.rainy.billing.model.Selectable;
import com.rainy.billing.pagination.Pageable;
import com.rainy.billing.pagination.RowData;
import com.rainy.billing.util.PaginationUtil;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-30
 * @author rainy
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Right extends BaseEntity implements Pageable, Selectable {

	private String name; // 功能模块名称
	private String memo; // 功能模块描述
	
	private Set<Resource> resources = new HashSet<Resource>();
	
	@Override
	public RowData toRow() {
		RowData row = new RowData();

		row.setId(this.getId().toString());
		row.setCell(PaginationUtil.createCell(getId(), name, memo, getCreatedAtString()));

		return row;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}

package com.rainy.billing.entity;

import com.rainy.billing.enumeration.ResourceType;
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
public class Resource extends BaseEntity implements Pageable, Selectable {
	
	private String name; // 资源名称
	private String value; // 资源路径 多为url方式
	private ResourceType type = ResourceType.URL;
	
	@Override
	public RowData toRow() {
		RowData row = new RowData();

		row.setId(this.getId().toString());
		row.setCell(PaginationUtil.createCell(getId(), name, value, getCreatedAtString()));

		return row;
	}

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public Object getOptionName() {
		return value;
	}

	@Override
	public Object getOptionValue() {
		return getId();
	}

}

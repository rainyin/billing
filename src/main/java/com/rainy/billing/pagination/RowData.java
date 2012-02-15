package com.rainy.billing.pagination;

import java.util.List;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-11-3
 * @author rainy
 * @version 1.0
 */
public class RowData {

	public String id;

	public List<String> cell;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getCell() {
		return cell;
	}

	public void setCell(List<String> cell) {
		this.cell = cell;
	}

}
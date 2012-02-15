package com.rainy.billing.pagination;

import java.util.List;

import com.rainy.billing.model.BaseVo;
import com.rainy.billing.util.PaginationUtil;

/**
 * 
 * Title: <br>
 * Description: 需要分页的 json 数据格式 Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-19
 * @author rainy
 * @version 1.0
 */
public class PagerVo {

	private String page;
	private String records;
	private String total;
	private List<RowData> rows;

	public PagerVo(BaseVo vo, List<? extends Pageable> entities) {
		this.page = vo.getPage().toString();
		this.records = vo.getTotalCount().toString();
		this.total = (vo.getTotalCount() + vo.getCount() - 1) / vo.getCount()
				+ "";
		this.rows = PaginationUtil.entityToRow(entities);
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRecords() {
		return records;
	}

	public void setRecords(String records) {
		this.records = records;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<RowData> getRows() {
		return rows;
	}

	public void setRows(List<RowData> rows) {
		this.rows = rows;
	}

}

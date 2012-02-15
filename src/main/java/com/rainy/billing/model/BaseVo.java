package com.rainy.billing.model;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-19
 * @author rainy
 * @version 1.0
 */
public abstract class BaseVo {
	
	//for pagination start
	private Long count = 10L;
	private Long posStart = 0L;
	private Long page = 1L;
	private Long totalCount = 0L;
	private String orderBy = "id";
	private String direction = "desc";
	private static final String DIRECTION_ASC = "asc";
	private static final String DIRECTION_DESC = "desc";
	private String[] orderCols = null;
	//for pagination end
	
	private String createdAt;
	private String updatedAt;

	public abstract String[] getOrderColumns();

	public BaseVo() {
		this.orderCols = getOrderColumns();
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long... count) {
		this.count = count[0];
	}

	public Long getPosStart() {
		return posStart;
	}

	public void setPosStart(Long posStart) {
		this.posStart = posStart;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public String getOrderBy() {
		if (orderCols != null) {
			for (String order : orderCols) {
				if (order.replace("_", "").equalsIgnoreCase(orderBy)) {
					return order;
				}
			}
		}

		return "id";
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getDirection() {
		if (direction == null || direction.equalsIgnoreCase(DIRECTION_ASC)) {
			return DIRECTION_ASC;
		}
		return DIRECTION_DESC;
	}

	public void setPage(Long page) {
		this.page = page;
	}
	
	public Long getPage() {
		return this.page;
	}

	public void setRows(Long rows) {
		this.count = rows;
	}

	public void setSidx(String sidx) {
		this.orderBy = sidx;
	}

	public void setSord(String sord) {
		this.direction = sord;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	} 	
	
}

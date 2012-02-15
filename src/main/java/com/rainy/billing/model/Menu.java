package com.rainy.billing.model;

/**
 * Title: <br>
 * Description: 根据权限控制页面显示菜单
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-11-17
 * @author rainy
 * @version 1.0
 */
public class Menu implements Comparable<Menu> {
	
	private String category;
	private Integer order;
	private String name;
	private String url;
	
	/**
	 * @param category
	 * @param order
	 * @param name
	 * @param url
	 */
	public Menu(String category, Integer order, String name, String url) {
		super();
		this.category = category;
		this.order = order;
		this.name = name;
		this.url = url;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int compareTo(Menu o) {
		return this.getOrder() - o.getOrder();
	}
}

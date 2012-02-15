package com.rainy.billing.model;

/**
 * Title: <br>
 * Description: 定义页面上多选框的元素，
 *              需要定义多选框元素的 name 和 value
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 *
 * @2011-11-1
 * @author rainy
 * @version 1.0
 */
public interface Selectable {
	
	/*
	 * opton 用的 value
	 */
	Object getOptionValue();
	
	/*
	 * option 用的 name
	 */
	Object getOptionName();

}

package com.rainy.billing.pagination;

import java.io.Serializable;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-20
 * @author rainy
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Pager implements Serializable {

	private static final String OPERA_ADD = "add";
	private static final String OPERA_EDIT = "edit";
	private static final String OPERA_DEL = "del";
	private String id;
	private String oper = OPERA_ADD;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}
	
	public Boolean isToCreate(){
		if(this.oper.equals(OPERA_ADD)) return true;
		return false;
	}
	
	public Boolean isToUpdate(){
		if(this.oper.equals(OPERA_EDIT)) return true;
		return false;
	}
	
	public Boolean isToDelete(){
		if(this.oper.equals(OPERA_DEL)) return true;
		return false;
	}

}

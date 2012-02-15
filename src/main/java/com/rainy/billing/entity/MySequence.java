package com.rainy.billing.entity;

/**
 * Title: <br>
 * Description: Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-28
 * @author rainy
 * @version 1.0
 */
@SuppressWarnings("serial")
public class MySequence extends BaseEntity {

	private Long sequence = 0L;
	private String name;
	
	public MySequence(){
		
	}

	public MySequence(Long sequence, String name) {
		this.sequence = sequence;
		this.name = name;
	}

	public MySequence(String name) {
		this.name = name;
	}

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

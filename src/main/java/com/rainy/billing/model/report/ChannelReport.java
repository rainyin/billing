package com.rainy.billing.model.report;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-12-2
 * @author rainy
 * @version 1.0
 */
public class ChannelReport {
	
	private static final String[] colors = {"AFD8F8", "F6BD0F", "8BBA00", "FF8E46", "008E8E", "D64646", "8E468E", "588526", "B3AA00", "9D080D" };
	private String name;
	private int coverage;
	private String color;
	
	public ChannelReport(String name, int coverage, int color) {
		this.name = name;
		this.coverage = coverage;
		this.color = colors[color%colors.length];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCoverage() {
		return coverage;
	}

	public void setCoverage(int coverage) {
		this.coverage = coverage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}

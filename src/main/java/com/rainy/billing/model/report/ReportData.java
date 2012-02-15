package com.rainy.billing.model.report;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-12-12
 * @author rainy
 * @version 1.0
 */
public class ReportData {

	private static final String[] colors = {"AFD8F8", "F6BD0F", "8BBA00", "FF8E46", "008E8E", "D64646", "8E468E", "588526", "B3AA00", "9D080D" };
	private String nameHeader;
	private String countHeader;
	private String caption;
	private String xAxis;
	private List<Detail> details;

	public ReportData() {
	}
	
    public static class Detail {
		String name;
		Long count;
		String color;
		
		Detail(String name, Long count) {
			this.name = name;
			this.count = count;
			this.color = colors[count.intValue() % colors.length];
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Long getCount() {
			return count;
		}
		public void setCount(Long count) {
			this.count = count;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
		
	}

	public ReportData(String nameHeader, String countHeader) {
		this.nameHeader = nameHeader;
		this.countHeader = countHeader;
	}

	public static ReportData createFromReportVo(Collection<ReportVo> vos, int type) {
		List<Detail> details = new ArrayList<Detail>();
		
		String nameHeader = null;
		if(type == 1) {
			nameHeader = "yearMonth";
		} else if(type == 2) {
			nameHeader = "areaName";
		} else if(type == 3) {
			nameHeader = "date";
		}
		
		ReportData data = new ReportData(nameHeader, "count");
		data.setDetails(details);

		for (ReportVo vo : vos) {
			String name = null;
			if(type == 1) {
				name = vo.getYearMonth();
			} else if(type == 2) {
				name = vo.getAreaName();
			} else if(type == 3) {
				name = vo.getDate();
			}
			
			details.add(new Detail(name, vo.getCount()));
		}
		
		return data;
	}

	public String getNameHeader() {
		return nameHeader;
	}

	public void setNameHeader(String nameHeader) {
		this.nameHeader = nameHeader;
	}

	public String getCountHeader() {
		return countHeader;
	}

	public void setCountHeader(String countHeader) {
		this.countHeader = countHeader;
	}

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getxAxis() {
		return xAxis;
	}

	public void setxAxis(String xAxis) {
		this.xAxis = xAxis;
	}

}

package com.rainy.billing.entity;

import com.rainy.billing.pagination.Pageable;
import com.rainy.billing.pagination.RowData;
import com.rainy.billing.util.PaginationUtil;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-11-21
 * @author rainy
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Terminal extends BaseEntity implements Pageable {

	private String uid;
	private String imsi;
	private String number;
	private Long projectId;
	private String projectName;
	private String carrier;
	private String areaCode;
	private String catNumber; // 对应猫上可用的手机号
	private String version;

	public Terminal() {
	}

	public Terminal(String uid, String imsi, Long projectId, String projectName, String carrier,
			String areaCode, String catNumber, String version) {
		this.uid = uid;
		this.projectId = projectId;
		this.projectName = projectName;
		this.carrier = carrier;
		this.areaCode = areaCode;
		this.catNumber = catNumber;
		this.version = version;
		this.imsi = imsi;
	}

	@Override
	public RowData toRow() {
		RowData row = new RowData();

		row.setId(this.getId().toString());
		row.setCell(PaginationUtil.createCell(getId(), uid, imsi, number,
				projectName, carrier, areaCode, catNumber, version,
				getCreatedAtString(), getUpdatedAtString()));

		return row;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCatNumber() {
		return catNumber;
	}

	public void setCatNumber(String catNumber) {
		this.catNumber = catNumber;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

}

package com.rainy.billing.model;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-12-26
 * @author rainy
 * @version 1.0
 */
public class TerminalVo extends BaseVo {

	private static final String[] orderColumns = { "id", "uid", "imsi", "number",
			"project_name", "carrier", "area_code", "cat_number", "version",
			"project_id", "created_at", "updated_at" };
	
	private String uid;
	private String imsi;
	private String number;
	private Long projectId;
	private String projectName;
	private String carrier;
	private String areaCode;
	private String catNumber; // 对应猫上可用的手机号
	private String version;

	@Override
	public String[] getOrderColumns() {
		return orderColumns;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

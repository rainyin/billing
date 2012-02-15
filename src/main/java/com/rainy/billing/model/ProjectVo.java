package com.rainy.billing.model;

import com.rainy.billing.enumeration.ProjectStatus;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-21
 * @author rainy
 * @version 1.0
 */
public class ProjectVo extends BaseVo {

	private static final String[] orderColumns = { "id", "name", "code", "customer_name",
			"status", "cellphone_schema", "cellphone_resolution", "keyboard",
			"touch", "shield_sms", "monthly_fee", "deduct_fee", "shield_cycle", 
			"synchronize_cycle", "valid_start", "valid_end", "switch_server", "extension", "memo" };

	private String name;
	private String customerName;
	private Long customerId;
	private ProjectStatus status;
	private String cellphoneSchema;
	private String cellphoneResolution;
	private Boolean keyboard;
	private Boolean touch;
	private Boolean shieldSms;
	private Integer monthlyFee;
	private Boolean deductFee;
	private Integer shieldCycle;
	private Integer synchronizeCycle;
	private Integer validStart;
	private Integer validEnd;
	private String switchServer;
	private String extension;
	private String memo;

	@Override
	public String[] getOrderColumns() {
		return orderColumns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public String getCellphoneSchema() {
		return cellphoneSchema;
	}

	public void setCellphoneSchema(String cellphoneSchema) {
		this.cellphoneSchema = cellphoneSchema;
	}

	public String getCellphoneResolution() {
		return cellphoneResolution;
	}

	public void setCellphoneResolution(String cellphoneResolution) {
		this.cellphoneResolution = cellphoneResolution;
	}

	public Boolean getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Boolean keyboard) {
		this.keyboard = keyboard;
	}

	public Boolean getTouch() {
		return touch;
	}

	public void setTouch(Boolean touch) {
		this.touch = touch;
	}

	public Boolean getShieldSms() {
		return shieldSms;
	}

	public void setShieldSms(Boolean shieldSms) {
		this.shieldSms = shieldSms;
	}

	public Integer getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(Integer monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public Boolean getDeductFee() {
		return deductFee;
	}

	public void setDeductFee(Boolean deductFee) {
		this.deductFee = deductFee;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getShieldCycle() {
		return shieldCycle;
	}

	public void setShieldCycle(Integer shieldCycle) {
		this.shieldCycle = shieldCycle;
	}

	public Integer getSynchronizeCycle() {
		return synchronizeCycle;
	}

	public void setSynchronizeCycle(Integer synchronizeCycle) {
		this.synchronizeCycle = synchronizeCycle;
	}

	public Integer getValidStart() {
		return validStart;
	}

	public void setValidStart(Integer validStart) {
		this.validStart = validStart;
	}

	public Integer getValidEnd() {
		return validEnd;
	}

	public void setValidEnd(Integer validEnd) {
		this.validEnd = validEnd;
	}

	public String getSwitchServer() {
		return switchServer;
	}

	public void setSwitchServer(String switchServer) {
		this.switchServer = switchServer;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
}

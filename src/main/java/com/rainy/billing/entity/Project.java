package com.rainy.billing.entity;

import java.util.List;

import com.rainy.billing.Constant;
import com.rainy.billing.enumeration.ProjectStatus;
import com.rainy.billing.model.Selectable;
import com.rainy.billing.pagination.Pageable;
import com.rainy.billing.pagination.RowData;
import com.rainy.billing.util.PaginationUtil;

/**
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
public class Project extends BaseEntity implements Pageable, Selectable {

	private String name;
	private String customerName;
	private Long customerId = Constant.INITIAL_ID;;
	private ProjectStatus status = ProjectStatus.FORMAL;
	private String cellphoneSchema;
	private String cellphoneResolution;
	private Boolean keyboard = true;
	private Boolean touch = true;
	private Boolean shieldSms = true;
	private Integer monthlyFee = 0;
	private Boolean deductFee = true;
	private Integer shieldCycle = 0;
	private Integer synchronizeCycle = 0;
	private Integer validStart = 0;
	private Integer validEnd = 0;
	private String switchServer;
	private String extension;
	private String memo;

	private List<SmsChannel> smsChannels;
	private List<IvrChannel> ivrChannels;
	private List<GpChannel> gpChannels;

	@Override
	public RowData toRow() {
		RowData row = new RowData();

		row.setId(this.getId().toString());
		row.setCell(PaginationUtil.createCell(getId(), customerId.toString(), name, customerName, status.getInfo(), cellphoneSchema,
				cellphoneResolution, keyboardToString(), touchToString(),
				shieldSmsToString(), monthlyFee.toString(),
				deductFeeToString(), shieldCycle.toString(),
				synchronizeCycle.toString(), validStart.toString(),
				validEnd.toString(), extension, switchServer, memo, getCreatedAtString()));

		return row;
	}

	public String smsChannelsToString() {
		StringBuilder str = new StringBuilder();
		if (smsChannels != null && smsChannels.size() > 0) {
			for (SmsChannel ch : smsChannels) {
				str.append(ch.getBusinessName());
				str.append(",");
			}
			str.deleteCharAt(str.lastIndexOf(","));
		}
		return str.toString();
	}

	public String ivrChannelsToString() {
		StringBuilder str = new StringBuilder();
		if (ivrChannels != null && ivrChannels.size() > 0) {
			for (IvrChannel ich : ivrChannels) {
				str.append(ich.getName());
				str.append(",");
			}
			str.deleteCharAt(str.lastIndexOf(","));
		}
		return str.toString();
	}
	
	public String GpChannelsToString() {
		StringBuilder str = new StringBuilder();
		if (gpChannels != null && gpChannels.size() > 0) {
			for (GpChannel Gch : gpChannels) {
				str.append(Gch.getName());
				str.append(",");
			}
			str.deleteCharAt(str.lastIndexOf(","));
		}
		return str.toString();
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

	public String keyboardToString() {
		if (keyboard)
			return "键盘";
		return "无键盘";
	}

	public void setKeyboard(Boolean keyboard) {
		this.keyboard = keyboard;
	}

	public Boolean getTouch() {
		return touch;
	}

	public String touchToString() {
		if (touch)
			return "触摸";
		return "无触摸";
	}

	public void setTouch(Boolean touch) {
		this.touch = touch;
	}

	public Boolean getShieldSms() {
		return shieldSms;
	}

	public String shieldSmsToString() {
		if (shieldSms)
			return "屏蔽";
		return "不屏蔽";
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

	public String deductFeeToString() {
		if (deductFee)
			return "扣费";
		return "不扣费";
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

	public List<IvrChannel> getIvrChannels() {
		return ivrChannels;
	}

	public void setIvrChannels(List<IvrChannel> ivrChannels) {
		this.ivrChannels = ivrChannels;
	}

	public List<GpChannel> getGpChannels() {
		return gpChannels;
	}

	public void setGpChannels(List<GpChannel> gpChannels) {
		this.gpChannels = gpChannels;
	}

	public List<SmsChannel> getSmsChannels() {
		return smsChannels;
	}

	public void setSmsChannels(List<SmsChannel> smsChannels) {
		this.smsChannels = smsChannels;
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

	@Override
	public Object getOptionName() {
		return this.name;
	}

	@Override
	public Object getOptionValue() {
		return getId();
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
}

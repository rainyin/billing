package com.rainy.billing.entity;

import java.util.List;

import com.rainy.billing.Constant;
import com.rainy.billing.model.Selectable;
import com.rainy.billing.pagination.Pageable;
import com.rainy.billing.pagination.RowData;
import com.rainy.billing.util.PaginationUtil;

/**
 * Title: <br>
 * Description: G+ 通道 G plus Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-11-19
 * @author rainy
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GpChannel extends BaseEntity implements Pageable, Selectable {

	private String channelProviderName;
	private Long channelProviderId = Constant.INITIAL_ID;;
	private String name;
	private String url;
	private Integer price = 0;
	private String custSteps;
	private Integer cancelDay;
	private String cancelInstruction;
	private String instructionTo;
	private String custShieldKey;
	private String cancelShieldKey;
	private Integer shieldCycle;
	private String phoneModel;
	private String xWapProfile;
	private String memo;

	private List<Area> areas;

	@Override
	public RowData toRow() {
		RowData row = new RowData();

		row.setId(this.getId().toString());
		row.setCell(PaginationUtil.createCell(getId(), channelProviderId.toString(), channelProviderName, name, url,
				price.toString(), custSteps, cancelDay.toString(), cancelInstruction,
				instructionTo, custShieldKey, cancelShieldKey, shieldCycle.toString(), phoneModel, xWapProfile, memo, getCreatedAtString()));

		return row;
	}

	public String getChannelProviderName() {
		return channelProviderName;
	}

	public void setChannelProviderName(String channelProviderName) {
		this.channelProviderName = channelProviderName;
	}

	public Long getChannelProviderId() {
		return channelProviderId;
	}

	public void setChannelProviderId(Long channelProviderId) {
		this.channelProviderId = channelProviderId;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCustSteps() {
		return custSteps;
	}

	public void setCustSteps(String custSteps) {
		this.custSteps = custSteps;
	}

	public Integer getCancelDay() {
		return cancelDay;
	}

	public void setCancelDay(Integer cancelDay) {
		this.cancelDay = cancelDay;
	}

	public String getCancelInstruction() {
		return cancelInstruction;
	}

	public void setCancelInstruction(String cancelInstruction) {
		this.cancelInstruction = cancelInstruction;
	}

	public String getInstructionTo() {
		return instructionTo;
	}

	public void setInstructionTo(String instructionTo) {
		this.instructionTo = instructionTo;
	}

	public String getCustShieldKey() {
		return custShieldKey;
	}

	public void setCustShieldKey(String custShieldKey) {
		this.custShieldKey = custShieldKey;
	}

	public String getCancelShieldKey() {
		return cancelShieldKey;
	}

	public void setCancelShieldKey(String cancelShieldKey) {
		this.cancelShieldKey = cancelShieldKey;
	}

	public Integer getShieldCycle() {
		return shieldCycle;
	}

	public void setShieldCycle(Integer shieldCycle) {
		this.shieldCycle = shieldCycle;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	@Override
	public Object getOptionName() {
		return name;
	}

	@Override
	public Object getOptionValue() {
		return getId();
	}

	public String getPhoneModel() {
		return phoneModel;
	}

	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}

	public String getxWapProfile() {
		return xWapProfile;
	}

	public void setxWapProfile(String xWapProfile) {
		this.xWapProfile = xWapProfile;
	}

}

package com.rainy.billing.entity;

import com.rainy.billing.model.service.ChanRequest;
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
 * @2011-10-28
 * @author rainy
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ChannelRequest extends BaseEntity implements Pageable {

	private String uid;
	private String imsi;
	private Long projectId;
	private String sc;
	private String plmn;
	private String ver;
	private String projectName;

	public ChannelRequest() {

	}

	public ChannelRequest(ChanRequest request) {
		this.imsi = request.getImsi();
		this.sc = request.getSc();
		this.uid = request.getUid();
		this.plmn = request.getPlmn();
		this.projectId = Long.valueOf(request.getProjectid());
		this.ver = request.getVer();
	}

	@Override
	public RowData toRow() {
		RowData row = new RowData();

		row.setId(this.getId().toString());
		row.setCell(PaginationUtil.createCell(getId(), uid, imsi, sc, plmn,
				projectName, ver, getCreatedAtString()));

		return row;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getPlmn() {
		return plmn;
	}

	public void setPlmn(String plmn) {
		this.plmn = plmn;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

}

package com.rainy.billing.model.service;

/**
 * Title: <br>
 * Description: 手机端退订G+请求格式 
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-12-9
 * @author rainy
 * @version 1.0
 */
public class CancelRequest {

	// 手机卡唯一识别号码
	private String imsi;
	// 系统分配项目id
	private String projectid;
	// 系统分配项目名称
	private String projectName;
	// 运营商
	private String plmn;
	// 区号
	private String sc;
	// 系统分配流水号
	private String uid;
	// 手机客户端版本号
	private String ver;

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getPlmn() {
		return plmn;
	}

	public void setPlmn(String plmn) {
		this.plmn = plmn;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
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
	
	/*
	 * 相关字段的验证
	 */
	public Boolean isValid() {
		if (imsi == null || imsi.trim().length() == 0) {
			return false;
		}
		if (uid == null || uid.trim().length() == 0) {
			return false;
		}
		if (projectid == null || projectid.trim().length() == 0) {
			return false;
		}
		if (plmn == null || plmn.trim().length() == 0) {
			return false;
		}
		if (sc == null || sc.trim().length() == 0) {
			return false;
		}
		if (ver == null || ver.trim().length() == 0) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "CancelGpRequest [imsi=" + imsi + ", plmn=" + plmn
				+ ", projectName=" + projectName + ", projectid=" + projectid
				+ ", sc=" + sc + ", uid=" + uid + ", ver=" + ver + "]";
	}

	
}

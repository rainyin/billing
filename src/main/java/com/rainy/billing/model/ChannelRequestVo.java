package com.rainy.billing.model;

/**
 * Title: <br>
 * Description: 手机端通道请求格式
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-27
 * @author rainy
 * @version 1.0
 */
public class ChannelRequestVo extends BaseVo {
	
	private static final String[] orderColumns = {"id", "imsi", "project_name", "uid", "ver", "created_at"};

	//手机卡唯一识别号码  
	private String imsi;
	//系统分配项目id  
	private String projectid;
	//系统分配项目名称  
	private String projectName;
	//运营商  
	private String plmn;
	//区号 
	private String sc;
	//系统分配流水号
	private String uid;
	//手机客户端版本号
	private String ver;
	
	@Override
	public String[] getOrderColumns() {
		return orderColumns;
	}

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
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}
	
	public Boolean isUidValid() {
		if(uid != null && Long.valueOf(uid) > 0) {
			return true;
		}
		return false;
	}

}

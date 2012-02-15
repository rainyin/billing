package com.rainy.billing.model.service;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.com Inc. All rights reserved.<br>
 * 
 * @2011-12-22
 * @author rainy
 * @version 1.0
 */
public class McatRequest {

	private String p; // project id
	private String fun; // svn: 同步 cat：收到服务器cat 后的注册 g2s:gprs同步失败后的sms同步
	private String u; // uid
	private String sc; // 归属地
	private String plmn; // 运营商编码
	private String imsi; // 手机卡唯一标识
	private String ver; // 客户端版本号
	private String phone;// 手机号

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getFun() {
		return fun;
	}

	public void setFun(String fun) {
		this.fun = fun;
	}

	public String getU() {
		return u;
	}

	public void setU(String u) {
		this.u = u;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String cc) {
		this.sc = cc;
	}

	public String getPlmn() {
		return plmn;
	}

	public void setPlmn(String plmn) {
		this.plmn = plmn;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public Boolean isUidValid() {
		if (u != null && u.startsWith("2")) {
			return true;
		}
		
		return false;
	}

	/*
	 * 相关字段的验证
	 */
	public Boolean isValid() {
		if (imsi == null || imsi.trim().length() == 0) {
			return false;
		}
		if (p == null || p.trim().length() == 0) {
			return false;
		}
		if (plmn == null || plmn.trim().length() == 0) {
			return false;
		}
		if (sc == null || sc.trim().length() == 0) {
			return false;
		}
		if (phone == null || phone.trim().length() == 0) {
			return false;
		}
		if (ver == null || ver.trim().length() == 0) {
			ver = "001";
		}

		return true;
	}

	
	@Override
	public String toString() {
		return "McatRequest [cc=" + sc + ", fun=" + fun + ", imsi=" + imsi
				+ ", p=" + p + ", phone=" + phone + ", plmn=" + plmn + ", u="
				+ u + ", ver=" + ver + "]";
	}

}

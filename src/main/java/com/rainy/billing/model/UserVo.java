package com.rainy.billing.model;

import com.rainy.billing.enumeration.UserStatus;

/**
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-29
 * @author rainy
 * @version 1.0
 */
public class UserVo extends BaseVo {

	private static final String[] orderColumns = { "id", "name", "username",
			"status", "address", "tel", "email", "memo", "created_at" };

	private String name;
	private String address;
	private String tel;
	private String email;
	private String memo;

	private String username; // 登录名
	private UserStatus status; // 激活状态

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

}

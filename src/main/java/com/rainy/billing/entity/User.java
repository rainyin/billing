package com.rainy.billing.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import com.rainy.billing.enumeration.UserStatus;
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
 * @2011-10-29
 * @author rainy
 * @version 1.0
 */
@SuppressWarnings("serial")
public class User extends BaseEntity implements Pageable, UserDetails {

	private String name;
	private String username; // 登录名
	private UserStatus status = UserStatus.ENABLED; // 激活状态
	private String password;
	private String address;
	private String tel;
	private String email;
	private String memo;
	
	private Long roleId;
	private List<Role> roles;
	private List<Right> rights = new ArrayList<Right>();
	
	@Override
	public RowData toRow() {
		RowData row = new RowData();

		row.setId(this.getId().toString());
		row.setCell(PaginationUtil.createCell(getId(), name, username, rolesToString(), status.getInfo(), address, tel, email, memo, getCreatedAtString()));

		return row;
	}
	
	private String rolesToString(){
		StringBuilder str = new StringBuilder();
		if(roles != null && roles.size() > 0){
			for(Role role : roles) {
				str.append(role.getName());
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String phone) {
		this.tel = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (Right right : rights) {
			authorities.add(new GrantedAuthorityImpl(right.getName()));
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return UserStatus.ENABLED.equals(status);
	}

	public List<Right> getRights() {
		return rights;
	}

	public void setRights(List<Right> rights) {
		this.rights = rights;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
}

package com.springboot.springb.modules.user.entity;

import java.util.List;

public class Menu {
	/*权限id*/
	private int mId;
	/*权限名*/
	private String mName;
	/*权限地址*/
	private String mUrl;
	/*拥有该权限的所有角色*/
	private List<Role> roles;
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmUrl() {
		return mUrl;
	}
	public void setmUrl(String mUrl) {
		this.mUrl = mUrl;
	}
	
 
}

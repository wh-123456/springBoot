package com.springboot.springb.modules.user.entity;

public class User {
	/*用户编号——员工编号*/
	private String uWnum;
	/*用户名*/
	private String uName;
	/*密码*/
	private String uPassword;
	/*角色ID*/
	private int fkRoId;
	/*角色*/
	private Role role;
	
	public int getFkRoId() {
		return fkRoId;
	}
	public void setFkRoId(int fkRoId) {
		this.fkRoId = fkRoId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getuWnum() {
		return uWnum;
	}
	public void setuWnum(String uWnum) {
		this.uWnum = uWnum;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	

}

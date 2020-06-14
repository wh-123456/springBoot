package com.springboot.springb.modules.user.entity;

import java.util.List;

public class Role {
	/*角色id*/
	private int rId;
	/*角色名称*/
	private String rName;
	/*角色拥有的所有权限*/
	private List<Menu> menus;
	
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	

}

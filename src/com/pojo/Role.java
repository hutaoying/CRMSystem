package com.pojo;

import java.util.HashSet;
import java.util.Set;



public class Role {

	private long role_id;
	private String role_name;
	private String role_memo;
	
	//
private Set<User> setUser=new HashSet<User>();
	
	public Set<User> getSetUser() {
		return setUser;
	}
	public void setSetUser(Set<User> setUser) {
		this.setUser = setUser;
	}
	//
	
	
	
	
	
	
	public long getRole_id() {
		return role_id;
	}
	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_memo() {
		return role_memo;
	}
	public void setRole_memo(String role_memo) {
		this.role_memo = role_memo;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", role_memo=" + role_memo + "]";
	}
	
}

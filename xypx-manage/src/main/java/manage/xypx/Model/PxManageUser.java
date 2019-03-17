package manage.xypx.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import manage.xypx.Enums.PxManageRole;

public class PxManageUser {
	private String user;
	private String role;
	
	
	private String pwd;
	
	
	public String pwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "PxManageUser [user=" + user + ", role=" + role + "]";
	}
	
	public PxManageRole role() {
		if(role.equals("admin"))return PxManageRole.ADMIN;
		return PxManageRole.NORMAL;
	}
	
}

package com.moive.web.admin;

import com.movie.web.member.MemberBean;

public class AdminBean extends MemberBean{
	private String role;
	private String admin;

	public String getrole() {
		return role;
	}

	public void setrole(String role) {
		this.role = role;
	}

	/**
	 * @return the admin
	 */
	public String getAdmin(String id,String password) {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(String admin) {
		this.admin = admin;
	}
}

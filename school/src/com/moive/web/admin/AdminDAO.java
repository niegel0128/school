/**
 * 
 */
package com.moive.web.admin;

/**
 * @file AdminDao.java
 * @author CSY
 * @date 2016. 3. 23.
 * @stroy	
 */
public interface AdminDAO {
	public AdminBean selectAdmin();

	AdminBean selectAdmin(AdminBean admin);
	
	
	
}

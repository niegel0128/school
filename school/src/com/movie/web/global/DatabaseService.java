/**
 * 
 */
package com.movie.web.global;

import java.sql.Connection;

/**
 * @file DatabaseService.java
 * @author CSY
 * @date 2016. 3. 22.
 * @stroy	
 */
public interface DatabaseService {
	public Connection getConnection();
	
}

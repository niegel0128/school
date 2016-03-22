/**
 * 
 */
package com.movie.web.global;

import java.sql.Connection;

import com.sun.org.apache.regexp.internal.recompile;

/**
 * @file DatabaseFactory.java
 * @author CSY
 * @date 2016. 3. 22.
 * @stroy	
 */
public class DatabaseFactory {
	public static DatabaseService getDatabase(Vender vender,String id,String password) {
		String driver = null,url = null;
		switch(vender){
		case ORACLE:
			driver = Constants.ORACLE_DRIVER;
			url = Constants.ORACLE_URL;
			break;
		case MYSQL:break;
		case MSSQL:break;
		}
		
		return new DatabaseServiceImpl (driver,url,id,password);

	}
}
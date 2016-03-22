/**
 * 
 */
package com.movie.web.global;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @file DispatcherServlet.java
 * @author CSY
 * @date 2016. 3. 23.
 * @stroy	
 */

public class DispatcherServlet {
	public static void gotoDis(HttpServletRequest request, HttpServletResponse response, String view){
		try {
			RequestDispatcher dis = request.getRequestDispatcher(view);
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}

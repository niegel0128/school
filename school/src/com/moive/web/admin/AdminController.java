package com.moive.web.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Separator;
import com.movie.web.member.MemberBean;

/**
 * Servlet implementation class adminController
 */
@WebServlet("/admin/admin_form.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				System.out.println("인덱스에서 들어옴");
		    	Command command = new Command();
		    	MemberBean member = new MemberBean();
		    	String[] arr = Separator.doSomething(request);
		    	String directory = arr[0],action = arr[1];
		    	
		    	switch (action) {
		    	case "admin_from" : command =CommandFactory.createCommand(directory,action); break;
				default:
					command = CommandFactory.createCommand(directory,action);
					break;
				}
		    	DispatcherServlet.gotoDis(request, response, command.getView());
			}
	}

package com.movie.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.movie.web.global.*;

/**
 * Servlet implementation class adminController
 */
@WebServlet({ "/admin/admin_form.do", "/admin/admin_login.do", "/admin/login.do" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("인덱스에서 들어옴");
		Command command = new Command();
		AdminBean admin = new AdminBean();
		HttpSession session = request.getSession();
		AdminService service = AdminServiceImpl.getInstance();
		String[] arr = Separator.doSomething(request);
		String directory = arr[0], action = arr[1];

		switch (action) {
		case "admin_from":
			command = CommandFactory.createCommand(directory, action);
			break;
		case "admin_login":
			System.out.print("admin_login");
			System.out.println(directory);
			System.out.println(action);
			command = CommandFactory.createCommand(directory, action);
			break;
		case "login":
			System.out.println("관리자 로그인 진입");
			admin.setId(request.getParameter("id"));
			admin.setPassword(request.getParameter("password"));
			AdminBean temp = service.getAdmin(admin);
			System.out.println(temp);
			if (temp == null) {
				System.out.println("관리자 로그인 실패");
				command = CommandFactory.createCommand(directory, "admin_login");
			} else {
				System.out.println("관리자 로그인 성공");
				session.setAttribute("use", admin); // 왜
				command = CommandFactory.createCommand(directory, "admin_form");
			}
			break;

		default:
			command = CommandFactory.createCommand(directory, action);
			break;
		}
		DispatcherServlet.gotoDis(request, response, command.getView());
	}
}

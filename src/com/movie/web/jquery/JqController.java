package com.movie.web.jquery;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Separator;

/**
 * @file Jqcontroller.java
 * @author CSY
 * @date 2016. 3. 25.
 * @stroy
 */
@WebServlet({ "/jquery/attr.do", "/jquery/core.do", "/jquery/dom.do", "/jquery/event.do", "/jquery/selector.do",
		"/jquery/traversing.do" })
public class JqController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DispatcherServlet.gotoDis(request, response, CommandFactory
				.createCommand(Separator.doSomething(request)[0], Separator.doSomething(request)[1]).getView());
	}
}

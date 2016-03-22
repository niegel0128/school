package com.movie.web.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Separator;

@WebServlet({"/member/login_form.do",
	"/member/join_form.do","/member/update_form.do",
	"/member/join.do","/member/update.do","/member/delete.do",
	"/member/login.do" , "/member/list.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service = MemberServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("인덱스에서 들어옴");
    	Command command = new Command();
    	MemberBean member = new MemberBean();
    	HttpSession session = request.getSession();
    	String[] arr = Separator.doSomething(request);
    	String directory = arr[0],action = arr[1];
    	List<MemberBean> list = new Arraylist<>();
    	switch (action) {
    
		case "update_form":
			System.out.println("=== 수정폼으로 진입 ===");
			command = CommandFactory.createCommand(directory,action);
			break;
		case "delete" : 
			String id = request.getParameter("id");
			System.out.println("넘어온 아이디" + id);
			if (service.delete(id) == 1) {
				System.out.println("삭제성공");
				command = CommandFactory.createCommand(directory,"login_form");
			} else{
				System.out.println("삭제실패");
				command = CommandFactory.createCommand(directory,"detail");
			}
			break;
		case "join":
			System.out.println("join.do 진입");
			member.setId(request.getParameter("id"));
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth")));
			if(service.join(member)==1){
				command = CommandFactory.createCommand(directory, "login_form");
			}else{
				command = CommandFactory.createCommand(directory, "join_form");
			}
			break;
		case "update":
			member.setId(request.getParameter("id"));
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth")));
			if(service.update(member)==1){
				System.out.println("컨트롤러에서 수정성공");
				session.setAttribute("user", service.detail(request.getParameter("id")));
				command = CommandFactory.createCommand(directory, "detail");
			}else{
				System.out.println("컨트롤러에서 수정실패");
				command = CommandFactory.createCommand(directory, "update_form");
			}
			break;
		case "login" :
			if (service.isMember(request.getParameter("id")) == true) {
				System.out.println("====  아이디가 존재함 ===========");
				member = service.login(request.getParameter("id"), request.getParameter("password"));
				if (member == null) {
					command = CommandFactory.createCommand(directory,"login_form");
				}else{
					System.out.println("로그인 성공");
					session.setAttribute("use", member); //왜
					command = CommandFactory.createCommand(directory,"detail");
				}
			} else {
				System.out.println("====  로그인 실패 ===========");
				command = CommandFactory.createCommand(directory,"login_form");
			}
			break;
		case "login_form" :
			command = CommandFactory.createCommand(directory,"login_form");
			break;
		case "logout" : 
			session.invalidate();
			command = CommandFactory.createCommand(directory,"login_form");
			break;
		case "list":
			
			break;
		default:
			command = CommandFactory.createCommand(directory,action);
			break;
		}
    	DispatcherServlet.gotoDis(request, response, command.getView());
		System.out.println("오픈될 페이지 :"+command.getView());
	}
}

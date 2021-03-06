package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;
import com.movie.web.member.MemberService;
import com.movie.web.member.MemberServiceImpl;

/**
 * @file AdminServiceImpl.java
 * @author CSY
 * @date 2016. 3. 23.
 * @stroy	
 */
public class AdminServiceImpl implements AdminService {
	
	private static AdminService instance = new AdminServiceImpl(); // 싱글톤
	AdminDAO dao = AdminDAOImpl.getInstance();
	
	public static AdminService getInstance() {
		return instance;
	}

	public static void setInstance(AdminService instance) {
		AdminServiceImpl.instance = instance;
	}

	@Override
	public List<GradeMemberBean> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addSource(GradeMemberBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AdminBean getAdmin(AdminBean admin) {
		AdminBean temp = new AdminBean();
		temp = dao.selectAdmin(admin);
		if (temp != null) {
			System.out.println("어드민 서비스 : 관리자가 널이 아님");
			return temp;
		} else {
			System.out.println("어드민 서비스 : 관리자가 널임");
			return null;
		}
	}

}

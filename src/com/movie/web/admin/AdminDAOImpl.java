package com.movie.web.admin;

import java.sql.*;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vender;
import com.movie.web.member.MemberBean;
import com.movie.web.member.MemberDAO;
import com.movie.web.member.MemberDAOImpl;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vender;

/**
 * @file AdminDAOImpl.java
 * @author CSY
 * @date 2016. 3. 23.
 * @stroy	
 */
public class AdminDAOImpl implements AdminDAO{

	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체2
	private ResultSet rs; // 리턴값 회수 객체
	private static AdminDAO instance = new AdminDAOImpl();
	
	public static AdminDAO getInstance(){
		return instance;
	}
	
	public AdminDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vender.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
	}
	
	@Override
	public AdminBean selectAdmin(AdminBean admin) {
		AdminBean temp = new AdminBean();
		try {
			System.out.println("넘어온 admin id " + admin.getId());
			pstmt = conn.prepareStatement("SELECT * FROM Member WHERE id =? and password=? ");
			pstmt.setString(1, admin.getId());
			pstmt.setString(2, admin.getPassword());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
				temp.setBirth(rs.getInt("role"));
			}
			
		} catch (Exception e) {
			System.out.println("selectMember() 에서 에러 발생함 !!");
			e.printStackTrace();
		}
		System.out.println("쿼리 조회 결과 :"+temp.getAddr());
		return temp;
	}
}

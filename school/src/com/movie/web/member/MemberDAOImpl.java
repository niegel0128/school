package com.movie.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vender;

public class MemberDAOImpl implements MemberDAO{
	
	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체2
	private ResultSet rs; // 리턴값 회수 객체
	private static MemberDAO instance = new MemberDAOImpl();

	public static MemberDAO getInstance(){
		return instance;
	}
	
	
	public MemberDAOImpl() {
		// TODO Auto-generated constructor stub
		conn = DatabaseFactory.getDatabase(Vender.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
	}
	
	@Override
	public int insert(MemberBean member) {
		try {
			pstmt = conn.prepareStatement("INSERT INTO Member(id,name,password,addr,birth) VALUES (?,?,?,?,?);");
			pstmt.setString(1, member.getId()); //1번째에는  member.getId()를 집어넣음
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getAddr());
			pstmt.setInt(5, member.getBirth());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("회원가입 성공여부 : " + 0 );
		return 0;
	}

	@Override
	public MemberBean selectById(String id, String password) {
		MemberBean temp = new MemberBean();
		try {
			stmt = conn.createStatement();	
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id ='"+id+"' and password = '"+password+"'");
			while (rs.next()) {
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
			}
			
		} catch (Exception e) {
			System.out.println("selectMember() 에서 에러 발생함 !!");
			e.printStackTrace();
		}
		System.out.println("쿼리 조회 결과 :"+temp.getAddr());
		if (temp.getAddr() != null) {
			System.out.println("쿼리 조회 결과 :"+temp.getAddr());
			return temp;
		} else {
			System.out.println("쿼리 조회 결과 : null ");
			return null;
		}
		
	}

	@Override
	public MemberBean selectMember(String id) {
		MemberBean temp = new MemberBean();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id ='"+id+"'");
			while (rs.next()) {
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
			}
			
		} catch (Exception e) {
			System.out.println("selectMember() 에서 에러 발생함 !!");
			e.printStackTrace();
		}
		System.out.println("쿼리 조회 결과 :"+temp.getAddr());
		return temp;
	}

	@Override
	public int update(MemberBean member) {
		int  result = 0;
		try {
			pstmt = conn.prepareStatement("update member set password = ?, addr = ? where id = ?");
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getAddr());
			pstmt.setString(3, member.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update() 에서 에러발생");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(String id) {
		int  result = 0;
		try {
			pstmt=conn.prepareStatement("delete from MEMBER where id = ?");
			pstmt.setString(1,id);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("delete 에서 에러 발생");
			e.printStackTrace();
		}
		if (result == 1) {
			System.out.println("dao delete 성공");
		}else{
			System.out.println("dao delete 실패");
		}
		return result;
	}

	@Override
	public boolean isMember(String id) {
		MemberBean temp = new MemberBean();
		boolean result = false;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id = " + "'" + id + "'");
			
			while(rs.next()){
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
				
				result = true;
			}
		} catch (Exception e) {
			System.out.println("isMember()에서 에러 발생");
			e.printStackTrace();
		}
		
		return result;
	}

}

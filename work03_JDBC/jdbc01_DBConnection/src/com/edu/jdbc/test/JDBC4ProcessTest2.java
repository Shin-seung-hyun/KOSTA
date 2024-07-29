package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*

 JDBC 기본 4단계 작업
 
 1. 서버 정보를 담은 드라이버를 로딩 시킨다.
 2. DB서버와 연결 -> Connection 객체가 반환된다.
 3. 이 객체를 받아 Connection 이 가진 함수를 가지고 PreparedStatement 객체를 생성 (쿼리를 실행하는 함수를 가짐)
 4. SQL 쿼리문을 실행한다.
 
 */

public class JDBC4ProcessTest2 {
	
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/kosta?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	public static final String USER = "root";
	public static final String PASSWORD= "1234";
	
	static {
		try {
			
			//1.
			Class.forName(DRIVER_NAME);
			System.out.println("1. Driver Loading 성공...");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading 실패...");
			
		} 
	}
	
	
	public JDBC4ProcessTest2() {
		
		try {
			
			//2. 
			Connection conn= DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("2. DB Connection 성공");
			
			
			//3. 등록 create
//			String query = "insert into custom(id, name, address) values(?,?,?)";
//			PreparedStatement ps = conn.prepareStatement(query) ;// 미리 쿼리문의 컴파일만 실행한다. 
			
			//4. 바인딩 및 쿼리문 실행
//			ps.setInt(1,222);
//			ps.setString(2, "Tomas");
//			ps.setString(3,"Brandon");
//			
//			ps.setInt(1,333);
//			ps.setString(2, "김예지");
//			ps.setString(3,"서울");
//			
//			ps.setInt(1,444);
//			ps.setString(2, "Hwang");
//			ps.setString(3,"Seoul");
//			
//			System.out.println(ps.executeUpdate() + " Row Record 등록 성공");
			
			//3. 삭제 delete
			//delete id 값이 2인 사람을 삭제
//			String query = "delete from custom where id =?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			System.out.println("PreparedStatement 생성");
//			
//			ps.setInt(1, 333);
//			
//			System.out.println(ps.executeUpdate() + " Row Record 삭제 성공");
			
			
			//3. 수정 update
//			String query = "update custom set name =?, address=?  where id = ?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			System.out.println("PreparedStatement 생성");
//			
//			ps.setString(1, "OH");
//			ps.setString(2, "Busan");
//			ps.setInt(3, 444);
//			
//			System.out.println(ps.executeUpdate() + " Row Record 수정 성공");
			
			//3. 조회 select
			String query = "select id, name, address from custom";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
				System.out.println(rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getString("address"));
			}
			
			
			
		} catch (SQLException e) {
			System.out.println("DB Connection Fail...");
			
		} 
		
	}

	public static void main(String[] args) {
		
		new JDBC4ProcessTest2();

	}
	
}







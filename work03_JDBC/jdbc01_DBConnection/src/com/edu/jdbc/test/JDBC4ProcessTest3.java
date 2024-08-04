package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

/*
 서버 주소
 계정명
 계정 비번
 이런 값들은 프로그램 코드에 노출되면 안되는 값들이다.
 프로그램에 이런 실제값이 들어가는 것 == 하드 코딩이라고 한다.
 
 서버에 파편적인 정보를 외부에 모듈화(메타데이터화) 시켜야 한다.
 
 */

public class JDBC4ProcessTest3 {
	
	static {
		try {
			
			//1.
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1. Driver Loading 성공...");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading 실패...");
			
		} 
	}
	
	
	public JDBC4ProcessTest3() {
		
		try {
			
			//2. 
			Connection conn= DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			System.out.println("2. DB Connection 성공");
			
			
			//-------------------------------------------------------------------
//			//3. 등록 create
//			String query = "insert into custom(id, name, address) values(?,?,?)";
//			PreparedStatement ps = conn.prepareStatement(query) ;// 미리 쿼리문의 컴파일만 실행한다. 
//			
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
			
			
			
			//-------------------------------------------------------------------
//			//3. 삭제 delete
//			//delete id 값이 2인 사람을 삭제
//			String query = "delete from custom where id =?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			System.out.println("PreparedStatement 생성");
//			
//			ps.setInt(1, 333);
//			
//			System.out.println(ps.executeUpdate() + " Row Record 삭제 성공");
			
			
			
			//-------------------------------------------------------------------
//			//3. 수정 update
//			String query = "update custom set name =?, address=?  where id = ?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			System.out.println("PreparedStatement 생성");
//			
//			ps.setString(1, "OH");
//			ps.setString(2, "Busan");
//			ps.setInt(3, 444);
//			
//			System.out.println(ps.executeUpdate() + " Row Record 수정 성공");
			
			
			
			//-------------------------------------------------------------------
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
		
		new JDBC4ProcessTest3();

	}
	
}







package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*

 JDBC 기본 4단계 작업
 
 1. 서버 정보를 담은 드라이버를 로딩 시킨다.
 2. DB서버와 연결 -> Connection 객체가 반환된다.
 3. 이 객체를 받아 Connection 이 가진 함수를 가지고 PreparedStatement 객체를 생성 (쿼리를 실행하는 함수를 가짐)
 4. SQL 쿼리문을 실행한다.
 
 */

public class JDBC4ProcessTest1 {
	
	public JDBC4ProcessTest1() {
		
		
		try {
			//1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver"); ////드라이버의 실제 이름을 넣는다. FQCN
			System.out.println("Driver Loading Success...");
			
			
			//2. 서버 연결
			String url = "jdbc:mysql://127.0.0.1:3306/kosta?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
			Connection conn= DriverManager.getConnection(url, "root", "1234");
			System.out.println("DB Connection...");
			
			//3. PreparedStatement 객체 생성
			String query = "insert into custom(id,name,address) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement Creating...");
			
			//4. 쿼리문 실행
			// 4-1. ?에 값 바인딩
			ps.setInt(1, 111);	//id
			ps.setString(2, "JAMES"); //name
			ps.setString(3, "PARIS"); //address
			

			//4-2. sql 실행 (이때, DB에 데이터가 입력된다.)
			int row = ps.executeUpdate();
			
			System.out.println(row + " Row Record 등록 성공");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Fail...");
			
		} catch (SQLException e) {
			System.out.println("DB Connection Fail...");
			
		} 
		
	}

	public static void main(String[] args) {
		
		new JDBC4ProcessTest1();

	}

}







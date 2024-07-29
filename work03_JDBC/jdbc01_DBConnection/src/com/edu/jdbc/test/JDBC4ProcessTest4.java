package com.edu.jdbc.test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import config.ServerInfo;

/*
 서버 주소
 계정명
 계정 비번
 이런 값들은 프로그램 코드에 노출되면 안되는 값들이다.
 프로그램에 이런 실제값이 들어가는 것 == 하드 코딩이라고 한다.
 
 서버에 파편적인 정보를 외부에 모듈화(메타데이터화) 시켜야 한다.
 String(key) = String(value) 를 연결하는 properties 를 사용해보자
 
 */

public class JDBC4ProcessTest4 {
	
	static String driver;
	static String url;
	static String user;
	static String pass;
	static String query;
	
	static {
		
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/db.properties")); 
			
			driver = p.getProperty("jdbc.mysql.driver");
			url = p.getProperty("jdbc.mysql.url");
			user = p.getProperty("jdbc.mysql.user");
			pass = p.getProperty("jdbc.mysql.pass");
			query = p.getProperty("jdbc.sql.selectAll");
				
			Class.forName(driver);
			System.out.println("1. Driver Loading 성공...");

		} catch (Exception e) {
			System.out.println("Driver Loading 실패...");
			
		} 
	}
	
	
	public JDBC4ProcessTest4( )throws Exception {
		
		Connection conn = DriverManager.getConnection(url,user,pass);
		System.out.println("2. DB Connection 성공");

		PreparedStatement ps = conn.prepareStatement(query);
		System.out.println("PreparedStatement 생성");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(	rs.getInt("id") + "\t" +
								rs.getString("name") + "\t" +
								rs.getString("address"));
		}
	
		
	}

	public static void main(String[] args)throws Exception  {
		
		new JDBC4ProcessTest4();

	}
	
}







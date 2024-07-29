package com.edu.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.edu.vo.Custom;

public class SimpleJDBCTest {
	
	static String driver;
	static String url;
	static String user;
	static String pass;
	
	public SimpleJDBCTest() throws Exception{
		
		Properties p = new Properties();
		p.load(new FileInputStream("src/config/db.properties")); 
		
		driver = p.getProperty("jdbc.mysql.driver");
		url = p.getProperty("jdbc.mysql.url");
		user = p.getProperty("jdbc.mysql.user");
		pass = p.getProperty("jdbc.mysql.pass");
		
		Class.forName(driver);
		System.out.println("1. Driver Loading 성공...");
			
	}
	
	public void addCustom(Custom c) throws SQLException {

		//1. 디비 연결
		Connection conn = DriverManager.getConnection(url,user,pass);
		
		//2. PreparedStatement 생성
		//insert into
		String query = "insert into custom(id, name, address) values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);

		//3. 바인딩
		ps.setInt(1, c.getId());
		ps.setString(2, c.getName());
		ps.setString(3, c.getAddress());
		
		//4. 쿼리문 실행
		System.out.println(ps.executeUpdate() + " Row Record 등록 성공");
		
		//5. 자원반환
		conn.close();
	}
	
	public Custom getCustom(int id) throws SQLException { // Business Logic
		
		Custom custom = null;

		
		//1. 디비 연결
		Connection conn = DriverManager.getConnection(url,user,pass);
		
		//2. PreparedStatement 생성
		//select where
		String query = "select * from custom where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		//3. 바인딩
		ps.setInt(1, id);
		
		//4. 쿼리문 실행
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			
			custom = new Custom(rs.getInt("id"), rs.getString("name"), rs.getString("address"));
		}
		
		//5. 자원반환
		conn.close();
		
		return custom;
		
	}
	
	public ArrayList<Custom> getCustom() throws SQLException{
		
		ArrayList<Custom> list=  new ArrayList<Custom>();
		
		//1. 디비 연결
		Connection conn = DriverManager.getConnection(url,user,pass);
		
		//2. PreparedStatement 생성
		String query = "select id, name, address from custom";
		PreparedStatement ps = conn.prepareStatement(query);
		
		//3. 쿼리문 실행 (select는 바인딩 없음)
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new Custom(rs.getInt("id"),
								rs.getString("name"),
								rs.getString("address")));	
		}
		
		//5. 자원반환
		conn.close();

		return list;
	}
	
	
	public static void main(String[] args) throws Exception { // SimpleJDBCTest() 에서 던진 에외를 받아야 함으로
		
		SimpleJDBCTest dao = new SimpleJDBCTest();
		
		//addCustom
		dao.addCustom(new Custom(666, "Blake", "LA"));
		
		//getCustom
		System.out.println(dao.getCustom(111));
		
		//getAllCustom
		dao.getCustom().stream().forEach(i-> System.out.println(i));
		

	}

}

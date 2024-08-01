package com.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position.Bias;

import com.edu.Book;
import com.edu.exception.DMLException;
import com.edu.exception.DuplicateISBNException;
import com.edu.exception.RecordNotFoundException;

import config.ServerInfo;

public class BookDAO {
	
	//싱글톤
	private static BookDAO dao = new BookDAO();
	public static BookDAO getInstance() {
		return dao;
	}
	
	private BookDAO() {
		
		//driver 로딩
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading 실패");
		}
	}
	
	public Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Connection 성공");
		return conn;
	}	
	
	
	//////////////////////////// workshop04 //////////////////////////
//	//반환값이 Book인 경우, Book 안에 author 필드를 넣을 때,
//	public ArrayList<Book> searchAllBook() throws DMLException{
//		ArrayList<Book> list = new ArrayList<Book>();
//		
//		 String query = "* from book b";
//		 
//		try(Connection conn = getConnection();
//				PreparedStatement ps = conn.prepareStatement(query))  {
//				
//				ResultSet rs = ps.executeQuery();
//				
//				while(rs.next()) {
//					list.add( new Book(	rs.getString(1),
//										rs.getString(2),
//										rs.getInt(3),
//										rs.getString(4),
//										rs.getString(5), 
//										rs.getInt(6),
//										rs.getString(7)) );
//					
//				}
//				
//			}catch (SQLException e) {
//				throw new DMLException( "[Result Error Message] => 책 조회 시 문제 발생 했습니다. 쿼리 오류");
//			}
//		
//		return list;
//		
//	}
	
	//그냥 출력하는 경우
	public void search() throws DMLException{
		
		 String query = "select b.title, b.price, a.name from book b join author a on b.author = a.authorno";
		 
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(query))  {
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					System.out.print(rs.getString(1) + " ");
					System.out.print(rs.getInt(2) + " ");
					System.out.println(rs.getString(3));
					
				}
				
			}catch (SQLException e) {
				throw new DMLException( "[Result Error Message] => 책 조회 시 문제 발생 했습니다. 쿼리 오류");
			}
		
	}
	
	public void search( String name) throws DMLException{
		
		 String query = "select b.title, b.isbn, b.publisher from book b join author a on b.author = a.authorno where a.name like ?";
		 
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(query))  {
				
				ps.setString(1, name.charAt(0) + "%");
				ResultSet rs = ps.executeQuery();
				
				int i=0;
				while(rs.next()) {
					System.out.print(rs.getString(1) + " ");
					System.out.print(rs.getString(2) + " ");
					System.out.println(rs.getString(3));
					
				}
				
			}catch (SQLException e) {
				throw new DMLException( "[Result Error Message] => 책 조회 시 문제 발생 했습니다. 쿼리 오류");
			}
		
	}
	
	public void serachByAuthor(String authorName) throws DMLException {
		
		String query = "select title, publisher, price, a.name from book b join author a on b.author = a.authorno where a.name = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query))  {
			
			ps.setString(1, authorName);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString(1) + " ");
				System.out.print(rs.getString(2) + " ");
				System.out.print(rs.getInt(3)+ " ");
				System.out.println(rs.getString(4));
				
			}
					
		
		}catch (SQLException e) {
			throw new DMLException( "[Result Error Message] => 저자명 책 출력 시 문제 발생 했습니다. 쿼리 오류");
		}
	}
	
	
	public void bookPrint() throws DMLException {
		String query = "select concat(title, '세상은', publisher, '에서 출판했다') as print from book";
		
		try(Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query))  {
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
					
		
		}catch (SQLException e) {
			throw new DMLException( "[Result Error Message] => 책 출력 시 문제 발생 했습니다. 쿼리 오류");
		}
	}
	

}

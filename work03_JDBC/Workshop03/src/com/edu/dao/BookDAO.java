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
	
///////////////////////// 비즈니스 로직 /////////////////////////
	
	public void insertBook(Book book) throws DMLException, DuplicateISBNException {
		String query = "insert into book(isbn, title, author, publisher, price, description)"
					+ " VALUES(?,?,?,?,?,?)";
		
		try(Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getPublisher());
			ps.setInt(5, book.getPrice());
			ps.setString(6, book.getDescription());
			
			System.out.println("[Result OK Message] => " + ps.executeUpdate() + " Row INSERT OK!!");
			
		} catch (SQLIntegrityConstraintViolationException e) { // 중복 오류
			throw new DuplicateISBNException( "[Result Error Message] => 이미 존재하는 책입니다.");
		
		}catch (SQLException e) {	// 문법 오류
			throw new DMLException( "[Result Error Message] => 책 등록 시 문제 발생 했습니다. 쿼리 오류");
		}
		
	}

	public Book findBook(String isbn) throws DMLException, RecordNotFoundException {
		
		Book book = null;
		String query = "select * from book where isbn = trim(?)"; // * 쓰지말고 모두 다 쓰기
	
		try(Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query)) {
			
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {	// 책이 있다면
				book = new Book(	isbn,
									rs.getString("title"),
									rs.getString("author"),
									rs.getString("publisher"),
									rs.getInt("price"),
									rs.getString("description"));
			}
			else { // 책이 없다면
				throw new RecordNotFoundException("[Result Error Message] => 도서를 발견하지 못했습니다.");
			}
		}catch (SQLException e) {
			throw new DMLException( "[Result Error Message] => 책 조회 시 문제 발생 했습니다. 쿼리 오류");
		}
		

		return book;
		
	}
	
	public List<Book> listBooks() throws DMLException {
		ArrayList<Book> list = new ArrayList<>();
		String query = "select * from book";
	
		try(Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery()) {
			
			while(rs.next()) {
				list.add( new Book(	rs.getString("isbn"),
									rs.getString("title"),
									rs.getString("author"),
									rs.getString("publisher"),
									rs.getInt("price"),
									rs.getString("description")
									
									));
			}
		}catch (SQLException e) {
			throw new DMLException( "책 조회 시 문제 발생 했습니다. 쿼리 오류");
		}
		
		return list;
	}

	public void updateBook(Book book) throws RecordNotFoundException, DMLException {
		
		String query = "update book set title =?,"
									+ " author=?,"
									+ " publisher=?,"
									+ " price=?,"
									+ " description=? "
									+ "where isbn =?";
		try(Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query))  {
				
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPublisher());
			ps.setInt(4, book.getPrice());
			ps.setString(5, book.getDescription());
			ps.setString(6, book.getIsbn());
				
			if(ps.executeUpdate() ==0) {
				throw new RecordNotFoundException("존재하지 않는 책입니다.");
			}
			else {
				System.out.println("책 수정 성공");
			}
				
		}catch (SQLException e) {	//sql 문법 오류
			throw new DMLException("책 삭제 시 문제가 발생해 가입이 이뤄지지 않았습니다.");
		}
		
	}

	public void deleteBook(String isbn) throws RecordNotFoundException, DMLException {
		String query = "delete from book where isbn =?";
		
		try(Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query))  {
			
			ps.setString(1, isbn);
			
			if(ps.executeUpdate() ==0) {
				throw new RecordNotFoundException("[Result Error Message] => 존재하지 않는 책입니다.");
			}
			else {
				System.out.println("[Result OK Message] => book 삭제 성공");
			}
				
		}catch (SQLException e) {	//sql 문법 오류
			throw new DMLException("[Result Error Message] => 책 삭제 시 문제가 발생해 삭제가 이뤄지지 않았습니다.");
		}
		
		
	}

	//총 도서갯수를 구하는 비즈니스 로직
	public int count() throws DMLException {
		
		int totalBooks = 0;
		String query = "select count(isbn) count from book";
	
		try(Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query))  {
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) totalBooks = rs.getInt("count");
			
		}catch (SQLException e) {
			throw new DMLException( "[Result Error Message] => 책 수 조회 시 문제 발생 했습니다. 쿼리 오류");
		}
		
		return totalBooks;

	}
	
	
	
	//////////////////////////// workshop03 //////////////////////////
	public List<Book> serachByTitle(String title) throws DMLException {
		List<Book> books = new ArrayList<>();
		
		String query = "select isbn, title, author, publisher, price, description from book where title like ?";
		
		try(Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query))  {
			
			ps.setString(1, "%" + title + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				books.add( new Book(rs.getString("isbn"),
									rs.getString("title"),
									rs.getString("author"),
									rs.getString("publisher"),
									rs.getInt("price"),
									rs.getString("description") ));
			}
					
		
		}catch (SQLException e) {
			throw new DMLException( "[Result Error Message] => 책 이름으로 책 조회 시 문제 발생 했습니다. 쿼리 오류");
		}
		
		return books;
	}
	
	public List<Book> serachByPublisher(String publisher) throws DMLException {
		List<Book> books = new ArrayList<>();
		
		String query = "select isbn, title, author, publisher, price, description from book where publisher like ?";
		
		try(Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query))  {
			
			ps.setString(1, "%" + publisher + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				books.add( new Book(rs.getString("isbn"),
									rs.getString("title"),
									rs.getString("author"),
									rs.getString("publisher"),
									rs.getInt("price"),
									rs.getString("description") ));
			}
					
		
		}catch (SQLException e) {
			throw new DMLException( "[Result Error Message] => 출판사로 책 조회 시 문제 발생 했습니다. 쿼리 오류");
		}
		
		return books;
	}
	
	public List<Book> serachByAuthor(String author) throws DMLException {
		List<Book> books = new ArrayList<>();
		
		String query = "select isbn, title, author, publisher, price, description from book where author = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query))  {
			
			ps.setString(1, author + " 기술연구소");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				books.add( new Book(rs.getString("isbn"),
									rs.getString("title"),
									rs.getString("author"),
									rs.getString("publisher"),
									rs.getInt("price"),
									rs.getString("description") ));
			}
					
		
		}catch (SQLException e) {
			throw new DMLException( "[Result Error Message] => 작가 별로 책 조회 시 문제 발생 했습니다. 쿼리 오류");
		}
		
		return books;
	}
	
	public List<Book> serach(int maxPrice, int minPrice) throws DMLException {
		List<Book> books = new ArrayList<>();
		
		String query = "select isbn, title, author, publisher, price, description from book where price between ? and ?";
		
		try(Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query))  {
			
			ps.setInt(1, minPrice);
			ps.setInt(2, maxPrice);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				books.add( new Book(rs.getString("isbn"),
									rs.getString("title"),
									rs.getString("author"),
									rs.getString("publisher"),
									rs.getInt("price"),
									rs.getString("description") ));
			}
					
		
		}catch (SQLException e) {
			throw new DMLException( "[Result Error Message] => 작가 별로 책 조회 시 문제 발생 했습니다. 쿼리 오류");
		}
		
		return books;
	}
	
	public void discontByPublisher( double rate, String publisher) throws DMLException {
		
		String query = "update book b, (select isbn, price from book where publisher like ?) b2 set b.price = b2.price * ? where b.isbn = b2.isbn";
		
		try(Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query))  {
			
			ps.setString(1, "%" + publisher + "%");
			ps.setDouble(2, rate);
			
			ps.executeUpdate();
			
			System.out.println("[Result OK Message] => 책 수정 성공");
			
		
		}catch (SQLException e) {
			throw new DMLException( "[Result Error Message] => 작가 별로 책 조회 시 문제 발생 했습니다. 쿼리 오류");
		}
		
	}
	

}

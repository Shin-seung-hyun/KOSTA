package com.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.edu.exception.DMLException;
import com.edu.exception.RecordNotFoundException;
import com.edu.vo.Author;
import com.edu.vo.Book;

import config.ServerInfo;

public class BookDAO {
	private static BookDAO dao = new BookDAO();
	
	private BookDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 로딩 실패");
		}
	}
	
	public static BookDAO getInstance() {
		return dao;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	public void close(Connection connection) throws SQLException {
		connection.close();
	}
	
	public void close(PreparedStatement statement) throws SQLException {
		statement.close();
	}
	
	public void close(ResultSet resultSet) throws SQLException {
		resultSet.close();
	}
	
	public List<Book> findBookByTitle(String title) throws DMLException, RecordNotFoundException {
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();
		String query = "SELECT b.isbn, b.title, a.name, b.publisher, b.price, b.description FROM book b, author a WHERE b.authorno=a.authorno AND title LIKE ?";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)){
			ps.setString(1, "%" + title + "%");
			rs = ps.executeQuery();
			if(!rs.isBeforeFirst()) throw new RecordNotFoundException("[ Result Error Message ] => 해당 " +
																	  title + "의 도서가 존재하지 않습니다.");
			else {
				while(rs.next()) {					
					books.add(new Book(rs.getString("b.isbn"), rs.getString("b.title"), rs.getString("a.name"),
							rs.getString("b.publisher"), rs.getInt("b.price"), rs.getString("b.description")));
				}
			}
		} catch (SQLException e) {
			throw new DMLException("[ Result Error Message ] => 문제가 발생하여 도서를 찾을 수 없습니다.");
		}
		return books;
	}
	
	public List<Book> findBookByPrice(int min, int max) throws DMLException, RecordNotFoundException {
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();
		String query = "SELECT b.isbn, b.title, a.name, b.publisher, b.price, b.description FROM book b, author a WHERE b.authorno=a.authorno AND price BETWEEN ? AND ?";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)){
			ps.setInt(1, min);
			ps.setInt(2, max);
			rs = ps.executeQuery();
			if(!rs.isBeforeFirst()) throw new RecordNotFoundException("[ Result Error Message ] => 해당 가격대의 도서가 존재하지 않습니다.");
			else {
				while(rs.next()) {					
					books.add(new Book(rs.getString("b.isbn"), rs.getString("b.title"), rs.getString("a.name"),
							rs.getString("b.publisher"), rs.getInt("b.price"), rs.getString("b.description")));
				}
			}
		} catch (SQLException e) {
			throw new DMLException("[ Result Error Message ] => 문제가 발생하여 도서를 찾을 수 없습니다.");
		}
		return books;
	}
	
	public List<Book> findBookByAuthor(String name) throws DMLException, RecordNotFoundException {
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();
		String query = "SELECT b.isbn, b.title, a.name, b.publisher, b.price, b.description FROM book b, author a WHERE b.authorno=a.authorno AND a.name=?";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)){
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(!rs.isBeforeFirst()) throw new RecordNotFoundException("[ Result Error Message ] => 해당 저자의 도서가 존재하지 않습니다.");
			else {
				while(rs.next()) {					
					books.add(new Book(rs.getString("b.isbn"), rs.getString("b.title"), rs.getString("a.name"),
							rs.getString("b.publisher"), rs.getInt("b.price"), rs.getString("b.description")));
				}
			}
		} catch (SQLException e) {
			throw new DMLException("[ Result Error Message ] => 문제가 발생하여 도서를 찾을 수 없습니다.");
		}
		return books;
	}
	
	public void findBookByKim() throws DMLException, RecordNotFoundException {
		ResultSet rs = null;
		String query = "SELECT b.title, b.price, b.publisher FROM book b, author a WHERE b.authorno=a.authorno AND a.name LIKE '김__'";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)){
			rs = ps.executeQuery();
			if(!rs.isBeforeFirst()) throw new RecordNotFoundException("[ Result Error Message ] => 해당 저자의 도서가 존재하지 않습니다.");
			else {
				while(rs.next()) {					
					System.out.println("도서명 : " + rs.getString("b.title") +
							           "가격 : " + rs.getInt("b.price") +
							           "출판사 : " + rs.getString("b.publisher"));
				}
			}
		} catch (SQLException e) {
			throw new DMLException("[ Result Error Message ] => 문제가 발생하여 도서를 찾을 수 없습니다.");
		}
	}
	
	public void findBookGroupByName() throws DMLException, RecordNotFoundException {
		ResultSet rs = null;
		String query = "SELECT b.title, b.publisher, b.price, a.name FROM book b, (SELECT authorno FROM book GROUP BY authorno) g, author a WHERE b.authorno=g.authorno AND a.authorno=g.authorno";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)){
			rs = ps.executeQuery();
			if(!rs.isBeforeFirst()) throw new RecordNotFoundException("[ Result Error Message ] => 해당 저자의 도서가 존재하지 않습니다.");
			else {
				while(rs.next()) {					
					System.out.println("도서명 : " + rs.getString("b.title") +
							           "가격 : " + rs.getInt("b.price") +
							           "출판사 : " + rs.getString("b.publisher") + 
							           "저자명 : " + rs.getString("a.name"));
				}
			}
		} catch (SQLException e) {
			throw new DMLException("[ Result Error Message ] => 문제가 발생하여 도서를 찾을 수 없습니다.");
		}
	}
	
	public void findBookGroupByName2() throws DMLException, RecordNotFoundException {
		List<Author> authors = new ArrayList<Author>();
		List<Book> books = new ArrayList<Book>();
		String bname = "";
		String nname = "";
		ResultSet rs = null;
		String query = "SELECT b.title, b.publisher, b.price, a.name FROM book b,  (SELECT authorno FROM book GROUP BY authorno) g, author a WHERE b.authorno=g.authorno AND a.authorno=g.authorno";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)){
			rs = ps.executeQuery();
			if(!rs.isBeforeFirst()) throw new RecordNotFoundException("[ Result Error Message ] => 해당 저자의 도서가 존재하지 않습니다.");
			else {
				while(rs.next()) {
					nname = rs.getString("a.name");
					if(!(nname.equals(bname))&&!(bname.equals(""))) {
						List<Book> b = new ArrayList<Book>();
						b.addAll(books);
						authors.add(new Author(bname, b));
						books.clear();
					}
					books.add(new Book(rs.getString("b.title"),rs.getString("b.publisher"),rs.getInt("b.price")));
					bname = nname;
				}
				authors.add(new Author(bname, books));
				for(Author a : authors) {
					System.out.println(a.getName() + "의 도서");
					for(Book b : a.getBooks()) {
						System.out.println("도서명 : " + b.getTitle() +
							           " 가격 : " + b.getPrice() +
							           " 출판사 : " + b.getPublisher());
					}
				}
			}
		} catch (SQLException e) {
			throw new DMLException("[ Result Error Message ] => 문제가 발생하여 도서를 찾을 수 없습니다.");
		}
	}
	
	public void listBooks() throws RecordNotFoundException, DMLException {
		String query = "SELECT concat(title, '은 ', publisher, '에서 출판했다') str FROM book";
		try (Connection conn = getConnection();
			 PreparedStatement ps = conn.prepareStatement(query);
			 ResultSet rs = ps.executeQuery()){
			if(!rs.isBeforeFirst()) throw new RecordNotFoundException("[ Result Error Message ] => 현재 도서가 존재하지 않습니다.");
			else {
				while(rs.next()) {					
					System.out.println(rs.getString("str"));
				}
			}
		} catch (SQLException e) {
			throw new DMLException("[ Result Error Message ] => 문제가 발생하여 도서를 찾을 수 없습니다.");
		}
	}
}

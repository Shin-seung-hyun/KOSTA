package com.edu.test;

import java.sql.SQLException;
import java.util.List;

import com.edu.dao.BookDAO;
import com.edu.exception.DMLException;
import com.edu.exception.RecordNotFoundException;
import com.edu.vo.Book;

public class Test {

	public static void main(String[] args) throws SQLException {
		BookDAO dao = BookDAO.getInstance();
		
		
		try {
			dao.findBookByTitle("JAV").forEach(System.out::println);;
		} catch (DMLException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.findBookByTitle("JAVE").forEach(System.out::println);;
		} catch (DMLException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===================================================");
		
		try {
			dao.findBookByPrice(20000, 27000).forEach(System.out::println);
		} catch (DMLException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.findBookByPrice(2000, 2700).forEach(System.out::println);
		} catch (DMLException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===================================================");
		
		try {
			dao.findBookByAuthor("김믿음").forEach(System.out::println);
		} catch (DMLException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.findBookByAuthor("김미듬").forEach(System.out::println);
		} catch (DMLException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===================================================");
		
		try {
			dao.findBookByKim();
		} catch (DMLException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===================================================");
		try {
			dao.findBookGroupByName();
		} catch (RecordNotFoundException | DMLException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===================================================");
		try {
			dao.findBookGroupByName2();
		} catch (RecordNotFoundException | DMLException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===================================================");
		try {
			dao.listBooks();
		} catch (RecordNotFoundException | DMLException e) {
			System.out.println(e.getMessage());
		}
	}
	
}

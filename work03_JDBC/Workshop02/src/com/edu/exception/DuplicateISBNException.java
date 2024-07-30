package com.edu.exception;

public class DuplicateISBNException extends Exception{
	
	public DuplicateISBNException( String msg) {
		super(msg);
	}
	
	public DuplicateISBNException() {
		this("Dupulicate Number 이미 존재하는 사람입니다.");
	}
	

}

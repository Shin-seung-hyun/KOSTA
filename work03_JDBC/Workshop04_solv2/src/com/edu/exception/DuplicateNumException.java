package com.edu.exception;

public class DuplicateNumException extends Exception{
	public DuplicateNumException( String msg) {
		super(msg);
	}
	
	public DuplicateNumException() {
		this("존재하는 사람이 없습니다.");
	}

}

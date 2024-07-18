package com.edu.exception;


public class RecordNotFoundException extends Exception{

	public RecordNotFoundException() {
		this("찾고자 하는 직원은 이미 데이터가 존재하지 않습니다.");
	}
	public RecordNotFoundException(String msg) {
		super(msg);
	}
	
}

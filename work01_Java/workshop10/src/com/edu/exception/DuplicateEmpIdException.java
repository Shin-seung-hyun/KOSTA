package com.edu.exception;


public class DuplicateEmpIdException extends Exception{

	public DuplicateEmpIdException() {
		this("EmpI에 해당하는 직원은 이미 등록된 상태입니다.");
	}
	public DuplicateEmpIdException(String msg) {
		super(msg);
	}
	
}

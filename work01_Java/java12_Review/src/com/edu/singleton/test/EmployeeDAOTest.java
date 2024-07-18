package com.edu.singleton.test;


//서비스 기능
	//DB는 아직 연결하지 않았지만 임의로 DAO 라고 하자!
	//싱글톤
class EmployeeDAO{
	
	//1. private static 으로 객체 생성
	private static EmployeeDAO dao = new EmployeeDAO();
	
	//2. 생성자 앞에 private 붙이기
	private EmployeeDAO() {
		System.out.println("싱글톤으로 객체 하나만 일단 생성");
	}
	
	//3. public static 한 성질로 만든 객체를 반환하는 기능
	public static EmployeeDAO getInstance() {
		return dao;
	}
	
	public void register(String name) {
		System.out.println("Register Service 작동..." + name +"... Register Success! 가입성공");
	}
	
	public void search() {
		System.out.println("Search Success! 검색성공");
	}
	
	
}


//clinet side라고 생각하자!
	//Client가 서비스를 요청하는 상황을 만들어보자
	//BLAKE, SCOTT, SMITH 세명의 직원이 사내 사이트를 접속해서
	//직원가입을 요청하는 서비스
public class EmployeeDAOTest {
	
	public static void main(String[] args) {
		
		//생성자는 한번만 돌았다. 객체는 하나만 생성
		//Client의 요청은 클래스 안에 있는 메소드 단위이다.(스레드 단위)
		
		EmployeeDAO.getInstance().register("BLAKE");
		EmployeeDAO.getInstance().register("SCOTT");
		EmployeeDAO.getInstance().register("SMITH");
	
	}
}

package spring.service.dao.impl;

import spring.service.dao.MemberDAO;

public class MemeberDAOImpl implements MemberDAO{

	@Override
	public void register(String name, String pass) {
		
		System.out.println(name + "님 등록되셨습니다.");
	}

	@Override
	public void delete(String id) {
		System.out.println(id + "님 삭제되셨습니다.");
	}

	
}

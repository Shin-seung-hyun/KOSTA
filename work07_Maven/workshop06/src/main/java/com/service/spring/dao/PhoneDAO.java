package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;


@Repository
public class PhoneDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	final String NS = "ns.sql.Phone.";
	
	public int insert( Phone vo) {
		return sqlSession.insert(NS+"insert", vo);
	}
	
	// 특정폰, 모든 폰 조회
	public List<Phone> select() {
		return sqlSession.selectList(NS+"select");
	}
	
	public Phone select(Phone vo) {
		return sqlSession.selectOne(NS+"select",vo);
	}
	
	
	//로그인과 특정 고객 찾기
	public UserInfo select(UserInfo vo) {
		return sqlSession.selectOne(NS+"selectUser", vo);
	}
	
	public int delete(List<String> list) {
		return sqlSession.delete(NS+ "delete", list);
	}
	
	public int update(Phone vo) {
		return sqlSession.update(NS+"update",vo);
	}

	
}

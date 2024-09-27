package com.service.mybatis.unit;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonUnitTest1 {

	public static void main(String[] args) throws IOException {
		
		//사원 추가하는 로직 호출 
		//1. 폼으로부터 사원 정보를 받아와야 하는데.. 받았다 치고 바로 객체 생성해보자
		//pvo : 파라미터로 받은 vo
		MySawon pvo = new MySawon();
		pvo.setId("mybatis");
		pvo.setPwd("mybatis");
		pvo.setName("James");
		pvo.setAge(33);
		
		//2. MyBatis 라이브러리 사용해서 작업을 진행
		/*
		 	1) SqlMapConfig.xml을 먼저 읽는다.
		 	2) SqlSessionFactory를 생성하고 1)을 준다.
		 	3) SqlSession을 만든다. !!!!!!!! (제일 중요)
		 	4) SqlSession에 쿼리문을 실행하는 함수가 다 들어있다.
		 	
		 		int insert() // 추가되면 1 아니면 0
		 			알아서 Connection -> PrepareStatement -> 바인딩 --> executeUpdate() 해준다.
		 		int delete()
		 		int update()
			 	Object selectOne()
			 	List selectList()
		*/
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		SqlSession session = factory.openSession();
		System.out.println("SqlSession .. Creating ...");
		
		session.insert("SawonMapper.SawonAdd", pvo);
		System.out.println(pvo.getName() + "님 회원 등록 성공^^");
		
		session.commit();
		
		session.close();
		
	}

}

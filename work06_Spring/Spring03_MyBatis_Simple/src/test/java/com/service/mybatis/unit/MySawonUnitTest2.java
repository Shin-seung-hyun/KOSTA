package com.service.mybatis.unit;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonUnitTest2 {

	public static void main(String[] args) throws IOException {


//		// 1. 설정 문서를 읽는다.
//		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
//		
//		// 2. SqlSessionFactory 생성
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
	
		// 3. SqlSession 생성
		SqlSessionFactory factory = FactoryService.getFactory();
		SqlSession session = factory.openSession();
		System.out.println("SqlSession .. Creating ...");
		
		session.selectList("SawonMapper.SawonList")
			.forEach(c -> System.out.println(c));

		
		session.commit();
		
		session.close();
		
	}

}

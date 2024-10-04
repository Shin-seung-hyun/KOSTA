package com.service.spring.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.dao.MyProductDAO;
import com.service.spring.domain.MyProduct;
import com.service.spring.service.MyProductService;

public class MyBatisDITest {
	
	ApplicationContext factory = new ClassPathXmlApplicationContext("/bean/beans.xml");
	
	//MyBatis DI 연동 부분의 단위 테스트 -> bean 설정문서를 읽어야 한다.
	@Test
	public void addTest() throws Exception {
		
		//IOC로부터 MyProductDAO 객체를 반환
		MyProductDAO dao = (MyProductDAO)factory.getBean("myProductDAO");

		System.out.println("============================== 1. add ================================");
		MyProduct pvo = new MyProduct("공기청정기3", "LG", 100000 );
		dao.addProduct(pvo); // sqlSession의 insert 호출 -> DB 작업
		
	}
	
	@Test
	public void findTest() throws Exception{
		
		MyProductService service = (MyProductService) factory.getBean("myProductService");
		
		System.out.println("============================== 1. findByName ================================");
		List<MyProduct> list = service.findProductByName("TV");
		for(MyProduct p : list) System.out.println(p);
		System.out.println();
		
		
		System.out.println("============================== 2. findByMaker ================================");
		List<MyProduct> list2 = service.findProductByMaker("LG");
		for(MyProduct p : list2) System.out.println(p);
		System.out.println();
		
		
		System.out.println("============================== 3. findProduct ================================");
		List<MyProduct> list3 = service.findProducts();
		for(MyProduct p : list3) System.out.println(p);
		
	}
	

}

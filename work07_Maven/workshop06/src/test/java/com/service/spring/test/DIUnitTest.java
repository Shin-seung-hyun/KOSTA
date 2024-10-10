package com.service.spring.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.service.PhoneService;

public class DIUnitTest {
	
	String[] beans = new String[] {"beans/businessBean.xml", "beans/presentationBean.xml"};
	ApplicationContext factory = new ClassPathXmlApplicationContext(beans);
	
	PhoneService service = (PhoneService)factory.getBean("phoneService");
	
	Phone vo = new Phone("A1058", "iPhone", 2000000, "30");
	UserInfo userinfo = new UserInfo("java", "java");
	
	@Test
	public void insert() throws Exception {
		System.out.println("===== 1. insert =====");
		System.out.println(service.insert(vo));
	}
	
	@Test
	public void select()throws Exception {
		System.out.println("===== 2. select =====");
		List<Phone> list = service.select();
		for(Phone p : list)
			System.out.println(p);
	}
	
	@Test
	public void selectUser() throws Exception {
		System.out.println("===== 3. selectUser =====");
		UserInfo userInfo= service.select(userinfo);
		System.out.println(userInfo);
	}
	
	@Test
	public void update() throws Exception {
		System.out.println("===== 4. update =====");
		vo.setPrice(2000);
		System.out.println(service.update(vo));
	}
	
	@Test
	public void delete() throws Exception {
		System.out.println("===== 5. delete =====");
		
		List<Phone> list = service.select();
		System.out.println(list);
		
		try{System.out.println(service.delete(list));}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.MyProductDAO;
import com.service.spring.domain.MyProduct;


// @Service 단은 데이터 가공과 연관된다. -> select 문 
// delete 와는 연관이 없다.
@Service
public class MyProductService {

	@Autowired
	private MyProductDAO myProductDAO;
	
	/*
	 * public void addProduct(MyProduct vo) throws Exception{
	 * myProductDAO.addProduct(vo); }
	 */
	
	public List<MyProduct> findProductByName(String name) throws Exception{
		return myProductDAO.findProductByName(name);
	}
	
	public List<MyProduct> findProductByMaker(String maker) throws Exception{
		return myProductDAO.findProductByMaker(maker);
	}

	public List<MyProduct> findProducts() throws Exception{
		return myProductDAO.findProducts();
	}
	
}

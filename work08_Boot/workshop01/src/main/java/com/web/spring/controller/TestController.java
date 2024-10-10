package com.web.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.entity.Product;

@RestController
@RequestMapping("/api/v1")
public class TestController {

	//http://localhost:9999/api/v1/product?no=10
	@GetMapping("/product")
	public ResponseEntity<?> getProduct(@RequestParam String no) {
		
		Product rvo = new Product("10", "노트북", 500000);
		
		return ResponseEntity
				.status(200)
				.body(rvo+", Get OK");
	}
	
	//http://localhost:9999/api/v1/product/no
	@GetMapping("/product/{no}")
	public ResponseEntity<?> getProductByPathVariable(@PathVariable String no){
		
		return ResponseEntity
				.status(200)
				.body(no+", Get OK");
	}
	
	//http://localhost:9999/api/v1/products
	@GetMapping("/products")
	public ResponseEntity<?> getProducts(){
		
		List<Product> list = new ArrayList<>(); 
		list.add(new Product("10", "노트북", 500000));
		list.add(new Product("20", "노트북2", 500000));
		
		return ResponseEntity
				.status(200)
				.body(list+", Get OK");
	}
	
	
	//http://localhost:9999/api/v1/product
	@PostMapping("/product")
	public ResponseEntity<?> regProducts(@RequestBody Product pvo){
	
		return ResponseEntity
				.status(201)
				.body(pvo+", Post OK");
	}
	
	//http://localhost:9999/api/v1/product
	@PutMapping("/product")
	public ResponseEntity<?> updateProduct(@RequestBody Product pvo){
		return ResponseEntity
				.status(202)
				.body(pvo +", Put OK");
	}
	
	//http://localhost:9999/api/v1/product/10
	@DeleteMapping("/product/{no}")
	public ResponseEntity<?> delete(@PathVariable int no) {
		
		return ResponseEntity
				.status(200)
				.body(no+", Delete OK");
	}
	
	
}

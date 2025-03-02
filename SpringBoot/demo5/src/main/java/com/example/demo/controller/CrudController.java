package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ProductNotFoundException;
import com.example.demo.model.MyProduct;
import com.example.demo.servixces.CrudService;

@RestController
public class CrudController {

	@Autowired
	private CrudService service;
	 
	@GetMapping("/")
	public String entrypage(){ 
		
			return "<h1>Welcome to SpringBoot App</h1>";
	}
	
	@GetMapping("/getProd")
	public List<MyProduct> fetchProductList(){ 
		List<MyProduct> products=new ArrayList<>();
		//Logic TO Fetch 
		 products =service.fetchProductList();
		return products;
	}
	
	@GetMapping("/getProd/{id}")
	public ResponseEntity<Object> fetchProductListById(@PathVariable int id) { 
	    try {
	        MyProduct product = service.fetchProductListById(id);
	        return new ResponseEntity<>(product, HttpStatus.OK);
	        
	    } catch (ProductNotFoundException ex) {
	        return new ResponseEntity<>("Product with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    }
	}




	
	@PostMapping("/addProd")
	public MyProduct saveProductList(@RequestBody MyProduct product){ 
		
		return service.saveProductToBD(product);
		
	}
	
	@PutMapping("/updateProd")
	public MyProduct saveorUpdateProductList(@RequestBody MyProduct product){ 
		
		return service.saveProductToBD(product);
		
	}
	
	@DeleteMapping("/deleteProd/{id}")
	public String deleteProductListById(@PathVariable int id){ 
		return service.deleteProductListById(id);
		
	
	}
	
}

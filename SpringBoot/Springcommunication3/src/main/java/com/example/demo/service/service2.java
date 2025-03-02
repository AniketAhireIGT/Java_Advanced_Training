package com.example.demo.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Product;
@Service
public class service2 {
	
	@Autowired
	RestTemplate restTemplate;
	
	final String ROOT_URI = "http://localhost:9999/getProductS1";
	final String ROOT_URI2 = "http://localhost:9999/setProdS1";
	final String ROOT_URI3 = "http://localhost:9999/deleteProdS1";
	final String ROOT_URI4 = "http://localhost:9999/updateProdS1";
	
	public List<Product> findAllMyModel() {
	
		ResponseEntity<Product[]> response = restTemplate.getForEntity(ROOT_URI, Product[].class);
		System.out.println(response);
		return Arrays.asList(response.getBody());
	}
	
	public Product FindModelbyId(int id) {
		
		ResponseEntity<Product> response = restTemplate.getForEntity(ROOT_URI+"/"+id, Product.class);
		
		return response.getBody();
	}
	public URI setProd(Product m)
	{
		return restTemplate.postForLocation(ROOT_URI2,m);
	
	}
	public void deleteProd(int id)
	{
		restTemplate.delete(ROOT_URI3+"/"+id);
	}
	public void update(int id, Product m) {
	
			restTemplate.put(ROOT_URI4+"/"+id,m);
	
	}

}

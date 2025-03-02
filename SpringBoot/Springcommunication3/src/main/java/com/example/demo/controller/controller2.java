package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.Service3;


@RestController
public class controller2 {
	
	@Autowired
	private Service3 serv;
	
	@GetMapping("/getProductS3")
	public List<Product> FindAllModel() 
	{
		List<Product> model = new ArrayList<Product>();
		model = serv.findAllMyModel();
		return model;
	}
	
	@GetMapping("/getProductS3/{id}")
	public Product FindModelbyId(@PathVariable int id) 
	{
		return serv.FindModelbyId(id);
	}
	
	@PostMapping("/setProdS3")
	public void setProd(@RequestBody Product m)
	{
		serv.setProd(m);
	}
	
	@DeleteMapping("/deleteProdS3/{id}")
	public void deleteProd(@PathVariable int id)
	{
		serv.deleteProd(id);
	}
	
	@PutMapping("updateProdS3/{id}")
	public void updateProd(@PathVariable int id, @RequestBody Product m)
	{
		serv.update(id,m);
	}
}

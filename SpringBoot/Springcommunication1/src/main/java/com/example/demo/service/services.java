package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.myRepo;

@Service
public class services {
	@Autowired
	private myRepo repo;
	
	public List<Product> findAllMyModel(){
		return repo.findAll();
	}
	public Product findById(int id)
	{
		return repo.findById(id).get();
	}
	public void save(Product m)
	{
		repo.save(m);
	}
	public void delete(int id)
	{
		repo.deleteById(id);
	}
	public void update(int id, Product m)
	{
		Product model2 = repo.getById(id);
		model2.setPname(m.getPname());
		repo.save(model2);
	}

}


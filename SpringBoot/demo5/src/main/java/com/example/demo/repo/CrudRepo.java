package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MyProduct;

public interface CrudRepo extends JpaRepository<MyProduct, Integer>{

}

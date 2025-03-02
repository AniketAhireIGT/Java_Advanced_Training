package com.example.demo.configFeign;


import com.example.demo.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@FeignClient(name = "Springcommunication1", url = "http://localhost:9999")
public interface ProductClient {

    @GetMapping("/getProductS1")
    List<Product> findAllMyModel();

    @GetMapping("/getProductS1/{id}")
    Product findModelById(@PathVariable int id);

    @PostMapping("/setProdS1")
    URI setProd(@RequestBody Product product);

    @DeleteMapping("/deleteProdS1/{id}")
    void deleteProd(@PathVariable int id);

    @PutMapping("/updateProdS1/{id}")
    void update(@PathVariable int id, @RequestBody Product product);
    
}

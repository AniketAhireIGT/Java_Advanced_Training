package com.example.demo.service;

import com.example.demo.configFeign.ProductClient;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class Service4 {

    @Autowired
    private ProductClient productClient;

    public List<Product> findAllMyModel() {
        return productClient.findAllMyModel();
    }

    public Product findModelById(int id) {
        return productClient.findModelById(id);
    }

    public URI setProd(Product m) {
        return productClient.setProd(m);
    }

    public void deleteProd(int id) {
        productClient.deleteProd(id);
    }

    public void update(int id, Product m) {
        productClient.update(id, m);
    }
}

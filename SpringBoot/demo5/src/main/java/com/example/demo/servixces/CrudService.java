package com.example.demo.servixces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ProductNotFoundException;
import com.example.demo.model.MyProduct;
import com.example.demo.repo.CrudRepo;

@Service
public class CrudService {
    @Autowired
    private CrudRepo repo;

    // Fetch all products
    public List<MyProduct> fetchProductList() {
        return repo.findAll();
    }

    // Fetch product by ID (throws exception if not found)
    public MyProduct fetchProductListById(int id) {
        return repo.findById(id)
                   .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
    }

 // Save or Update product
    public MyProduct saveProductToBD(MyProduct product) {
        if (product == null || product.getName() == null) {
            throw new IllegalArgumentException("Product details cannot be null");
        }
        try {
            return repo.save(product);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Duplicate entry or data integrity issue");
        }
    }

    // Delete product by ID (throws exception if not found)
    public String deleteProductListById(int id) {
        if (!repo.existsById(id)) {
            throw new ProductNotFoundException("Product with ID " + id + " not found. Cannot delete.");
        }
        repo.deleteById(id);
        return "Product Deleted Successfully";
    }
}

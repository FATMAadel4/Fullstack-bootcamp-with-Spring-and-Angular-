package com.adminPanel.app.controller;

import com.adminPanel.app.DTO.ProductDetailsDTO;
import com.adminPanel.app.Exceptions.ProductNotFoundException;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.service.ProductService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get product by ID
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        if (id <=0) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        return productService.getProductById(id);
    }

    @PostMapping("/product-details")
    public ProductDetails insertProductDetails(@RequestBody ProductDetails details) {
        return productService.insertProductDetails(details);
    }
    @PutMapping("/product-details")
    public ProductDetailsDTO updateProductDetails(@RequestBody ProductDetails details) {
        ProductDetails pd = productService.updateProductDetails(details);
        return new ProductDetailsDTO(pd);
    }

    @DeleteMapping("/product-details/{id}")
    public void deleteProductDetails (@PathVariable int id) {
        if (id <=0) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }

        productService.deleteProductDetails(id);

    }
    @GetMapping("/product-details/{id}")
    public ProductDetailsDTO getProductDetailsById(@PathVariable int id) {
        if (id <=0) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }

        ProductDetails pd = productService.getProductDetailsById(id);
        return new ProductDetailsDTO(pd);
    }


    @GetMapping("/product-details/name/{name}")
    public ProductDetailsDTO getProductDetailsByName(@PathVariable String name) {
        ProductDetails pd = productService.getProductDetailsByName(name);
        return new ProductDetailsDTO(pd);
    }


}

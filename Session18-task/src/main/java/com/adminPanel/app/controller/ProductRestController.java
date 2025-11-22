package com.adminPanel.app.controller;

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
        return productService.getProductById(id);
    }

    // Add product
    @PostMapping("/products")
    public Product addProduct(@Valid @RequestBody Product product) {

        if (product.getProductDetails() == null) {
            ProductDetails details = new ProductDetails();
            details.setAvailable(false);
            details.setPrice(null);
            details.setManufacturer("");
            details.setName("");
            details.setExpirationDate(new Date());
            product.setProductDetails(details);
        }

        product.getProductDetails().setName(product.getName());
        product.getProductDetails().setProduct(product);

        productService.addProduct(product);
        return product;
    }

    // Update product
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable int id,
                                 @Valid @RequestBody Product product) {

        if (product.getProductDetails() == null) {
            product.setProductDetails(new ProductDetails());
        }

        product.setId(id);
        product.getProductDetails().setName(product.getName());
        product.getProductDetails().setProduct(product);

        productService.updateProduct(product);
        return product;
    }

    // Delete product
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }
}

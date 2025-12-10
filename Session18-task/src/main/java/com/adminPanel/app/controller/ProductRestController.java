package com.adminPanel.app.controller;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    // Add product
    @PostMapping
    public Product addProduct(@Valid @RequestBody Product product) {
        // Validation هي اللي بتتأكد إن ProductDetails موجود
        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }
        productService.addProduct(product);
        return product;
    }

    // Update product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id,
                                 @Valid @RequestBody Product product) {

        product.setId(id);

        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }

        productService.updateProduct(product);
        return product;
    }

    // Delete product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }
}

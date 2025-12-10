package com.adminPanel.app.service;

import com.adminPanel.app.model.Product;
import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    Product getProductById(int id);
    void updateProduct(Product product);
    void deleteProduct(int id);
    List<Product> getAllProducts();
}

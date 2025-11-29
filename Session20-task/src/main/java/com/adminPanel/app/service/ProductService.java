package com.adminPanel.app.service;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

import java.util.List;

public interface ProductService {
    ProductDetails insertProductDetails(ProductDetails details);
    ProductDetails updateProductDetails(ProductDetails details);
    void deleteProductDetails(int id);
    ProductDetails getProductDetailsById(int id);
    ProductDetails getProductDetailsByName(String name);

    // Product operations
    List<Product> getAllProducts();
    Product getProductById(int id);
}

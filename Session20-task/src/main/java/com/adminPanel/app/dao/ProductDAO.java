package com.adminPanel.app.dao;
import java.util.List;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

public interface ProductDAO {

    ProductDetails insertProductDetails(ProductDetails details);
    ProductDetails updateProductDetails(ProductDetails details);
    void deleteProductDetails(int id);
    ProductDetails getProductDetailsById(int id);
    ProductDetails getProductDetailsByName(String name);

    // Product operations
    List<Product> getAllProducts();
    Product getProductById(int id);
}

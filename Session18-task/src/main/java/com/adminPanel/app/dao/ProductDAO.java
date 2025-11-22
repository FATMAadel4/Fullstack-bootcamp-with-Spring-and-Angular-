package com.adminPanel.app.dao;
import java.util.List;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

public interface ProductDAO {

    void insert(Product product);

    Product findById(int id);

    void deleteById(int id);

    void update(Product product);

    List<Product> getAllProducts();
}

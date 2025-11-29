package com.adminPanel.app.service;

import com.adminPanel.app.dao.ProductDAO;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    @Transactional
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }


    @Override
    @Transactional
    public ProductDetails insertProductDetails(ProductDetails details) {
        return productDAO.insertProductDetails(details);
    }

    @Override
    @Transactional
    public ProductDetails updateProductDetails(ProductDetails details) {
        return productDAO.updateProductDetails(details);
    }

    @Override
    @Transactional
    public void deleteProductDetails(int id) {
        productDAO.deleteProductDetails(id);
    }

    @Override
    @Transactional
    public ProductDetails getProductDetailsById(int id) {
        return productDAO.getProductDetailsById(id);
    }

    @Override
    @Transactional
    public ProductDetails getProductDetailsByName(String name) {
        return productDAO.getProductDetailsByName(name);
    }
}

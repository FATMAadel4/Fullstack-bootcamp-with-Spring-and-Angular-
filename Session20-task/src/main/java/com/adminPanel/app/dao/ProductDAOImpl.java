package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Product getProductById(int id) {
        return getCurrentSession().get(Product.class, id);
    }

    @Override
    public List<Product> getAllProducts() {
        Query<Product> query = getCurrentSession().createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Override
    public ProductDetails insertProductDetails(ProductDetails details) {
        getCurrentSession().saveOrUpdate(details);
        return details;
    }


    @Override
    public ProductDetails updateProductDetails(ProductDetails details) {
        getCurrentSession().saveOrUpdate(details);
        return details;
    }

    @Override
    public void  deleteProductDetails(int id) {
        Product product = getCurrentSession().get(Product.class, id);
        if (product != null) getCurrentSession().delete(product);
    }



    @Override
    public ProductDetails getProductDetailsById(int id) {
        return getCurrentSession().get(ProductDetails.class, id);
    }

    @Override
    public ProductDetails getProductDetailsByName(String name) {
        Query<ProductDetails> query = getCurrentSession()
                .createQuery("from ProductDetails where name = :name", ProductDetails.class);
        query.setParameter("name", name);
        return query.uniqueResult();
    }



}

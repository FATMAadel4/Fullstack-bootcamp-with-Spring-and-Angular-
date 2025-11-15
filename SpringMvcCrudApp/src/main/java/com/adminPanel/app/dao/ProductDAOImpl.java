package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void insert(Product product) {
        getCurrentSession().saveOrUpdate(product);
    }

    @Override
    public List<Product> getAllProducts() {
        Query<Product> query = getCurrentSession().createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(int id) {
        return getCurrentSession().get(Product.class, id);
    }

    @Override
    public void update(Product product) {
        getCurrentSession().merge(product);
    }

    @Override
    public void deleteById(int id) {
        Product product = getCurrentSession().get(Product.class, id);
        if (product != null) {
            getCurrentSession().delete(product);
        }
    }
}

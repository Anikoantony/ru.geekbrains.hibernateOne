package ru.mvgrebenyuk.hiberOne;

import org.hibernate.Session;

import java.util.List;

public class ProductDaoImplement implements ProductDao{

    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImplement(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class,id);
            session.getTransaction().commit();
            return product;
        }
    }

   /* public User findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.getTransaction().commit();
            return user;
        }*/

    @Override
    public List<Product> findAll() {
        List<Product> products;
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
        }
        return products;
    }

    @Override
    public void deleteById(Long iddd) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.createQuery("delete from Product where id=:idd")
                    .setParameter("idd",iddd)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveOrUpdate(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }
}

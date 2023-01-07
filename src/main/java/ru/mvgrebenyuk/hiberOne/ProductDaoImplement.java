package ru.mvgrebenyuk.hiberOne;

import org.hibernate.Session;

import javax.sound.midi.Soundbank;
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

  //  и по id товара узнавать список покупателей этого товара;
       public void byIdProductFindCostumer(Long id)
       {
           try {
               Session session = sessionFactoryUtils.getSession();
               session.beginTransaction();
              // Costumer costumer = session.get(Costumer.class,id);
               Product product = (Product) session
                       .createQuery("select p from Product p where p.id=:id")
                       .setParameter("id",id)
                       .getSingleResult();
               System.out.println("Продукт по Id ");
               System.out.println(product);

               Costumer costumer=product.getCostumer();
               System.out.println("И его покупатель:");
               System.out.println(costumer);
               session.getTransaction().commit();

           } catch (Exception e) {
               throw new RuntimeException(e);
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
        for (Product product:products
             ) {
            System.out.println("Product " + product.getId().toString() + " " + product);

        }
        return products;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.createQuery("delete from Product where id=:id")
                            .setParameter("id",id)
                                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

/*    @Override
    public void deleteById(Long iddd) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            // удаление через HQL и праметр id
            session.createQuery("delete from Product where id=:idd")
                    .setParameter("idd",iddd)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }*/

    @Override
    public void saveOrUpdate(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }
}

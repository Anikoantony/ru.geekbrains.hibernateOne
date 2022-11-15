package ru.mvgrebenyuk.hiberOne;

import org.hibernate.Session;

import java.util.List;

public class CostumerDaoImplements {
   private SessionFactoryUtils sessionFactoryUtils;

   public CostumerDaoImplements(SessionFactoryUtils sessionFactoryUtils) {
      this.sessionFactoryUtils = sessionFactoryUtils;
   }

   public Costumer findById(Long id)
   {
      Session session = sessionFactoryUtils.getSession();
      session.beginTransaction();
      Costumer costumer = session.get(Costumer.class,id);
      session.getTransaction().commit();
      return costumer;
   }

   public Costumer findByNane(String name)
   {
      Session session = sessionFactoryUtils.getSession();
      session.beginTransaction();
      Costumer costumer=session.createQuery("select u from Costumer u where u.name_cust =:name", Costumer.class)
              .setParameter("name", name)
              .getSingleResult();
      session.getTransaction().commit();
      return costumer;
   }

   public List<Product> returnProductsById(Long id)
   {
      Session session = sessionFactoryUtils.getSession();
      session.beginTransaction();
      Costumer costumer = session.get(Costumer.class,id);
      List<Product> products = costumer.getProducts();
      session.getTransaction().commit();
      return products;
   }

   public String returnProductById (int idProd, Long id)
   {
      Session session = sessionFactoryUtils.getSession();
      session.beginTransaction();
      Costumer costumer = session.get(Costumer.class,id);
      String product = costumer.getProducts().get(idProd).getTitle();
      session.getTransaction().commit();
      return product;
   }
}

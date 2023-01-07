package ru.mvgrebenyuk.hiberOne;

import org.hibernate.Session;

import java.util.List;

public class CostumerDao {
    SessionFactoryUtils sessionFactoryUtils;

    public CostumerDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;}

    public void byIdCostumerFindProduct (Long id)
    {

        // 3. * Создаете сервис, позволяющий по id покупателя узнать список купленных им товаров,
        // и по id товара узнавать список покупателей этого товара;

        try {
            Session session = sessionFactoryUtils.getSession();
            session.beginTransaction();
            Costumer costumer=session.get(Costumer.class,id);
            List<Product> products = costumer.getProducts();
            System.out.println("Список купленных товаров покупателем " + costumer);
            for (Product product:products
                 ) {
                System.out.println(product);
                }

            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




    public Costumer findById(Long id)
    {
        try {
            Session session=sessionFactoryUtils.getSession();
            session.beginTransaction();
            Costumer costumer= session.get(Costumer.class,id);
            session.getTransaction().commit();
            return costumer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


}

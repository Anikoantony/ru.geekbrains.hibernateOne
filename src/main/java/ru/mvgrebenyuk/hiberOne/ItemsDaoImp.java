package ru.mvgrebenyuk.hiberOne;

import org.apache.tapestry5.annotations.Component;
import org.hibernate.Session;

import java.util.List;


public class ItemsDaoImp implements ItemsDao {

    SessionFactoryUtils sessionFactoryUtils;

    public ItemsDaoImp(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Items findByid(Long id) {
        try {
            Session session = sessionFactoryUtils.getSession(); // инициация транзакции в канкретном методе из Sassion Factory
            session.beginTransaction(); // начать транзакцию
            Items items = session.get(Items.class, 1L); // запрос по сессии по классу
            session.getTransaction().commit(); // завершить или закомитеть транзакцию
            return items;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Items> findAllItems() {
        try {
            Session session = sessionFactoryUtils.getSession();
            session.beginTransaction();
            List<Items> items = session.createQuery("select i from Items i where i.id < 40").getResultList();
            session.getTransaction().commit();
            for (Items item1: items
            ) {
                System.out.println("Все ITEMS " + item1);
            }

            return items;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Items findByName(String name) {
        try {
            Session session = sessionFactoryUtils.getSession();
            session.beginTransaction();
            Items item = (Items) session
                    .createQuery("select i from Items i where i.title =:name")
                    .setParameter("name", name)
                            .getSingleResult();
            session.getTransaction().commit();
            return item;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Items items) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        session.saveOrUpdate(items);
        session.getTransaction().commit();
    }

    @Override
    public void updateByName(Long id, String name) {
        try {
            Session session = sessionFactoryUtils.getSession();
            session.beginTransaction();
            Items items=session.get(Items.class, id);
            items.setTitle(name);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}

package ru.mvgrebenyuk.hiberOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.sound.midi.Soundbank;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            CostumerDaoImplements costumerDaoImplements = new CostumerDaoImplements(sessionFactoryUtils);
            ProductDaoImplement productDaoImplement=new ProductDaoImplement(sessionFactoryUtils);
            // поиск покупателя по ID через Dao
            System.out.println(costumerDaoImplements.findById(1L));
            // поиск покупателя по ID через Dao
            System.out.println(costumerDaoImplements.findByNane("Jack"));
            // вытащить продукт у клиента через Dao клиент
            System.out.println(costumerDaoImplements.returnProductById(0,1L));

            //Вытащить List продуктаов по клиент:
            List<Product> products=costumerDaoImplements.returnProductsById(1L);
            System.out.println("Продукты "+products.get(2).getTitle());

            //вытащить клиента по продукту через DAO продукта
            System.out.println(productDaoImplement.findCostumerById(1L));



           // System.out.println(costumerDaoImplements.returnProductsById(1L));
            } catch (Exception e) {
            throw new RuntimeException(e);
        }

        /*try {
            NewUserDao newUserDao = new NewUserDaoImplement(sessionFactoryUtils);
            System.out.println(newUserDao.findeById(1L));
            System.out.println(newUserDao.findAll());
            System.out.println(newUserDao.findByName("Bob"));
            User user = new User("Ivan",7);
           // user.setId(10L);
            newUserDao.save(user);
          //  newUserDao.update(2L, "MAMBA");

            System.out.println(newUserDao.findAll());
            newUserDao.testCash();

            System.out.println("========================================================");
            ProductDao productDao = new ProductDaoImplement(sessionFactoryUtils);
            System.out.println(productDao.findById(1l));
            productDao.deleteById(1l);
            System.out.println(productDao.findAll());

            System.out.println("========================================================");

           CostumerDaoImplements costumerDaoImplements = new CostumerDaoImplements(sessionFactoryUtils);
            costumerDaoImplements.findById(1L);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } */

       /* try {
                UserDao userDao = new UserDaoImpl(sessionFactoryUtils);
                userDao.testCache();
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                sessionFactoryUtils.shotdown();
            } */
      /*  try {
            // исспользцем подключение через фабрику сессий для подключения
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
            // берем текущую сессию
            Session session = factory.getCurrentSession();
            // работаем по транзакции
            session.beginTransaction();
            User user = session.get(User.class,1l);
            System.out.println(user);
            session.getTransaction().commit();
            if (factory!=null)
            {factory.close();}

        } catch (Exception e) {
            throw new RuntimeException(e);
        } */


    }
}

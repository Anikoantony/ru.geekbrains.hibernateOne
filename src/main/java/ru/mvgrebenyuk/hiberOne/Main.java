package ru.mvgrebenyuk.hiberOne;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.sound.midi.Soundbank;
import java.util.List;


public class Main {

    private static SessionFactory factory;



    public static void main(String[] args) {
// 2. Для обеих сущностей создаете Dao классы. Работу с SessionFactory выносите во вспомогательный класс;
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
          /*
            1. В базе данных необходимо реализовать возможность хранить информацию о покупателях (id, имя) и товарах (id, название, стоимость). У каждого покупателя свой набор купленных товаров;
            2. Для обеих сущностей создаете Dao классы. Работу с SessionFactory выносите во вспомогательный класс;
            3. * Создаете сервис, позволяющий по id покупателя узнать список купленных им товаров, и по id товара узнавать список покупателей этого товара;
           */
            CostumerDao costumerDao= new CostumerDao(sessionFactoryUtils);


            // * Создаете сервис, позволяющий по id покупателя узнать список купленных им товаров,

           Costumer costumer=costumerDao.findById(1L);
           System.out.println("Поиск по Id покупателя " + costumer);

           // -------------------------- findById(Long id)
           //  и по id товара узнавать список покупателей этого товара;

            costumerDao.byIdCostumerFindProduct(1L); //
            ProductDaoImplement productDao = new ProductDaoImplement(sessionFactoryUtils);
            productDao.byIdProductFindCostumer(1L);


            /*
            Product product = productDao.findById(1L);
            System.out.println(product);
            // findAll()
            productDao.findAll();

            // deleteById(Long id)
            productDao.deleteById(1L);
            productDao.findAll();

            // Product saveOrUpdate(Product product));
            productDao.saveOrUpdate(new Product("BAG",1800));
            productDao.findAll();

            ItemsDao itemsDao = new ItemsDaoImp(sessionFactoryUtils);

            Items item = itemsDao.findByid(1L);
            System.out.println("Класс ITEMS " + item.toString());

            itemsDao.findAllItems();

            Items items1 = itemsDao.findByName("BOX");
            System.out.println("Items by name " + items1.toString());

            itemsDao.save(new Items("BOAT"));

            itemsDao.findAllItems();

            itemsDao.updateByName(1L, "DOLL");
            itemsDao.findAllItems();*/

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


      /*  try {
            init();
            Session session=null;
            session=factory.getCurrentSession();
            session.beginTransaction();
            User user=session.get(User.class, 1L);
            System.out.println(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        } finally {
            shutdown();
        }*/


        /*
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();

        try {
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


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        */

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

    public static void init()
    {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void shutdown()
    {
        if (factory!=null)
        {
            factory.close();
        }
    }
}

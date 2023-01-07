// 2. Для обеих сущностей создаете Dao классы. Работу с SessionFactory выносите во вспомогательный класс;
package ru.mvgrebenyuk.hiberOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionFactoryUtils {
    private SessionFactory factory;

    public void init(){
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public Session getSession(){
        return factory.getCurrentSession();
    }

    public void shotdown(){
        if(factory != null){
            factory.close();
        }
    }

}

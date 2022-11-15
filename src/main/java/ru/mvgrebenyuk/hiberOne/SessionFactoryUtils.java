package ru.mvgrebenyuk.hiberOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class SessionFactoryUtils {
    private SessionFactory factory;

    public void init(){

        factory = new Configuration()
                .configure("hibernate.cfg.prep.xml")
                .buildSessionFactory();
        Session session=null;
        try {
            String sql= Files.lines(Paths.get("import.sql")).collect(Collectors.joining(" "));
            session=factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* finally {
            factory.close();
            if (session!=null)
            {session.close();}
        }*/

      /*  factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();*/
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

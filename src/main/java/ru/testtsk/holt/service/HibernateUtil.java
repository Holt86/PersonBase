package ru.testtsk.holt.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by user on 28.01.2017.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    static {
        Configuration ctf = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(ctf.getProperties());
        sessionFactory = ctf.buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

package ru.testtsk.holt.base;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.testtsk.holt.model.User;
import ru.testtsk.holt.service.HibernateUtil;

import java.util.Collection;

/**
 * Created by user on 28.01.2017.
 */
public class HibernateBase implements BaseInterface{
    private static final HibernateBase ourInstance = new HibernateBase();
    private final SessionFactory factory;

    public static HibernateBase getInstance() {
        return ourInstance;
    }

    private HibernateBase() {
        factory = HibernateUtil.getSessionFactory();
    }

    public Collection<User> values() {
        final Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            return session.createQuery("FROM User ").list();
        } finally {
            transaction.commit();
            session.close();
        }

    }

    public Collection<User> findUser(String name) {
        final Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            final Query query = session.createQuery("FROM User where name =:paramName");
            query.setParameter("paramName", name);
            return query.list();
        } finally {
            transaction.commit();
            session.close();
        }
    }

    public void add(User user) {
        final Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();


    }

    public void edit(User user) {
        final Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("UPDATE User set name =:paramName, age =:paramAge, isAdmin =:paramIsAdmin where id =:paramId");
        query.setParameter("paramName", user.getName());
        query.setParameter("paramAge", user.getAge());
        query.setParameter("paramIsAdmin", user.getIsAdmin());
        query.setParameter("paramId", user.getId());
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE User where id =:paramId");
        query.setParameter("paramId", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public User getUser(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            return (User) session.get(User.class, id);
        }finally {
            transaction.commit();
            session.close();
        }
    }

    public void close() {
        factory.close();
    }
}

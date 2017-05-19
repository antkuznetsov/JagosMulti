package ru.innopolis.models.classes;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.models.entities.User;
import ru.innopolis.models.interfaces.UserDao;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kuznetsov on 22/04/2017.
 */


@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    private BCryptPasswordEncoder encoder;
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<User> getList() {

        Session session = this.sessionFactory.openSession();
        List<User> users = session.createQuery("FROM User u ORDER BY u.id").list();
        session.close();

        return users;
    }

    @Transactional(readOnly = true)
    public User getById(int id) {

        Session session = this.sessionFactory.openSession();

        User user = session.get(User.class, id);
        session.close();

        return user;
    }

    public void add(User user) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        tx.commit();
        session.close();
    }

    public void update(User user) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }

    public void delete(int id) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = session.load(User.class, id);
        session.delete(user);
        tx.commit();
        session.close();
    }

    public Map<Integer, String> getAuthors() {

        Session session = this.sessionFactory.openSession();
        List<User> users = session.createQuery("FROM User u WHERE u.groupId = 1 ORDER BY u.id").list();
        session.close();

        Map<Integer, String> authors = new HashMap<Integer, String>();

        for (User user : users) {
            authors.put(user.getId(), user.getName() + " " + user.getLastName());
        }

        return authors;
    }

    @Transactional(readOnly = true)
    public int getCount() {

        Session session = this.sessionFactory.openSession();

        Number count = (Number) session.createCriteria(User.class).setProjection(Projections.rowCount()).uniqueResult();
        session.close();

        return count.intValue();
    }

    public BCryptPasswordEncoder getEncoder() {
        return encoder;
    }

    @Autowired
    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
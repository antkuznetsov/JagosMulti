package ru.innopolis.models.classes;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.models.entities.Course;
import ru.innopolis.models.interfaces.CourseDao;

import java.util.List;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

@Repository
public class CourseDaoImpl implements CourseDao {

    private static final Logger LOGGER = Logger.getLogger(CourseDaoImpl.class);

    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Course> getList() {

        Session session = this.sessionFactory.openSession();
        List<Course> courses = session.createQuery("FROM Course c ORDER BY c.id").list();
        session.close();

        return courses;
    }

    @Transactional(readOnly = true)
    public Course getById(int id) {

        Session session = this.sessionFactory.openSession();
        Course course = session.get(Course.class, id);
        session.close();

        return course;
    }

    public void add(Course course) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(course);
        tx.commit();
        session.close();
    }

    public void update(Course course) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(course);
        tx.commit();
        session.close();
    }

    public void delete(int id) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Course course = session.load(Course.class, id);
        session.delete(course);
        tx.commit();
        session.close();
    }

    public int getCount() {

        Session session = this.sessionFactory.openSession();

        Number count = (Number) session.createCriteria(Course.class).setProjection(Projections.rowCount()).uniqueResult();
        session.close();

        return count.intValue();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
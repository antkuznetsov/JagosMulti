package ru.innopolis.models.classes;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.entities.Lesson;
import ru.innopolis.models.interfaces.LessonDao;

import java.util.List;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

@Repository
public class LessonDaoImpl implements LessonDao {

    private static final Logger LOGGER = Logger.getLogger(LessonDaoImpl.class);

    private SessionFactory sessionFactory;

    public List<Lesson> getListByCourseId(int courseId) {

        Session session = this.sessionFactory.openSession();
        List<Lesson> lessons = session.createQuery("FROM Lesson l WHERE l.courseId = " + courseId + "ORDER BY l.id").list();
        session.close();

        return lessons;
    }

    public List<Lesson> getList() {

        Session session = this.sessionFactory.openSession();
        List<Lesson> lessons = session.createQuery("FROM Lesson l ORDER BY l.id").list();
        session.close();

        return lessons;
    }

    public Lesson getById(int id) {

        Session session = this.sessionFactory.openSession();

        Lesson lesson = session.get(Lesson.class, id);
        session.close();

        return lesson;
    }

    public void add(Lesson lesson) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(lesson);
        tx.commit();
        session.close();
    }

    public void update(Lesson lesson) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(lesson);
        tx.commit();
        session.close();
    }

    public void delete(int id) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Lesson lesson = session.load(Lesson.class, id);
        session.delete(lesson);
        tx.commit();
        session.close();
    }

    public int getCount() {

        Session session = this.sessionFactory.openSession();

        Number count = (Number) session.createCriteria(Lesson.class).setProjection(Projections.rowCount()).uniqueResult();
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
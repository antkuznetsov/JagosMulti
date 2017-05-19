package ru.innopolis.services.classes;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.entities.Course;
import ru.innopolis.models.interfaces.CourseDao;
import ru.innopolis.services.interfaces.CourseService;

import java.util.List;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

@Repository
public class CourseServiceImpl implements CourseService {

    private static final Logger LOGGER = Logger.getLogger(CourseServiceImpl.class);

    @Autowired
    private CourseDao courseDao;

    public List<Course> getList() {
        return courseDao.getList();
    }

    public void add(Course course) {
        courseDao.add(course);
    }

    public Course getById(int id) {
        return courseDao.getById(id);
    }

    public void update(Course course) {
        courseDao.update(course);
    }

    public void delete(int id) {
        courseDao.delete(id);
    }

    public int getCount() {
        return courseDao.getCount();
    }
}

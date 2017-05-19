package ru.innopolis.services.classes;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.models.entities.Lesson;
import ru.innopolis.models.interfaces.LessonDao;
import ru.innopolis.services.interfaces.LessonService;

import java.util.List;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

@Service
public class LessonServiceImpl implements LessonService {

    private static final Logger LOGGER = Logger.getLogger(LessonServiceImpl.class);

    @Autowired
    private LessonDao lessonDao;

    public List<Lesson> getListByCourseId(int courseId) {
        return lessonDao.getListByCourseId(courseId);
    }

    public List<Lesson> getList() {
        return lessonDao.getList();
    }

    public void add(Lesson lesson) {
        lessonDao.add(lesson);
    }

    public Lesson getById(int id) {
        return lessonDao.getById(id);
    }

    public void update(Lesson lesson) {
        lessonDao.update(lesson);
    }

    public void delete(int id) {
        lessonDao.delete(id);
    }

    public int getCount() {
        return lessonDao.getCount();
    }
}
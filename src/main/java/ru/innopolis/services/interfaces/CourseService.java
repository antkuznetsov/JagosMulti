package ru.innopolis.services.interfaces;

import ru.innopolis.models.entities.Course;

import java.util.List;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

public interface CourseService {
    List<Course> getList();

    Course getById(int id);

    void add(Course course);

    void update(Course course);

    void delete(int id);

    int getCount();
}
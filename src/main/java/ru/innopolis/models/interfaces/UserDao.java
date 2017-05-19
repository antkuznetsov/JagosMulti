package ru.innopolis.models.interfaces;

import ru.innopolis.models.entities.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

public interface UserDao {
    List<User> getList();

    User getById(int id);

    void add(User student);

    void update(User student);

    void delete(int id);

    Map<Integer, String> getAuthors();

    int getCount();
}
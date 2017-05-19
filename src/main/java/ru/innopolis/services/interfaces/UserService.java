package ru.innopolis.services.interfaces;


import ru.innopolis.models.entities.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

public interface UserService {
    List<User> getList();

    User getById(int id);

    void add(User user);

    void update(User user);

    void delete(int id);

    Map<Integer, String> getAuthors();

    int getCount();
}
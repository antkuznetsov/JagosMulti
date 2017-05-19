package ru.innopolis.services.classes;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.models.entities.User;
import ru.innopolis.models.interfaces.UserDao;
import ru.innopolis.services.interfaces.UserService;

import java.util.List;
import java.util.Map;

/**
 * Created by Kuznetsov on 22/04/2017.
 */

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    public List<User> getList() {
        return userDao.getList();
    }

    public void add(User user) {
        userDao.add(user);
    }

    public User getById(int id) {
        return userDao.getById(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public Map<Integer, String> getAuthors() {
        return userDao.getAuthors();
    }

    public int getCount() {
        return userDao.getCount();
    }
}
package com.devIncubator.task.service.impl;

import com.devIncubator.task.dao.UserDao;
import com.devIncubator.task.dao.impl.UserDaoImpl;
import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.DaoException;
import com.devIncubator.task.exception.ServiceException;
import com.devIncubator.task.service.UserService;

import java.util.List;

/**
 * This class implements {@link UserService}
 *
 * @author Shpakova A.
 */

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public List<User> takeAllUsers() throws ServiceException {
        try {
            return userDao.takeAllUsers();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User findUserById(int userId) throws ServiceException {
        try {
            return userDao.findById(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}

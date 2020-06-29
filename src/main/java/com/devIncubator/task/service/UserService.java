package com.devIncubator.task.service;

import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.ServiceException;

import java.util.List;

/**
 * Interface for {@link com.devIncubator.task.service.impl.UserServiceImpl}
 *
 * @author Shpakova A.
 */

public interface UserService {
    List<User> takeAllUsers() throws ServiceException;

    User findUserById(int userId) throws ServiceException;

}

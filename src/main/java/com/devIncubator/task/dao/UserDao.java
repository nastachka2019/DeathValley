package com.devIncubator.task.dao;


import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.DaoException;

import java.util.List;

/**
 * Interface for actions with {@link User} according DAO and database data
 *
 * @author Shpakova A.
 */

public interface UserDao extends BasicDao<User> {
    /**
     * Method: show all registered users
     *
     * @return list of users
     */
    List<User> takeAllUsers() throws DaoException;
}

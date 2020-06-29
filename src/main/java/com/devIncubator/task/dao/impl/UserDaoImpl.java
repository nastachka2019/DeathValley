package com.devIncubator.task.dao.impl;

import com.devIncubator.task.connection.ConnectionPool;
import com.devIncubator.task.dao.UserDao;
import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for actions with {@link com.devIncubator.task.entity.User} according DAO and database data
 *
 * @author Shpakova A.
 */

public class UserDaoImpl implements UserDao {

    Connection connection = ConnectionPool.INSTANCE.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private static final String SQL_FIND_USER_BY_ID = "SELECT userId, name, surname FROM user WHERE userId=?";
    private static final String SQL_TAKE_ALL_USERS = "SELECT userId, name, surname FROM user";

    @Override
    public List<User> takeAllUsers() throws DaoException {
        List<User> userList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_TAKE_ALL_USERS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userList.add(new User.Builder(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)).build());
            }
            return userList;

        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public User findById(Integer id) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return
                        new User.Builder(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)).build();

            } else {
                throw new DaoException("No user with such id");
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }
}

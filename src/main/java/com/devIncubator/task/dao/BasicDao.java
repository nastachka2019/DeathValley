package com.devIncubator.task.dao;

import com.devIncubator.task.connection.ConnectionPool;
import com.devIncubator.task.entity.Entity;
import com.devIncubator.task.exception.ConnectionPoolException;
import com.devIncubator.task.exception.DaoException;
import org.apache.logging.log4j.LogManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Description of common methods that will be used when interacting with the database
 *
 * @author Shpakova A.
 */

public interface BasicDao<T extends Entity> {
    /**
     * Method: find object by id in database table depending on method's realization
     * and create suitable object.
     *
     * @return found object
     * @throws DaoException object
     */
    T findById(Integer id) throws DaoException;

    /**
     * Method: close Statement
     *
     * @param resultSet ResultSet
     */
    default void closeResultSet(ResultSet resultSet) { //метод закрытия экземпляра ResultSet
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LogManager.getLogger().error(e.getMessage(), e);
            }
        }
    }

    /**
     * Method: close Statement
     *
     * @param statement Statement
     */
    default void closePreparedStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LogManager.getLogger().error(e.getMessage(), e);
            }
        }
    }

    /**
     * Method: Returning a Connection instance to the connection pool
     */
    default void closeConnection(Connection connection) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.INSTANCE;
        try {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        } catch (ConnectionPoolException e) {
            throw new DaoException();
        }
    }
}

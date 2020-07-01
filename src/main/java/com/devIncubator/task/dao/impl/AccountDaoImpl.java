package com.devIncubator.task.dao.impl;

import com.devIncubator.task.connection.ConnectionPool;
import com.devIncubator.task.dao.AccountDao;
import com.devIncubator.task.entity.Account;
import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.DaoException;
import com.devIncubator.task.exception.ServiceException;
import com.devIncubator.task.service.UserService;
import com.devIncubator.task.service.impl.UserServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    Connection connection = ConnectionPool.INSTANCE.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private static final String SQL_FIND_ACCOUNT_BY_ID = "SELECT accountId, accountUser, userId FROM account WHERE accountId=?";
    private static final String SQL_TAKE_ALL_ACCOUNTS = "SELECT accountId, accountUser, userId FROM account";

    private User findUserById(int userId) throws ServiceException {
        UserService userService = new UserServiceImpl();
        return userService.findUserById(userId);
    }
    @Override
    public List<Account> takeAllAccounts() throws DaoException {
        List<Account> accountList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_TAKE_ALL_ACCOUNTS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                accountList.add(new Account.Builder(resultSet.getInt(1), resultSet.getInt(2),findUserById(resultSet.getInt(3))).build());
            }
            return accountList;

        } catch (SQLException | ServiceException e) {
            throw new DaoException(e);
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public Account findById(Integer id) throws DaoException {
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_ACCOUNT_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return
                        new Account.Builder(resultSet.getInt(1), resultSet.getInt(2), findUserById(resultSet.getInt(3))).build();

            } else {
                throw new DaoException("No account with such id");
            }

        } catch (SQLException | ServiceException e) {
            throw new DaoException(e);
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }
}

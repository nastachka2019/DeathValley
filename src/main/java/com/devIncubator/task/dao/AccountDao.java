package com.devIncubator.task.dao;

import com.devIncubator.task.dao.BasicDao;
import com.devIncubator.task.entity.Account;
import com.devIncubator.task.exception.DaoException;

import java.util.List;

public interface AccountDao extends BasicDao<Account> {
    /**
     * Method: show all registered users
     *
     * @return list of users
     */
    List<Account> takeAllAccounts() throws DaoException;
}

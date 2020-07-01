package com.devIncubator.task.dao;


import com.devIncubator.task.entity.Account;
import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.DaoException;

import java.util.List;

/**
 * Interface for actions with {@link Account} according DAO and database data
 *
 * @author Shpakova A.
 */
public interface AccountDao extends BasicDao<Account> {
    /**
     * Method: show all accounts
     *
     * @return list of accounts
     */
    List<Account> takeAllAccounts() throws DaoException;
}

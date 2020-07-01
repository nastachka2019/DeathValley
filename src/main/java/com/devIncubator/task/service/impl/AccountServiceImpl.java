package com.devIncubator.task.service.impl;

import com.devIncubator.task.dao.AccountDao;
import com.devIncubator.task.dao.impl.AccountDaoImpl;
import com.devIncubator.task.entity.Account;
import com.devIncubator.task.exception.DaoException;
import com.devIncubator.task.exception.ServiceException;
import com.devIncubator.task.service.AccountService;
import com.devIncubator.task.service.UserService;

import java.util.List;

/**
 * This class implements {@link AccountService}
 *
 * @author Shpakova A.
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public AccountServiceImpl() {
        this.accountDao = new AccountDaoImpl();
    }

    @Override
    public List<Account> takeAllAccounts() throws ServiceException {
        try {
            return accountDao.takeAllAccounts();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Account findAccountById(int accountId) throws ServiceException {
        try {
            return accountDao.findById(accountId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}

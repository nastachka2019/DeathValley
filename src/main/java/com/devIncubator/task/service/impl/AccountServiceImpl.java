package com.devIncubator.task.service.impl;

import com.devIncubator.task.dao.AccountDao;
import com.devIncubator.task.dao.UserDao;
import com.devIncubator.task.dao.impl.AccountDaoImpl;
import com.devIncubator.task.dao.impl.UserDaoImpl;
import com.devIncubator.task.entity.Account;
import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.DaoException;
import com.devIncubator.task.exception.ServiceException;
import com.devIncubator.task.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public AccountServiceImpl() {                 //если нужно будет вызвать м-ды из др. классов
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

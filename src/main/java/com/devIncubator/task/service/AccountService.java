package com.devIncubator.task.service;

import com.devIncubator.task.entity.Account;
import com.devIncubator.task.exception.ServiceException;

import java.util.List;

/**
 * Interface for {@link com.devIncubator.task.service.impl.AccountServiceImpl}
 *
 * @author Shpakova A.
 */
public interface AccountService {
    List<Account> takeAllAccounts() throws ServiceException;

    Account findAccountById(int accountId) throws ServiceException;
}

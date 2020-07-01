package com.devIncubator.task.service;

import com.devIncubator.task.entity.Account;
import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.ServiceException;

import java.util.List;

public interface AccountService {
    List<Account> takeAllAccounts() throws ServiceException;

   Account findAccountById(int accountId) throws ServiceException;
}

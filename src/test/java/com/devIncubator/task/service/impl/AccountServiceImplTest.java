package com.devIncubator.task.service.impl;

import com.devIncubator.task.connection.ConnectionPool;
import com.devIncubator.task.entity.Account;
import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.ServiceException;
import com.devIncubator.task.service.AccountService;
import com.devIncubator.task.service.UserService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class AccountServiceImplTest {

    @DataProvider
    public Object[][] testFindAccountById() {
        return new Object[][]{
                {6, 230},
        };
    }

    @Test(dataProvider = "testFindAccountById") //positive
    public void testFindAccountById(Integer accountId, Integer accountUser) throws ServiceException {
        ConnectionPool.INSTANCE.getConnection();
        AccountService accountService = new AccountServiceImpl();
        Account account = accountService.findAccountById(accountId);
        Assert.assertEquals(account.getAccountUser(), accountUser);
    }

    @DataProvider
    public Object[][] testFindAccountByIdNegative() {
        return new Object[][]{
                {6, 0},
        };
    }

    @Test(dataProvider = "testFindAccountByIdNegative") //negative
    public void testFindAccountByIdNegative(Integer accountId, Integer accountUser) throws ServiceException {
        ConnectionPool.INSTANCE.getConnection();
        AccountService accountService = new AccountServiceImpl();
        Account account = accountService.findAccountById(accountId);
        Assert.assertEquals(account.getAccountUser(), accountUser);
    }

    @Test //positive
    public void testTakeAllAccounts() throws ServiceException {
        ConnectionPool.INSTANCE.getConnection();
        AccountService accountService = new AccountServiceImpl();
        List<Account> accounts = accountService.takeAllAccounts();
        int actual = 11;
        int expected = accounts.size();
        Assert.assertEquals(actual, expected);
    }
}
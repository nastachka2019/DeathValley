package com.devIncubator.task.service.impl;

import com.devIncubator.task.connection.ConnectionPool;
import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.ServiceException;
import com.devIncubator.task.service.UserService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class UserServiceImplTest {
    @DataProvider
    public Object[][] testFindUserById() {
        return new Object[][]{
                {1, "Anna"},
        };
    }

    @Test(dataProvider = "testFindUserById") //positive
    public void testFindUserById(Integer userId, String name) throws ServiceException {
        ConnectionPool.INSTANCE.getConnection();
        UserService userService = new UserServiceImpl();
        User user = userService.findUserById(userId);
        Assert.assertEquals(user.getName(), name);
    }

    @DataProvider
    public Object[][] testFindUserByIdNegative() {
        return new Object[][]{
                {1, "David"},
        };
    }

    @Test(dataProvider = "testFindUserByIdNegative") //negative
    public void testFindUserByIdNegative(Integer userId, String name) throws ServiceException {
        ConnectionPool.INSTANCE.getConnection();
        UserService userService = new UserServiceImpl();
        User user = userService.findUserById(userId);
        Assert.assertEquals(user.getName(), name);
    }

    @Test //positive
    public void testTakeAllUsers() throws ServiceException {
        ConnectionPool.INSTANCE.getConnection();
        UserService userService = new UserServiceImpl();
        List<User> users = userService.takeAllUsers();
        int actual = 11;
        int expected = users.size();
        Assert.assertEquals(actual, expected);
    }
}
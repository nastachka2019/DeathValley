package com.devIncubator.task.service.impl;

import com.devIncubator.task.connection.ConnectionPool;
import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.ServiceException;
import com.devIncubator.task.service.UserService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserServiceImplTest {
    @DataProvider
    public Object[][] testTakeAllUsers() {
        return new Object[][]{
                {1, "Anna"},
        };
    }

    @Test(dataProvider = "testTakeAllUsers") //positive
    public void testTakeAllUsers(Integer userId, String name) throws ServiceException {
        ConnectionPool.INSTANCE.getConnection();
        UserService userService = new UserServiceImpl();
        User user = userService.findUserById(userId);
        Assert.assertEquals(user.getName(), name);
    }

    @DataProvider
    public Object[][] testTakeAllUsersNegative() {
        return new Object[][]{
                {1, "David"},
        };
    }

    @Test(dataProvider = "testTakeAllUsersNegative") //negative
    public void testTakeAllUsersNegative(Integer userId, String name) throws ServiceException {
        ConnectionPool.INSTANCE.getConnection();
        UserService userService = new UserServiceImpl();
        User user = userService.findUserById(userId);
        Assert.assertEquals(user.getName(), name);
    }

    @Test
    public void testFindUserById() {
    }
}
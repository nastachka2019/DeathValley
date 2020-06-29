package com.devIncubator.task.dao.impl;

import com.devIncubator.task.exception.DaoException;
import com.devIncubator.task.exception.ServiceException;
import com.devIncubator.task.service.impl.UserServiceImpl;

public class DaoTest {
    public static void main(String[] args) throws DaoException, ServiceException {
      //  UserDaoImpl userDao=new UserDaoImpl();
       //System.out.println(userDao.findById(9));
        UserServiceImpl userService=new UserServiceImpl();
       // System.out.println(userService.findUserById(7));
        System.out.println(userService.takeAllUsers());
    }
}

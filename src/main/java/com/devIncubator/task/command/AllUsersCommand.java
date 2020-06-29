package com.devIncubator.task.command;

import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.ServiceException;
import com.devIncubator.task.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AllUsersCommand implements Command {
    private UserServiceImpl userService;

    @Override
    public void execute(HttpServletRequest request) throws ServiceException {
        List<User> users;
        users = userService.takeAllUsers();
        request.setAttribute("allUsers", users);
    }
}

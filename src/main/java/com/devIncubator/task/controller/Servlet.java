package com.devIncubator.task.controller;

import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.ServiceException;
import com.devIncubator.task.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/")
public class Servlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    List<User> userList;

    {
        try {
            userList = userService.takeAllUsers();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/showUsers.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

package com.devIncubator.task.servlets;

import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.ServiceException;
import com.devIncubator.task.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/userList")
public class ServletUserList extends HttpServlet {
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
        //request.setAttribute("list", userList);
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(userList);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}


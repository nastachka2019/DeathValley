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
import java.io.PrintWriter;
@WebServlet("/user")
public class Servlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    User user;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        try {
            user=userService.findUserById(id);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute("users",user);
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(user);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

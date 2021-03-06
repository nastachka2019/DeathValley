package com.devIncubator.task.servlets;

import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.ServiceException;
import com.devIncubator.task.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet receives request, processes it and return answer
 *
 * @author Shpakova A.
 */
@WebServlet("/user")
public class ServletFindUserById extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    User user;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        try {
            user = userService.findUserById(id);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(user);
    }
}

package com.devIncubator.task.servlets;

import com.devIncubator.task.entity.Account;
import com.devIncubator.task.exception.ServiceException;
import com.devIncubator.task.service.impl.AccountServiceImpl;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet receives request, processes it and return answer
 *
 * @author Shpakova A.
 */
@WebServlet(urlPatterns = "/accountList")
public class ServletAccountList extends HttpServlet {
    private AccountServiceImpl accountService = new AccountServiceImpl();
    List<Account> accountList;

    {
        try {
            accountList = accountService.takeAllAccounts();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(accountList);
    }
}
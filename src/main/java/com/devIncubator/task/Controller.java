package com.devIncubator.task;

import com.devIncubator.task.command.Command;
import com.devIncubator.task.command.CommandManager;
import com.devIncubator.task.connection.ConnectionPool;
import com.devIncubator.task.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller receives the request, analyzes it and calls the appropriate method
 *
 * @author Shpakova A.
 */

@WebServlet (urlPatterns = "/users")
public class Controller extends HttpServlet {

    private static final Logger logger = LogManager.getLogger();

    /**
     * Method: describe actions during data initialization.
     */
    @Override
    public void init() throws ServletException {
        super.init();
        ConnectionPool connectionPool = ConnectionPool.INSTANCE;
        logger.debug("Controller initialization");
    }

    /**
     * Method: describe GET action.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            processRequest(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method: describe POST action.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            processRequest(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        String commandName = request.getParameter("action");
        if (commandName != null) {
            Command command = CommandManager.getCommand(commandName);
            command.execute(request);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }


    /**
     * Method: describe actions during unloading the application from the container
     */
    @Override
    public void destroy() {
        super.destroy();
        ConnectionPool.INSTANCE.destroyPool();
        logger.debug("Controller destruction");
    }

}

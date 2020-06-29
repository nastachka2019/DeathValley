package com.devIncubator.task.command;

import com.devIncubator.task.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

/**
 * This interface is used to process the request and response.
 *
 * @author Shpakova A.
 */

public interface Command {
    /**
     * @param request is an incoming request.
     */

    void execute(HttpServletRequest request) throws ServiceException;
}

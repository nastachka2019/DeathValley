package com.devIncubator.task.command;

import com.devIncubator.task.entity.User;
import com.devIncubator.task.exception.ServiceException;
import com.devIncubator.task.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class FindByIdCommand implements Command {
    UserServiceImpl userService=new UserServiceImpl();
    @Override
    public void execute(HttpServletRequest request) {
        List<User> users = new ArrayList<User>();
        User user;
        try {
            user=userService.findUserById(Integer.parseInt(request.getParameter("id")));
        }
        catch (NumberFormatException | ServiceException e){
            request.setAttribute("exception", "Enter Id of User");
            return;
        }
        if(user == null){
            request.setAttribute("exception", "This user is not exist");
        }
        else {
            users.add(user);
            request.setAttribute("users", users);

        }
    }
}

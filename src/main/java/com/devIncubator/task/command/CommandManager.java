package com.devIncubator.task.command;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private enum CommandType {
       ALLUSERS, FINDBYID;
    }

    private static Map<CommandType, Command> commandMap;

    static {
        commandMap = new HashMap<>();
        commandMap.put(CommandType.ALLUSERS, new AllUsersCommand());
        commandMap.put(CommandType.FINDBYID, new FindByIdCommand());
    }

    public static Command getCommand(String commandName) {
        CommandType commandType = CommandType.valueOf(commandName.toUpperCase());
        return commandMap.get(commandType);
    }
}

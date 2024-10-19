package com.evko.JavaTestBot.demo.JavaTestBot.command;

public enum CommandName {
    START("/start"),
    HELP("/help"),
    NO("nocommand");
    private final String commandName;
    CommandName(String commandName){
        this.commandName=commandName;
    }
    public String getCommandName(){
        return commandName;
    }
}

package com.evko.JavaTestBot.demo.JavaTestBot.command;

public enum CommandName {
    START("/start"),
    HELP("/help"),
    NO("nocommand"),
    START_TEST("/starttest");
    private final String commandName;
    CommandName(String commandName){
        this.commandName=commandName;
    }
    public String getCommandName(){
        return commandName;
    }
}

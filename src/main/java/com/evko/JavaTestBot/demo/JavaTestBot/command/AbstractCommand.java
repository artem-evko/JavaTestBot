package com.evko.JavaTestBot.demo.JavaTestBot.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class AbstractCommand implements Command{
    protected String commandIdentifier;

    public abstract String getCommandIdentifier();

}

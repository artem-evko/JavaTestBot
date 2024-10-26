package com.evko.JavaTestBot.demo.JavaTestBot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.evko.JavaTestBot.demo.JavaTestBot.command.CommandName.START_TEST;
@Component

public class StartTestCommand extends AbstractCommand {
    @Override
    public SendMessage buildResponse(Update update) {
        return null;
    }

    @Override
    public String getCommandIdentifier() {
        return START_TEST.getCommandName();
    }
}

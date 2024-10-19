package com.evko.JavaTestBot.demo.JavaTestBot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.evko.JavaTestBot.demo.JavaTestBot.command.CommandName.START;
@Component
public class StartCommand extends AbstractCommand{
    public final static String START_MESSAGE="Привет. Я JavaTestBot. Я помогу тебе изучить Java. " +
            " Напиши команду /help, чтобы узнать что я умею.";
    @Override
    public SendMessage buildResponse(Update update) {
        return new SendMessage(update.getMessage().getChatId().toString(),START_MESSAGE);
    }

    @Override
    public String getCommandIdentifier() {
        return START.getCommandName();
    }
}

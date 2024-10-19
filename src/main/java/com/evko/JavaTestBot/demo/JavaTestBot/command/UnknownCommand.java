package com.evko.JavaTestBot.demo.JavaTestBot.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
@Component
@RequiredArgsConstructor
public class UnknownCommand extends AbstractCommand{

    public static final String UNKNOWN_MESSAGE="Не понимаю вас \uD83D\uDE1F, напишите /help, чтобы узнать, что я понимаю.";
    @Override
    public SendMessage buildResponse(Update update) {
        return new SendMessage(update.getMessage().getChatId().toString(),UNKNOWN_MESSAGE);
    }

    @Override
    public String getCommandIdentifier() {
        return "";
    }
}

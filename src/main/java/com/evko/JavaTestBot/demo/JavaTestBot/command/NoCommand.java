package com.evko.JavaTestBot.demo.JavaTestBot.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class NoCommand extends AbstractCommand{
    public static final String NO_MESSAGE="Я поддерживаю команды, начинающиеся со слеша(/).\n"
            + "Чтобы посмотреть список команд введите /help";
    @Override
    public SendMessage buildResponse(Update update) {
        return new SendMessage(update.getMessage().getChatId().toString(),NO_MESSAGE);
    }

    @Override
    public String getCommandIdentifier() {
        return "nocommand";
    }
}

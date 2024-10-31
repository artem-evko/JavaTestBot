package com.evko.JavaTestBot.demo.JavaTestBot.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.evko.JavaTestBot.demo.JavaTestBot.command.CommandName.HELP;
@Component
@RequiredArgsConstructor
public class HelpCommand extends AbstractCommand{
    public static final String HELP_MESSAGE=String.format("✨Дотупные команды✨\n\n"
    +"Прохождение тестов:\n"
    + "%s - начать тест с рандомными вопросами\n"
    + "%s - начать тест с вопросами с указаным уровнем сложности\n\n"

    + "Уровни сложности:\n"
    + "1 - легкий\n"
    + "2 - базовый\n"
    + "3 - повышенный\n","/start_test","/start_test [уровень сложности]");
    @Override
    public SendMessage buildResponse(Update update) {
        return new SendMessage(update.getMessage().getChatId().toString(),HELP_MESSAGE);
    }

    @Override
    public String getCommandIdentifier() {
        return HELP.getCommandName();
    }
}

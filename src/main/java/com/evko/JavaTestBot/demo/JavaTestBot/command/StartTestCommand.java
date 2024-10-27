package com.evko.JavaTestBot.demo.JavaTestBot.command;

import com.evko.JavaTestBot.demo.JavaTestBot.dto.Test;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.QuestionType;
import com.evko.JavaTestBot.demo.JavaTestBot.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashSet;

import static com.evko.JavaTestBot.demo.JavaTestBot.command.CommandName.START_TEST;
@Component
@RequiredArgsConstructor
public class StartTestCommand extends AbstractCommand {
    private final TestService testService;
    @Override
    public SendMessage buildResponse(Update update) {
        Integer difficulty = parseDifficulty(update);
        HashSet<Test> filteredTests = testService.getTests(difficulty);

        StringBuilder response = new StringBuilder("Ваш тест:\n\n");
        filteredTests.forEach(test -> {
            response.append("Вопрос: ").append(test.getQuestionText()).append("\n");

            // Проверяем тип вопроса и выводим варианты ответов только для MULTIPLE_CHOICE
            if (test.getQuestionType() == QuestionType.MULTIPLE_CHOICE) {
                for (int i = 0; i < test.getAnswerOptions().size(); i++) {
                    response.append(i + 1).append(". ").append(test.getAnswerOptions().get(i)).append("\n");
                }
            } else {
                response.append("Это вопрос с открытым ответом.\n"); // Вывод для открытых вопросов
            }
            response.append("\n");
        });

        return new SendMessage(update.getMessage().getChatId().toString(), response.toString());
    }
    private Integer parseDifficulty(Update update) {
        String[] messageParts = update.getMessage().getText().split(" ");
        return (messageParts.length > 1) ? Integer.parseInt(messageParts[1]) : null; // null означает отсутствие фильтра
    }

    @Override
    public String getCommandIdentifier() {
        return START_TEST.getCommandName();
    }
}

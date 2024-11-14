package com.evko.JavaTestBot.demo.JavaTestBot.command;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.AnswerRepository;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.TestQuestionRepository;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Question;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Test;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.TgUser;
import com.evko.JavaTestBot.demo.JavaTestBot.service.CurResultsService;
import com.evko.JavaTestBot.demo.JavaTestBot.service.QuestionService;
import com.evko.JavaTestBot.demo.JavaTestBot.service.TestResultService;
import com.evko.JavaTestBot.demo.JavaTestBot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

import static com.evko.JavaTestBot.demo.JavaTestBot.command.CommandName.FINISH;
@Component
@RequiredArgsConstructor
public class FinishCommand extends AbstractCommand{
    private final UserService userService;
    private final QuestionService questionService;
    private final TestQuestionRepository testQuestionRepository;
    private final CurResultsService curResultsService;
    private final AnswerRepository answerRepository;
    private final TestResultService testResultService;
    @Override
    public BotApiMethod<?> buildResponse(Update update) {
        Long chatId;
        if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
        } else {
            throw new IllegalArgumentException("Update does not contain a valid message or callback query.");
        }
        TgUser tgUser=userService.getOrCreateUser(update.getCallbackQuery().getFrom().getId(),update.getCallbackQuery().getFrom().getUserName());
        Test currentTest=testQuestionRepository.getTestQuestionByQuestion(questionService.getQuestionsForUser(chatId).get(0)).getTest();
        int score = calculateScore(tgUser);
        testResultService.saveTestResult(tgUser,currentTest,score);
        curResultsService.deleteByUser(tgUser);
        questionService.clearCache(chatId);
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText("Тест завершен. Ваш результат: " + score+" б");
        return message;
    }
    private int calculateScore(TgUser user) {
        List<Long> answerIds = curResultsService.findAnswerIdsByUserId(user.getId());
        int score = 0;
        for (Long answerId : answerIds) {
            // Подсчитайте счет на основе правильных ответов
            // Например, используя метод для проверки правильности ответа
            if (answerRepository.isAnswerCorrect(answerId)) {
                score++;
            }
        }
        return score;
    }

    @Override
    public String getCommandIdentifier() {
        return FINISH.getCommandName();
    }
}

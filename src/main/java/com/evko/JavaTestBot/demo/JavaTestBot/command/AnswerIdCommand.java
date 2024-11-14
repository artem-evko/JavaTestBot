package com.evko.JavaTestBot.demo.JavaTestBot.command;

import com.evko.JavaTestBot.demo.JavaTestBot.keyboard.CombinedKeyboard;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.AnswerRepository;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Question;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.TgUser;
import com.evko.JavaTestBot.demo.JavaTestBot.service.CurResultsService;
import com.evko.JavaTestBot.demo.JavaTestBot.service.QuestionService;
import com.evko.JavaTestBot.demo.JavaTestBot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static com.evko.JavaTestBot.demo.JavaTestBot.command.CommandName.ANSWER;

@Component
@RequiredArgsConstructor
public class AnswerIdCommand extends AbstractCommand {
    private final AnswerRepository answerRepository;
    private final UserService userService;
    private final CurResultsService curResultsService;
    private final QuestionService QuestionService;

    @Override
    public BotApiMethod<?> buildResponse(Update update) {
        String[] messageParts = update.getCallbackQuery().getData().split(" ");
        Long answerId = Long.parseLong(messageParts[1]);
        Long chatId;
        if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
        } else {
            throw new IllegalArgumentException("Update does not contain a valid message or callback query.");
        }
        Long telegramId = update.getCallbackQuery().getFrom().getId();
        TgUser user = userService.getOrCreateUser(telegramId, update.getCallbackQuery().getFrom().getUserName());

        boolean isCorrect = answerRepository.isAnswerCorrect(answerId);
        Long questionId = answerRepository.findAnswerById(answerId).getQuestion().getId();

        curResultsService.saveOrUpdateResult(user, questionId, answerId, isCorrect);
        Long userId = userService.findByTelegramId(telegramId)
                .map(TgUser::getId) // Извлекаем id пользователя
                .orElseThrow(() -> new RuntimeException("User not found with telegramId: " + telegramId));

        List<Long> selectedAnswersId=curResultsService.findAnswerIdsByUserId(userId);

        EditMessageText editMessage = new EditMessageText();
        editMessage.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
        editMessage.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        editMessage.setText(update.getCallbackQuery().getMessage().getText());

        List<Question> questionList = QuestionService.getQuestionsForUser(chatId);
        Long questionIndex = getQuestionIndexById(questionList, questionId);
        editMessage.setReplyMarkup(CombinedKeyboard.createCombinedKeyboard(questionList, questionIndex, selectedAnswersId));
        return editMessage;
    }

    public Long getQuestionIndexById(List<Question> questionList, Long questionId) {
        OptionalInt optionalIndex = IntStream.range(0, questionList.size())
                .filter(index -> questionList.get(index).getId().equals(questionId))
                .findFirst();

        return optionalIndex.isPresent() ? (long) optionalIndex.getAsInt() : null; // Преобразуем индекс в Long или возвращаем null
    }

    @Override
    public String getCommandIdentifier() {
        return ANSWER.getCommandName();
    }
}

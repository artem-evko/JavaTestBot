package com.evko.JavaTestBot.demo.JavaTestBot.command;

import com.evko.JavaTestBot.demo.JavaTestBot.keyboard.CombinedKeyboard;
import com.evko.JavaTestBot.demo.JavaTestBot.keyboard.NavKeyboard;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.CurResults;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Question;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.QuestionType;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.TgUser;
import com.evko.JavaTestBot.demo.JavaTestBot.service.CurResultsService;
import com.evko.JavaTestBot.demo.JavaTestBot.service.QuestionService;
import com.evko.JavaTestBot.demo.JavaTestBot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.List;

import static com.evko.JavaTestBot.demo.JavaTestBot.command.CommandName.QUESTION;
@Component
@RequiredArgsConstructor
public class QuestionIdCommand extends AbstractCommand{
    private final QuestionService QuestionService;
    private final CurResultsService curResultsService;
    private final UserService userService;

    @Override
    public BotApiMethod<?> buildResponse(Update update) {
        Long chatId;
        Integer messageId;
        long questionIndex;

        if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
            messageId = update.getCallbackQuery().getMessage().getMessageId();
            questionIndex = parseQuestionIndex(update.getCallbackQuery().getData());
        } else {
            throw new IllegalArgumentException("Update does not contain a valid callback query.");
        }

        // Получаем список вопросов для пользователя
        List<Question> questionList = QuestionService.getQuestionsForUser(chatId);

        if (questionIndex < 0 || questionIndex >= questionList.size()) {
            throw new IllegalArgumentException("Invalid question index.");
        }

        // Получаем текущий вопрос
        Question currentQuestion = questionList.get(Math.toIntExact(questionIndex));
        Long userId = userService.findByTelegramId(chatId)
                .map(TgUser::getId) // Извлекаем id пользователя
                .orElseThrow(() -> new RuntimeException("User not found with telegramId: " + chatId));
        List<Long> selectedAnswersId=curResultsService.findAnswerIdsByUserId(userId);
        InlineKeyboardMarkup newKeyboardMarkup = CombinedKeyboard.createCombinedKeyboard(questionList, questionIndex,selectedAnswersId);

        // Проверяем, изменилось ли содержимое сообщения или клавиатура
        if (isMessageChanged(update.getCallbackQuery().getMessage(), currentQuestion.getText(), newKeyboardMarkup)) {
            EditMessageText editMessage = new EditMessageText();
            editMessage.setChatId(chatId);
            editMessage.setMessageId(messageId);
            editMessage.setText(currentQuestion.getText());
            editMessage.setReplyMarkup(newKeyboardMarkup);
            return editMessage;
        }

        return null;
    }

    private Long parseQuestionIndex(String data) {
        return Long.parseLong(data.split(" ")[1]);
    }
    private boolean isMessageChanged(Message currentMessage, String newText, InlineKeyboardMarkup newKeyboard) {
        String currentText = currentMessage.getText();
        InlineKeyboardMarkup currentKeyboard = (InlineKeyboardMarkup) currentMessage.getReplyMarkup();

        return !newText.equals(currentText) || !newKeyboard.equals(currentKeyboard);
    }
    @Override
    public String getCommandIdentifier() {
        return QUESTION.getCommandName();
    }
}

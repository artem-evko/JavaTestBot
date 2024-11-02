package com.evko.JavaTestBot.demo.JavaTestBot.command;

import com.evko.JavaTestBot.demo.JavaTestBot.keyboard.CombinedKeyboard;
import com.evko.JavaTestBot.demo.JavaTestBot.keyboard.NavKeyboard;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Question;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.QuestionType;
import com.evko.JavaTestBot.demo.JavaTestBot.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.List;

import static com.evko.JavaTestBot.demo.JavaTestBot.command.CommandName.TEST;
@Component
@RequiredArgsConstructor
public class TestIdCommand extends AbstractCommand{
    private final QuestionService questionService;
    @Override
    public BotApiMethod<?> buildResponse(Update update) {
        SendMessage sendMessage = new SendMessage();
        Long chatId;
        if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
        } else {
            throw new IllegalArgumentException("Update does not contain a valid message or callback query.");
        }
        List<Question> questionList=questionService.getQuestionsForUser(chatId,parseTestId(update.getCallbackQuery().getData()));
        sendMessage.setChatId(chatId);
        sendMessage.setText(questionList.get(0).getText());
        sendMessage.setReplyMarkup(CombinedKeyboard.createCombinedKeyboard(questionList,0));


        return sendMessage;
    }
    private Long parseTestId(String message){
        return Long.parseLong(message.split(" ")[1]);
    }

    @Override
    public String getCommandIdentifier() {
        return TEST.getCommandName();
    }
}

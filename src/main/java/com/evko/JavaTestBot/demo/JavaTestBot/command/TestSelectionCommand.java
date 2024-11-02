package com.evko.JavaTestBot.demo.JavaTestBot.command;

import com.evko.JavaTestBot.demo.JavaTestBot.keyboard.TestSelectionKeyboard;
import com.evko.JavaTestBot.demo.JavaTestBot.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import static com.evko.JavaTestBot.demo.JavaTestBot.command.CommandName.TEST_SELECTION;
@Component
@RequiredArgsConstructor
public class TestSelectionCommand extends AbstractCommand{
    private final TestService testService;
    @Override
    public SendMessage buildResponse(Update update) {
        SendMessage sendMessage = new SendMessage();

        // Получение chatId
        Long chatId;
        if (update.hasMessage() && update.getMessage().hasText()) {
            chatId = update.getMessage().getChatId();
        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
        } else {
            throw new IllegalArgumentException("Update does not contain a valid message or callback query.");
        }

        sendMessage.setChatId(chatId.toString());
        sendMessage.setText("Выберете нужный тест");
        InlineKeyboardMarkup markupInline = TestSelectionKeyboard.createTestSelectionKeyboard(testService);
        sendMessage.setReplyMarkup(markupInline);

        return sendMessage;
    }

    @Override
    public String getCommandIdentifier() {
        return TEST_SELECTION.getCommandName();
    }
}

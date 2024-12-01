package com.evko.JavaTestBot.demo.JavaTestBot.keyboard;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class StartKeyboard {
    public static InlineKeyboardMarkup GetStartKeyboard() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Выбрать тест");
        inlineKeyboardButton1.setCallbackData("/test_selection");
//        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
//        inlineKeyboardButton2.setText("To do");
//        inlineKeyboardButton2.setCallbackData("nothing");
        rowInline1.add(inlineKeyboardButton1);
//        rowInline1.add(inlineKeyboardButton2);
        rowsInline.add(rowInline1);
        markupInline.setKeyboard(rowsInline);
        return markupInline;
    }
}

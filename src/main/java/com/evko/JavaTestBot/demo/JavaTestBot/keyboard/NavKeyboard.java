package com.evko.JavaTestBot.demo.JavaTestBot.keyboard;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Question;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class NavKeyboard {
    public static List<List<InlineKeyboardButton>> createNavKeyboard(List<Question> questionList) {
        List<List<InlineKeyboardButton>> navButtons = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        for (int i = 0; i < questionList.size(); i++) {
            Question question = questionList.get(i);
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(String.valueOf(i + 1)); // Задайте нужный текст кнопки
            button.setCallbackData("/question " + i); // Установите уникальные callback данные для кнопки

            row.add(button);

            // Если строка достигла 7 кнопок, добавляем её в navButtons и начинаем новую строку
            if (row.size() == 7) {
                navButtons.add(row);
                row = new ArrayList<>();
            }
        }

        // Добавляем оставшиеся кнопки (если их меньше 7) как последнюю строку
        if (!row.isEmpty()) {
            navButtons.add(row);
        }
        return navButtons;
    }
}

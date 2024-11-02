package com.evko.JavaTestBot.demo.JavaTestBot.keyboard;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Answer;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Question;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class AnswerKeyboard {
    public static List<List<InlineKeyboardButton>> createAnswerButtons(Question question) {
        List<List<InlineKeyboardButton>> answerButtons = new ArrayList<>();

        for (Answer answer : question.getAnswers()) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(answer.getText());
            button.setCallbackData("answer" + answer.getId());

            List<InlineKeyboardButton> row = new ArrayList<>();
            row.add(button);
            answerButtons.add(row);
        }

        return answerButtons;
    }
}

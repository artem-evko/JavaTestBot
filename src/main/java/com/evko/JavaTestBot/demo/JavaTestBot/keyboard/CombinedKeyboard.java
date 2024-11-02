package com.evko.JavaTestBot.demo.JavaTestBot.keyboard;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Question;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.QuestionType;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.QuestionType.*;
import java.util.ArrayList;
import java.util.List;

public class CombinedKeyboard {
    public static InlineKeyboardMarkup createCombinedKeyboard(List<Question> questionList,int questionId) {
        List<List<InlineKeyboardButton>> combinedButtons = new ArrayList<>();

        // Добавляем кнопки вопросов
        combinedButtons.addAll(NavKeyboard.createNavKeyboard(questionList));
        // Добавляем кнопки ответов вопроса
        if(questionList.get(questionId).getQuestionType()== QuestionType.MULTIPLE_CHOICE)
        {
            combinedButtons.addAll(AnswerKeyboard.createAnswerButtons(questionList.get(questionId)));
        }

        combinedButtons.add(PrevNextButtons.createPrevNextButtons(questionList,questionId));


        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        keyboardMarkup.setKeyboard(combinedButtons);
        return keyboardMarkup;
    }
}

package com.evko.JavaTestBot.demo.JavaTestBot.keyboard;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Question;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class PrevNextButtons {
    public static List<InlineKeyboardButton> createPrevNextButtons(List<Question>questionList,int id) {
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        if(id==0)
        {
            InlineKeyboardButton nextButton=new InlineKeyboardButton();
            nextButton.setText("Следующий вопрос");
            nextButton.setCallbackData("question "+1);
            rowInline.add(nextButton);
            return rowInline;
        } else if (id==questionList.size()-1) {
            InlineKeyboardButton prevButton=new InlineKeyboardButton();
            prevButton.setText("Предыдущий вопрос");
            prevButton.setCallbackData("question "+(questionList.size()-1));
            rowInline.add(prevButton);
            return rowInline;
        }
        InlineKeyboardButton prevButton=new InlineKeyboardButton();
        prevButton.setText("Предыдущий вопрос");
        prevButton.setCallbackData("question "+(id-1));
        rowInline.add(prevButton);

        InlineKeyboardButton nextButton=new InlineKeyboardButton();
        nextButton.setText("Следующий вопрос");
        nextButton.setCallbackData("question "+(id+1));
        rowInline.add(nextButton);

        return rowInline;
    }
}

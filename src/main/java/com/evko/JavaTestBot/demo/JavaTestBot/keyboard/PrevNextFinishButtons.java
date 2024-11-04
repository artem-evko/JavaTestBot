package com.evko.JavaTestBot.demo.JavaTestBot.keyboard;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Question;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class PrevNextFinishButtons {
    public static List<List<InlineKeyboardButton>> createPrevNextButtons(List<Question>questionList,int id) {
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline=new ArrayList<>();
        if(id==0)
        {
            InlineKeyboardButton nextButton=new InlineKeyboardButton();
            nextButton.setText("Следующий вопрос");
            nextButton.setCallbackData("/question "+1);
            rowInline.add(nextButton);
            rowsInline.add(rowInline);
            return rowsInline;
        } else if (id==questionList.size()-1) {
            List<InlineKeyboardButton> finishRow=new ArrayList<>();
            InlineKeyboardButton prevButton=new InlineKeyboardButton();
            prevButton.setText("Предыдущий вопрос");
            prevButton.setCallbackData("/question "+(questionList.size()-2));
            rowInline.add(prevButton);
            rowsInline.add(rowInline);
            InlineKeyboardButton finishButton=new InlineKeyboardButton();
            finishButton.setText("!Завершить тест!");
            finishButton.setCallbackData("/finish");
            finishRow.add(finishButton);
            rowsInline.add(finishRow);
            return rowsInline;
        }
        InlineKeyboardButton prevButton=new InlineKeyboardButton();
        prevButton.setText("Предыдущий вопрос");
        prevButton.setCallbackData("/question "+(id-1));
        rowInline.add(prevButton);

        InlineKeyboardButton nextButton=new InlineKeyboardButton();
        nextButton.setText("Следующий вопрос");
        nextButton.setCallbackData("/question "+(id+1));
        rowInline.add(nextButton);

        rowsInline.add(rowInline);

        return rowsInline;
    }
}

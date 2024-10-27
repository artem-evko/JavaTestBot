package com.evko.JavaTestBot.demo.JavaTestBot.dto;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.QuestionType;
import lombok.Data;

import java.util.List;
@Data
public class Test {
    private int id;
    private String questionText;
    private int difficulty;
    private QuestionType questionType;
    private List<String> answerOptions;

    public Test(int id, String questionText, int difficulty, QuestionType questionType, List<String> answerOptions) {
        this.id = id;
        this.questionText = questionText;
        this.difficulty = difficulty;
        this.questionType = questionType;
        this.answerOptions = answerOptions;
    }
}

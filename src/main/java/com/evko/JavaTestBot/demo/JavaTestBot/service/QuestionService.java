package com.evko.JavaTestBot.demo.JavaTestBot.service;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.QuestionRepositoryCustom;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepositoryCustom questionRepositoryCustom;

    public List<Question> getQuestions(Long testId){
        return questionRepositoryCustom.findQuestionsByTestId(testId);
    }
}

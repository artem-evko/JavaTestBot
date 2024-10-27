package com.evko.JavaTestBot.demo.JavaTestBot.service;

import com.evko.JavaTestBot.demo.JavaTestBot.dto.Test;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.QuestionRepository;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Question;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Answer;

import javax.annotation.PostConstruct;

@Service
public class TestService {
    private final QuestionRepository questionRepository;
    private HashSet<Test> tests;

    @Autowired
    public TestService(QuestionRepository questionRepository) {
            this.questionRepository = questionRepository;
    }
    @PostConstruct
    private void loadTests() {
        List<Question> questions = questionRepository.findAll();
        tests = questions.stream()
                .map(question -> new Test(question.getId(),
                        question.getText(),
                        question.getDifficulty(),
                        question.getQuestionType(),
                        question.getAnswers().stream()
                                .map(Answer::getText)
                                .collect(Collectors.toList())))
                .collect(Collectors.toCollection(HashSet::new));
    }
    public HashSet<Test> getTests(Integer difficulty) {
        return tests.stream()
                .filter(test -> difficulty == null || test.getDifficulty() == difficulty) // Если difficulty == null, не фильтруем
                .collect(Collectors.toCollection(HashSet::new));
    }
}

package com.evko.JavaTestBot.demo.JavaTestBot.service;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.TestResultRepository;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Test;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.TestResult;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.TgUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestResultService {
    private final TestResultRepository testResultRepository;
    public TestResult saveTestResult(TgUser user, Test test, int score) {
        TestResult result = new TestResult();
        result.setUser(user);
        result.setTest(test);
        result.setScore(score);
        result.setCompletedAt(LocalDateTime.now());
        return testResultRepository.save(result);

    }
    public List<TestResult> getResultsByUser(TgUser user) {
        return testResultRepository.findByUser(user);
    }
}

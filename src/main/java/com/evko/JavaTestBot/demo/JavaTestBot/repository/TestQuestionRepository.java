package com.evko.JavaTestBot.demo.JavaTestBot.repository;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Question;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Test;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.TestQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestQuestionRepository extends JpaRepository<TestQuestion,Long> {
    TestQuestion getTestQuestionByQuestion(Question question);
}

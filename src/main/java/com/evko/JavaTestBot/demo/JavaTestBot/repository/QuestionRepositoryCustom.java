package com.evko.JavaTestBot.demo.JavaTestBot.repository;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Question;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class QuestionRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Question> findQuestionsByTestId(Long testId) {
        String query = "SELECT q FROM Question q JOIN TestQuestion tq ON q.id = tq.question.id WHERE tq.test.id = :testId";
        return entityManager.createQuery(query, Question.class)
                .setParameter("testId", testId)
                .getResultList();
    }
}

package com.evko.JavaTestBot.demo.JavaTestBot.repository;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
//    @Query("SELECT q FROM Question q JOIN FETCH q.answers WHERE q.id IN " +
//            "(SELECT tq.question.id FROM TestQuestion tq WHERE tq.test.id = :testId)")
//    List<Question> findQuestionsByTestId(@Param("testId") int testId);
}

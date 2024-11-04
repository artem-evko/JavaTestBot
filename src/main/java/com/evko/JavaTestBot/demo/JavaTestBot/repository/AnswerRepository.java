package com.evko.JavaTestBot.demo.JavaTestBot.repository;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {

    @Query("SELECT a.isCorrect FROM Answer a WHERE a.id = :answerId")
    Boolean isAnswerCorrect(@Param("answerId") Long answerId);
    Answer findAnswerById(Long id);
}

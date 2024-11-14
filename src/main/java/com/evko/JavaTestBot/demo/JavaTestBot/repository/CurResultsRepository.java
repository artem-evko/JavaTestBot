package com.evko.JavaTestBot.demo.JavaTestBot.repository;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.CurResults;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.TgUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurResultsRepository extends JpaRepository<CurResults, Long> {
    Optional<CurResults> findByUserAndQuestionId(TgUser user, Long questionId);

    @Query("SELECT cr.answerId FROM CurResults cr WHERE cr.user.id = :userId")
    List<Long> findAnswerIdsByUserId(@Param("userId") Long userId);

    void deleteByUser(TgUser user);
}

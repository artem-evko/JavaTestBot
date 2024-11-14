package com.evko.JavaTestBot.demo.JavaTestBot.repository;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.TestResult;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.TgUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Integer> {
    List<TestResult> findByUser(TgUser user);
}

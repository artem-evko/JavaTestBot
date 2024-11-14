package com.evko.JavaTestBot.demo.JavaTestBot.repository;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test,Long> {
}

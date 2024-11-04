package com.evko.JavaTestBot.demo.JavaTestBot.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "test_result")
@Data
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne // Один пользователь может иметь много результатов тестирования
    @JoinColumn(name = "user_id", nullable = false)
    private TgUser user;

    @ManyToOne // Связь с тестом, для которого сохраняется результат
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;

    @Column(name = "score", nullable = false)
    private int score;

    @Column(name = "completed_at", nullable = false)
    private LocalDateTime completedAt;
}

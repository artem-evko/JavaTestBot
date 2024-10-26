package com.evko.JavaTestBot.demo.JavaTestBot.repository.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "test_result")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne // Один пользователь может иметь много результатов тестирования
    @JoinColumn(name = "user_id", nullable = false)
    private TgUser user;

    @Column(name = "score", nullable = false)
    private int score;

    @Column(name = "completed_at", nullable = false)
    private LocalDateTime completedAt;
}

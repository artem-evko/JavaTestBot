package com.evko.JavaTestBot.demo.JavaTestBot.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tg_user")
@Data
public class TgUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматическая генерация ID
    private Long id;

    @Column(name = "telegram_id", unique = true, nullable = false) // Уникальное значение, не может быть null
    private long telegramId;

    @Column(name = "username") // Необязательное поле
    private String username;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // Связь с TestResult
    private List<TestResult> testResults = new ArrayList<>();

}

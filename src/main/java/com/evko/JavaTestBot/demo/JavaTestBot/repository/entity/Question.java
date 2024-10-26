package com.evko.JavaTestBot.demo.JavaTestBot.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "question")
@EqualsAndHashCode
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "difficulty", nullable = false)
    private int difficulty;

    @Enumerated(EnumType.STRING) // Сохраняем значение как строку
    @Column(name = "question_type", nullable = false)
    private QuestionType questionType;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers; // Список ответов

}

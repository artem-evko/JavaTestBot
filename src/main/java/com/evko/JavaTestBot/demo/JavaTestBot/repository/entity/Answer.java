package com.evko.JavaTestBot.demo.JavaTestBot.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "answer")
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Много ответов могут принадлежать одному вопросу
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "is_correct", nullable = false)
    private boolean isCorrect;
}

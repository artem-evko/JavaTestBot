package com.evko.JavaTestBot.demo.JavaTestBot.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "test_question")
@Data
public class TestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}

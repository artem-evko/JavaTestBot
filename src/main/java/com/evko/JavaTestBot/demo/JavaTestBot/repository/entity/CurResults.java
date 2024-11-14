package com.evko.JavaTestBot.demo.JavaTestBot.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cur_results")
@Data
public class CurResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private TgUser user;

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "answer_id")  // Добавляем поле для идентификатора ответа
    private Long answerId;

    @Column(name = "is_correct")
    private boolean isCorrect;
}

package com.evko.JavaTestBot.demo.JavaTestBot.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "test")
@EqualsAndHashCode
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    public char[] getQuestionText() {
        return new char[0];
    }

    public boolean getQuestionType() {
        return false;
    }

    public List<Object> getAnswerOptions() {
        return List.of();
    }
}

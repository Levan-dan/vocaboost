package com.example.vocaboost.model;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "UserExercises")
public class UserExercise {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExercise;

    private Integer score;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private LessonContent content;

    public UserExercise() {
    }

    public UserExercise(Integer score, LocalDateTime submittedAt, User user, LessonContent content) {
        this.score = score;
        this.submittedAt = submittedAt;
        this.user = user;
        this.content = content;
    }

    public UserExercise(Long idExercise, Integer score, LocalDateTime submittedAt, User user, LessonContent content) {
        this.idExercise = idExercise;
        this.score = score;
        this.submittedAt = submittedAt;
        this.user = user;
        this.content = content;
    }

    public void setIdExercise(Long idExercise) {
        this.idExercise = idExercise;
    }
}


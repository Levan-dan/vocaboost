package com.example.vocaboost.model;



import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "UserLessonProgress")
public class UserLessonProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLessonP;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Column(name = "progress_percent")
    private Integer progressPercent;

    private Boolean completed;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "finished_at")
    private LocalDateTime finishedAt;

    public UserLessonProgress() {
    }

    public UserLessonProgress(User user, Lesson lesson, Integer progressPercent, Boolean completed, LocalDateTime startedAt, LocalDateTime finishedAt) {
        this.user = user;
        this.lesson = lesson;
        this.progressPercent = progressPercent;
        this.completed = completed;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
    }

    public UserLessonProgress(Long idLessonP, User user, Lesson lesson, Integer progressPercent, Boolean completed, LocalDateTime startedAt, LocalDateTime finishedAt) {
        this.idLessonP = idLessonP;
        this.user = user;
        this.lesson = lesson;
        this.progressPercent = progressPercent;
        this.completed = completed;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
    }

    public Long getIdLessonP() {
        return idLessonP;
    }

    public void setIdLessonP(Long idLessonP) {
        this.idLessonP = idLessonP;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Integer getProgressPercent() {
        return progressPercent;
    }

    public void setProgressPercent(Integer progressPercent) {
        this.progressPercent = progressPercent;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }
}
